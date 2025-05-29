package com.f2f;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date().toString(),ex.getMessage(),"");//request.getDescription(false));
        return new ResponseEntity<Object>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArrayStoreException.class)
    public ResponseEntity<?> accessDeniedException(Exception ex,WebRequest request){
        ArrayList<ErrorDetails> arrayList = new ArrayList<>();
        ErrorDetails error1 = new ErrorDetails(new Date().toString(),ex.getMessage(),"");//request.getDescription(false));
        ErrorDetails error2 = new ErrorDetails(new Date().toString(),"accessDenied","");//request.getDescription(false));
        arrayList.add(error1);
        //arrayList.add(new ErrorDetails(new Date(),ex.getCause().toString(),request.getDescription(false)));
        arrayList.add(error2);
        return new ResponseEntity<Object>(arrayList, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolationException(ConstraintViolationException ex, WebRequest request){
        String sqlMessage = ex.getLocalizedMessage();
        String errMsg = ex.getSQLException().getMessage();
        System.out.println(errMsg);
        System.out.println(sqlMessage);
        ArrayList<ErrorDetails> arrayList = new ArrayList<>();
        ErrorDetails error2 = new ErrorDetails(new Date().toString(),"sqlerror","");//request.getDescription(false));
        arrayList.add(error2);
        return new ResponseEntity<Object>(arrayList, HttpStatus.FORBIDDEN);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> f2fExceptionHandler(F2fException ex, WebRequest request){
//        ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
//        return new ResponseEntity<Object>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
