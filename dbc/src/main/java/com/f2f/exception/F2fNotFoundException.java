package com.f2f.exception;

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
