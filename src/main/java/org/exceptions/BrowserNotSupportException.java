package org.exceptions;

public class BrowserNotSupportException extends RuntimeException {

    public BrowserNotSupportException(String browser) {
        super(String.format("Browser %s not supported", browser));
    }
}
