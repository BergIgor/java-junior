package com.acme.edu.Exception;


public class NullMessageException extends Exception{

    public NullMessageException() {
    }

    public NullMessageException(String message) {
        super(message);
    }

    public NullMessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullMessageException(Throwable cause) {
        super(cause);
    }

    public NullMessageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
