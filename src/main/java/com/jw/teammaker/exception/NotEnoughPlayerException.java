package com.jw.teammaker.exception;

public class NotEnoughPlayerException extends RuntimeException{

    public NotEnoughPlayerException() {
        super();
    }

    public NotEnoughPlayerException(String message) {
        super(message);
    }

    public NotEnoughPlayerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughPlayerException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughPlayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
