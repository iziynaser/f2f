package com.f2f.exception;

//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class CustomExceptionHandler {

    //public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
//    private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
//    private String ACCESS_DENIED = "ACCESS_DENEID";
//
//    @ExceptionHandler(RecordNotFoundException.class)
//    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request){
//        List<String> details = new ArrayList<>();
//        details.add(ex.getLocalizedMessage());
//        ErrorResponse error = new ErrorResponse(INCORRECT_REQUEST,details);
//        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(AccessDeniedException.class)
//    public final ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException ex,WebRequest request){
//        List<String> details = new ArrayList<>();
//        details.add(ex.getLocalizedMessage());
//        ErrorResponse error = new ErrorResponse(ACCESS_DENIED,details);
//        return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
//    }

//    @ExceptionHandler(ConversionFailedException.class)
//    public final ResponseEntity<ErrorResponse> handleConversionFailedException(AccessDeniedException ex,WebRequest request){
//        List<String> details = new ArrayList<>();
//        details.add(ex.getLocalizedMessage());
//        ErrorResponse error = new ErrorResponse(ACCESS_DENIED,details);
//        return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
//    }

//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    public final ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(AccessDeniedException ex,WebRequest request){
//        List<String> details = new ArrayList<>();
//        details.add(ex.getLocalizedMessage());
//        ErrorResponse error = new ErrorResponse(ACCESS_DENIED,details);
//        return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
//    }

//    @ExceptionHandler(value = HttpMessageNotReadableException.class)
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        //return super.handleHttpMessageNotReadable(ex, headers, status, request);
//        List<String> details = new ArrayList<>();
//        details.add(ex.getLocalizedMessage());
//        ErrorResponse error = new ErrorResponse(INCORRECT_REQUEST,details);
//        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//    }
}
