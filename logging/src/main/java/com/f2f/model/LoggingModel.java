package com.f2f.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoggingModel {
    private String timeStamp ;
    private String className ;
    private String methodName ;
    private long executionTime ;
    private String level ;

    @Override
    public String toString() {
        return Gson().toJson(this);
    }

}
