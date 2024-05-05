package com.f2f.exceptions;


import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class F2fErrorResponse extends F2fResponse{

    private HttpStatus staus ;
    private String errorCode ;
    private String message ;
    private String detail;
    private LocalDateTime dateTime;

    private F2fErrorResponse(){

    }

    public static final class F2fErrorBuilder {
        private HttpStatus staus;
        private String errorCode;
        private String message;
        private String detail;
        private LocalDateTime dateTime;

        public static F2fErrorBuilder anF2FerrorBuilder() {
            return new F2fErrorBuilder();
        }

        public F2fErrorBuilder withErrorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public F2fErrorBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public F2fErrorBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public F2fErrorBuilder withStatus(HttpStatus status) {
            this.staus = status;
            return this;
        }

        public F2fErrorBuilder atTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public F2fErrorResponse build() {
            F2fErrorResponse response = new F2fErrorResponse();
            response.staus = this.staus;
            response.detail = this.detail;
            response.message = this.message;
            response.dateTime = this.dateTime;
            response.errorCode = this.errorCode;
            return response;
        }
    }
}
