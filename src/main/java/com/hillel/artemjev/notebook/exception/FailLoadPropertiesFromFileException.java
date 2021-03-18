package com.hillel.artemjev.notebook.exception;

public class FailLoadPropertiesFromFileException extends RuntimeException {

    public FailLoadPropertiesFromFileException(String message) {
        super(message);
    }

    public FailLoadPropertiesFromFileException(String message, Throwable cause) {
        super(message, cause);
    }


}