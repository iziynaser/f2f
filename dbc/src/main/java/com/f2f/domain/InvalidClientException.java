package com.f2f.domain;

import org.springframework.security.oauth2.provider.ClientRegistrationException;

public class InvalidClientException extends ClientRegistrationException {

	public InvalidClientException(String msg) {
        super(msg);
    }

    public InvalidClientException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
