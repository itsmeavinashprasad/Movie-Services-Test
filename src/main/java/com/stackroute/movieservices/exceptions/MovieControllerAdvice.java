package com.stackroute.movieservices.exceptions;

import com.stackroute.movieservices.errors.CustomErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MovieControllerAdvice {

    @ExceptionHandler(MovieAlreadyExistsException.class)
    public ResponseEntity<?> movieAlreadyExistsExceptionHandler(MovieAlreadyExistsException e){
        String httpError = e.getClass().toString()+": "+e.getMessage();
        return new ResponseEntity<CustomErrors>(new CustomErrors(httpError, HttpStatus.CONFLICT), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<?> movieNotFoundExceptionHandler(MovieNotFoundException e){
        String httpError = e.getClass().toString()+": "+e.getMessage();
        return new ResponseEntity<CustomErrors>(new CustomErrors(httpError, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> movieNotFoundExceptionHandler(Exception e){
        String httpError = e.getClass().toString()+": "+e.getMessage();
        return new ResponseEntity<CustomErrors>(new CustomErrors(httpError, HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
