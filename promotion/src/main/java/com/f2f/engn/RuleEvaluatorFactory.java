package com.f2f.engn;

import com.f2f.entity.RuleCondition;

import java.time.*;
import java.util.Arrays;
import java.util.List;

public class RuleEvaluatorFactory {

    public static boolean evaluate(RuleCondition condition, Object contextValue) {
        if (contextValue == null) return false;

        String operator = condition.getOperator().toUpperCase();     // EQ, GT, IN, ...
        String value = condition.getValue();                         // e.g. "TEHRAN" or "10,20"
        String valueType = condition.getValueType().toUpperCase();  // STRING, NUMBER, ENUM, DATE, BOOLEAN, TIME, DAYOFWEEK

        return switch (operator) {
            case "EQ" -> isEqual(contextValue, value, valueType);
            case "NEQ" -> !isEqual(contextValue, value, valueType);
            case "GT" -> isGreater(contextValue, value, valueType);
            case "GTE" -> isGreaterOrEqual(contextValue, value, valueType);
            case "LT" -> isLess(contextValue, value, valueType);
            case "LTE" -> isLessOrEqual(contextValue, value, valueType);
            case "IN" -> isIn(contextValue, value, valueType);
            case "BETWEEN" -> isBetween(contextValue, value, valueType);
            case "IS_BIRTHDAY" -> isBirthday(contextValue);
            default -> false;
        };
    }

    private static boolean isBirthday(Object ctx) {
        if (!(ctx instanceof LocalDate birthDate)) return false;
        LocalDate today = LocalDate.now();
        return birthDate.getDayOfMonth() == today.getDayOfMonth() &&
                birthDate.getMonthValue() == today.getMonthValue();
    }

    private static boolean isEqual(Object ctx, String val, String type) {
        return switch (type) {
            case "NUMBER" -> Long.parseLong(val) == ((Number) ctx).longValue();
            case "STRING" -> val.equalsIgnoreCase(ctx.toString());
            case "ENUM" -> val.equalsIgnoreCase(ctx.toString());
            case "BOOLEAN" -> Boolean.parseBoolean(val) == (Boolean) ctx;
            case "DATE" -> LocalDate.parse(val).equals((LocalDate) ctx);
            case "TIME" -> LocalTime.parse(val).equals((LocalTime) ctx);
            case "DAYOFWEEK" -> DayOfWeek.valueOf(val.toUpperCase()) == ctx;
            default -> false;
        };
    }

    private static boolean isGreater(Object ctx, String val, String type) {
        return switch (type) {
            case "NUMBER" -> ((Number) ctx).longValue() > Long.parseLong(val);
            case "DATE" -> ((LocalDate) ctx).isAfter(LocalDate.parse(val));
            case "TIME" -> ((LocalTime) ctx).isAfter(LocalTime.parse(val));
            default -> false;
        };
    }

    private static boolean isGreaterOrEqual(Object ctx, String val, String type) {
        return switch (type) {
            case "NUMBER" -> ((Number) ctx).longValue() >= Long.parseLong(val);
            case "DATE" -> !((LocalDate) ctx).isBefore(LocalDate.parse(val));
            case "TIME" -> !((LocalTime) ctx).isBefore(LocalTime.parse(val));
            default -> false;
        };
    }

    private static boolean isLess(Object ctx, String val, String type) {
        return switch (type) {
            case "NUMBER" -> ((Number) ctx).longValue() < Long.parseLong(val);
            case "DATE" -> ((LocalDate) ctx).isBefore(LocalDate.parse(val));
            case "TIME" -> ((LocalTime) ctx).isBefore(LocalTime.parse(val));
            default -> false;
        };
    }

    private static boolean isLessOrEqual(Object ctx, String val, String type) {
        return switch (type) {
            case "NUMBER" -> ((Number) ctx).longValue() <= Long.parseLong(val);
            case "DATE" -> !((LocalDate) ctx).isAfter(LocalDate.parse(val));
            case "TIME" -> !((LocalTime) ctx).isAfter(LocalTime.parse(val));
            default -> false;
        };
    }

    private static boolean isIn(Object ctx, String val, String type) {
        List<String> values = Arrays.stream(val.split(","))
                .map(String::trim)
                .toList();

        return switch (type) {
            case "STRING", "ENUM", "DAYOFWEEK" -> values.stream()
                    .anyMatch(v -> v.equalsIgnoreCase(ctx.toString()));
            case "NUMBER" -> values.stream()
                    .map(Long::parseLong)
                    .anyMatch(v -> v == ((Number) ctx).longValue());
            default -> false;
        };
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
            case "TIME" -> {
                LocalTime time = (LocalTime) ctx;
                yield !time.isBefore(LocalTime.parse(v1)) && !time.isAfter(LocalTime.parse(v2));
            }
            default -> false;
        };
    }
}
