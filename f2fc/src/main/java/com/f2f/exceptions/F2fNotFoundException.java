package com.f2f.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class F2fNotFoundException extends RuntimeException {

    private final String messageKey;
    private final Object[] args;

    public F2fNotFoundException(String messageKey, Object... args) {
        this.messageKey = messageKey;
        this.args = args;
    }
    public String getMessageKey() {
        return messageKey;
    }

    public Object[] getArgs() {
        return args;
    }
}
