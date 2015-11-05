package com.acme.edu.Exception;

public class DontPrintException extends Exception {
    public DontPrintException() {
    }

    public DontPrintException(String message) {
        super(message);
    }

    public DontPrintException(String message, Throwable cause) {
        super(message, cause);
    }

    public DontPrintException(Throwable cause) {
        super(cause);
    }

    public DontPrintException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
