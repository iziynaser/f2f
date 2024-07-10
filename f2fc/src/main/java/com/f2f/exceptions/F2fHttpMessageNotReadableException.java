package com.f2f.exceptions;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;

public class F2fHttpMessageNotReadableException extends HttpMessageNotReadableException {
    public F2fHttpMessageNotReadableException(String msg, HttpInputMessage httpInputMessage) {
        super(msg, httpInputMessage);
        System.out.println("F2F httpMessageNotReadable Exception");
    }

    public F2fHttpMessageNotReadableException(String msg, Throwable cause, HttpInputMessage httpInputMessage) {
        super(msg, cause, httpInputMessage);
        System.out.println("F2f httpMessageNotReadable Exception");
    }
}
