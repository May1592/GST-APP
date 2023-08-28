package com.tripathi.gst.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<Object> handleBusinessException(final UserException userException, final WebRequest webRequest)
    {
        if(userException.getHttpStatus() != null)
        {
            return new ResponseEntity<>(new HttpHeaders(), userException.getHttpStatus());
        }
        else
        {
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
        }
    }
}
