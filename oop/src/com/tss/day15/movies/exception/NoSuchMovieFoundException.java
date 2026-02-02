package com.tss.day15.movies.exception;

public class NoSuchMovieFoundException extends RuntimeException {
    public NoSuchMovieFoundException(String message) {
        super(message);
    }
}
