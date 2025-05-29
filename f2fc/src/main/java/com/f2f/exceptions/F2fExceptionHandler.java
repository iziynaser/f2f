package com.f2f.exceptions;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Locale;

@RestControllerAdvice
public class F2fExceptionHandler  {

    private final MessageSource messageSource;

    public F2fExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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
//
//    private ResponseEntity<Object> handleInvalidFormatException(InvalidFormatException ex, HttpStatus status){
//        F2fErrorResponse response = new F2fErrorResponse.F2fErrorBuilder()
//            .withErrorCode("206")
//            .withMessage("invalid input")
//            .withStatus(status)
//            .withDetail(ex.toString())
//            .atTime(LocalDateTime.now(ZoneOffset.UTC))
//            .build();
//        return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
//    }
//

    @ExceptionHandler(value = F2fNotFoundException.class)
    public ResponseEntity<F2fErrorResponse> handleF2fNotFoundException(F2fNotFoundException ex){
        Locale locale = LocaleContextHolder.getLocale();
        String localizedMessage = messageSource.getMessage(ex.getMessageKey(),ex.getArgs(),locale);

        F2fErrorResponse response = new F2fErrorResponse.F2fErrorBuilder()
            .withErrorCode("506")
            .withMessage(localizedMessage)
            .withStatus(HttpStatus.NOT_FOUND)
            .atTime(LocalDateTime.now(ZoneOffset.UTC))
            .build();
        return new ResponseEntity<F2fErrorResponse>(response,HttpStatus.NOT_FOUND);
    }
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
