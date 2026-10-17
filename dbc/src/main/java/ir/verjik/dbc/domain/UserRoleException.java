package ir.verjik.dbc.domain;

public class UserRoleException extends RuntimeException{

    public UserRoleException(){
        super();
    }

    public UserRoleException(String message){
        super(message);
    }

}
