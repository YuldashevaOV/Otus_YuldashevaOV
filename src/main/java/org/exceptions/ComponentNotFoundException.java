package org.exceptions;

public class ComponentNotFoundException extends RuntimeException {

    public ComponentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}