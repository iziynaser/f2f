package com.f2f.engn;

import com.f2f.entity.RuleCondition;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class RuleEvaluatorFactory {

    public static boolean evaluate(RuleCondition condition, Object contextValue) {
        if (contextValue == null) return false;

        String operator = condition.getOperator().toUpperCase();
        String value = condition.getValue();
        String valueType = condition.getValueType().toUpperCase();

        return switch (operator) {
            case "EQ" -> isEqual(contextValue, value, valueType);
            case "GT" -> isGreater(contextValue, value, valueType);
            case "GTE" -> isGreaterOrEqual(contextValue, value, valueType);
            case "LT" -> isLess(contextValue, value, valueType);
            case "LTE" -> isLessOrEqual(contextValue, value, valueType);
            case "IN" -> isIn(contextValue, value, valueType);
            case "BETWEEN" -> isBetween(contextValue, value, valueType);
            default -> false;
        };
    }

    private static boolean isEqual(Object ctx, String val, String type) {
        return switch (type) {
            case "NUMBER" -> Long.parseLong(val) == ((Number) ctx).longValue();
            case "STRING" -> val.equals(ctx.toString());
            case "ENUM" -> val.equalsIgnoreCase(ctx.toString());
            case "DATE" -> LocalDate.parse(val).equals((LocalDate) ctx);
            default -> false;
        };
    }

    private static boolean isGreater(Object ctx, String val, String type) {
        return switch (type) {
            case "NUMBER" -> ((Number) ctx).longValue() > Long.parseLong(val);
            case "DATE" -> ((LocalDate) ctx).isAfter(LocalDate.parse(val));
            default -> false;
        };
    }

    private static boolean isGreaterOrEqual(Object ctx, String val, String type) {
        return switch (type) {
            case "NUMBER" -> ((Number) ctx).longValue() >= Long.parseLong(val);
            case "DATE" -> !((LocalDate) ctx).isBefore(LocalDate.parse(val));
            default -> false;
        };
    }

    private static boolean isLess(Object ctx, String val, String type) {
        return switch (type) {
            case "NUMBER" -> ((Number) ctx).longValue() < Long.parseLong(val);
            case "DATE" -> ((LocalDate) ctx).isBefore(LocalDate.parse(val));
            default -> false;
        };
    }

    private static boolean isLessOrEqual(Object ctx, String val, String type) {
        return switch (type) {
            case "NUMBER" -> ((Number) ctx).longValue() <= Long.parseLong(val);
            case "DATE" -> !((LocalDate) ctx).isAfter(LocalDate.parse(val));
            default -> false;
        };
    }

    private static boolean isIn(Object ctx, String val, String type) {
        List<String> values = Arrays.asList(val.split(","));
        return values.stream().anyMatch(v -> v.trim().equalsIgnoreCase(ctx.toString()));
    }

    private static boolean isBetween(Object ctx, String val, String type) {
        String[] parts = val.split(",");
        if (parts.length != 2) return false;
        String v1 = parts[0].trim();
        String v2 = parts[1].trim();

        return switch (type) {
            case "NUMBER" -> {
                long num = ((Number) ctx).longValue();
                yield num >= Long.parseLong(v1) && num <= Long.parseLong(v2);
            }
            case "DATE" -> {
                LocalDate date = (LocalDate) ctx;
                yield !date.isBefore(LocalDate.parse(v1)) && !date.isAfter(LocalDate.parse(v2));
            }
            default -> false;
        };
    }
}
