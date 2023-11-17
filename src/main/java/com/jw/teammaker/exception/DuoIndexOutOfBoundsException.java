package com.jw.teammaker.exception;

public class DuoIndexOutOfBoundsException extends RuntimeException{
    public DuoIndexOutOfBoundsException() {
        super();
    }

    public DuoIndexOutOfBoundsException(String message) {
        super(message);
    }

    public DuoIndexOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuoIndexOutOfBoundsException(Throwable cause) {
        super(cause);
    }

    protected DuoIndexOutOfBoundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
