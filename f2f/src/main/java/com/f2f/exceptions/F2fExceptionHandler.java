package com.f2f.exceptions;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@ControllerAdvice
public class F2fExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<F2fErrorResponse> f2fException(Exception ex, HttpHeaders headers, HttpStatus status, WebRequest request){
//        F2fErrorResponse response = new F2fErrorResponse.F2fErrorBuilder()
//            .withErrorCode("502")
//            .withMessage("global exception")
//            .withStatus(HttpStatus.NOT_FOUND)
//            .atTime(LocalDateTime.now(ZoneOffset.UTC))
//            .build();
//        return new ResponseEntity<F2fErrorResponse>(response,HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(value = EntityNotFoundException.class)
//    public ResponseEntity<F2fErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex,HttpHeaders headers,HttpStatus status,WebRequest request){
//        F2fErrorResponse response = new F2fErrorResponse.F2fErrorBuilder()
//            .withErrorCode("702")
//            .withMessage("entity not found exception")
//            .withStatus(HttpStatus.NOT_FOUND)
//            .atTime(LocalDateTime.now(ZoneOffset.UTC))
//            .build();
//        return new ResponseEntity<F2fErrorResponse>(response,HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler({AuthenticationException.class,BadCredentialsException.class,InsufficientAuthenticationException.class})
//    public ResponseEntity<F2fErrorResponse> handleAuthenticationException(AuthenticationException ex,HttpHeaders headers,HttpStatus status,WebRequest request){
//        F2fErrorResponse response = new F2fErrorResponse.F2fErrorBuilder()
//            .withErrorCode("702")
//            .withMessage("entity not found exception")
//            .withStatus(HttpStatus.NOT_FOUND)
//            .atTime(LocalDateTime.now(ZoneOffset.UTC))
//            .build();
//        return new ResponseEntity<F2fErrorResponse>(response,HttpStatus.NOT_FOUND);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        F2fErrorResponse response = new F2fErrorResponse.F2fErrorBuilder()
//            .withErrorCode("406")
//            .withMessage("not invalid arguments")
//            .withDetail(ex.getLocalizedMessage())
//            .withStatus(status)
//            .atTime(LocalDateTime.now(ZoneOffset.UTC))
//            .build();
//        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
//    }
//
//
//    @ExceptionHandler({ConstraintViolationException.class,SQLIntegrityConstraintViolationException.class})
//    public ResponseEntity<F2fErrorResponse> handleConstraintViolationException(ConstraintViolationException ex,HttpHeaders headers,HttpStatus status,WebRequest request){
//        return getF2fErrorResponseResponseEntity(ex, status);
//    }
//
//    private ResponseEntity<F2fErrorResponse> getF2fErrorResponseResponseEntity(ConstraintViolationException ex, HttpStatus status) {
//        F2fErrorResponse response = new F2fErrorResponse.F2fErrorBuilder()
//            .withErrorCode("500")
//            .withMessage("constraint error")
//            .withStatus(status)
//            .withDetail(ex.getLocalizedMessage())
//            .atTime(LocalDateTime.now(ZoneOffset.UTC))
//            .build();
//        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
//    }

//    private ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex,HttpStatus status){
//        F2fErrorResponse response = new F2fErrorResponse.F2fErrorBuilder()
//            .withErrorCode("206")
//            .withMessage("invalid input")
//            .withStatus(status)
//            .withDetail(ex.toString())
//            .atTime(LocalDateTime.now(ZoneOffset.UTC))
//            .build();
//        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
//    }
//
//    @ExceptionHandler(value = F2fNotFoundException.class)
//    public ResponseEntity<F2fErrorResponse> handleF2fNotFoundException(F2fNotFoundException ex){
//        F2fErrorResponse response = new F2fErrorResponse.F2fErrorBuilder()
//            .withErrorCode("506")
//            .withMessage("entity not found exception")
//            .withStatus(HttpStatus.NOT_FOUND)
//            .atTime(LocalDateTime.now(ZoneOffset.UTC))
//            .build();
//        return new ResponseEntity<F2fErrorResponse>(response,HttpStatus.NOT_FOUND);
//    }
//
//    @Override
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        F2fErrorResponse response = new F2fErrorResponse.F2fErrorBuilder()
//            .withErrorCode("207")
//            .withMessage("malformed json request")
//            .withStatus(status)
//            .withDetail(ex.getLocalizedMessage())
//            .atTime(LocalDateTime.now(ZoneOffset.UTC))
//            .build();
//        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
//    }


}
