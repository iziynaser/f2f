package com.revengemission.sso.oauth2.server.domain;

public class UserRoleException extends RuntimeException{

    public UserRoleException(){
        super();
    }

    public UserRoleException(String message){
        super(message);
    }

}
