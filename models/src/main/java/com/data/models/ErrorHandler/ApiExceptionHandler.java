package com.data.models.ErrorHandler;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorDetails> handleApiException(ApiBaseException ex, WebRequest request) {
        ErrorDetails det = new ErrorDetails(ex.getErrorCode2(), request.getDescription(false), ex.getResponseMessage(), ex.getStatus());
        return new ResponseEntity<>(det, ex.getStatusCode());
    }

}
