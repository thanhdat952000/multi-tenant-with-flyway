package dev.sultanov.springdata.multitenancy.exception;

public class HandleException extends RuntimeException{
    public HandleException(String message) {
        super(message);
    }
}