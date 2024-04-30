package com.f2f.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class F2fSuccessResponse extends F2fResponse{
    private HttpStatus staus ;
    private String errorCode ;
    private String message ;
    private String detail;
    private LocalDateTime dateTime;
    private Object body;

    private F2fSuccessResponse(){

    }

    public static final class F2fSuccessBuilder {
        private HttpStatus staus;
        private String errorCode;
        private String message;
        private String detail;
        private LocalDateTime dateTime;
        private Object body;

        public F2fSuccessBuilder withBody(Object body) {
            this.body = body;
            return this;
        }

        public F2fSuccessResponse build() {
            F2fSuccessResponse response = new F2fSuccessResponse();
            response.staus = HttpStatus.OK;
            response.detail = "successfully done";
            response.message = "successfully done";
            response.dateTime = LocalDateTime.now(ZoneOffset.UTC);
            response.errorCode = "0";
            response.body= this.body;
            return response;
        }
    }

}
