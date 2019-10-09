package com.stackroute.movieservices.exceptions;

public abstract class MovieException extends Exception{
    public MovieException(String message) {
        super(message);
    }
}
