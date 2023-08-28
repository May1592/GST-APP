package com.tripathi.gst.exception;

import org.springframework.http.HttpStatus;


public class UserException extends RuntimeException{
    private final String errorCode;
    private HttpStatus httpStatus;

    public UserException(String errorCode, String message)
    {
        super(message);
        this.errorCode = errorCode;
    }
    public UserException(String errorCode, String message, HttpStatus httpStatus)
    {
        super(message);
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
