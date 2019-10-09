package com.stackroute.movieservices.exceptions;

public class MovieAlreadyExistsException extends MovieException {
    public MovieAlreadyExistsException(String message) {
        super(message);
    }
}
