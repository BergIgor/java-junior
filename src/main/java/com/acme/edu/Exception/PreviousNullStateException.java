package com.acme.edu.Exception;

public class PreviousNullStateException extends Exception {

    public PreviousNullStateException() {
    }

    public PreviousNullStateException(String message) {
        super(message);
    }

    public PreviousNullStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public PreviousNullStateException(Throwable cause) {
        super(cause);
    }

    public PreviousNullStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
