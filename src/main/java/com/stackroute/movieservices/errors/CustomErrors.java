package com.stackroute.movieservices.errors;

import org.springframework.http.HttpStatus;

public class CustomErrors {
    private String httpError;
    private HttpStatus httpStatus;

    public CustomErrors(String httpError, HttpStatus httpStatus) {
        this.httpError = httpError;
        this.httpStatus = httpStatus;
    }

    public String getHttpError() {
        return httpError;
    }

    public void setHttpError(String httpError) {
        this.httpError = httpError;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
