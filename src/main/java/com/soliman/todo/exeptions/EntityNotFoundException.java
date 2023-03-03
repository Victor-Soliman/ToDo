package com.soliman.todo.exeptions;

public class EntityNotFoundException extends RuntimeException{
    private final ErrorCodes errorCodes;

    public EntityNotFoundException(ErrorCodes errorCodes) {
        this.errorCodes = errorCodes;
    }

    public EntityNotFoundException(String message, ErrorCodes errorCodes) {
        super(message);
        this.errorCodes = errorCodes;
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorCodes errorCodes) {
        super(message, cause);
        this.errorCodes = errorCodes;
    }

    public EntityNotFoundException(Throwable cause, ErrorCodes errorCodes) {
        super(cause);
        this.errorCodes = errorCodes;
    }

    public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCodes errorCodes) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCodes = errorCodes;
    }

    public ErrorCodes getErrorCodes() {
        return errorCodes;
    }
}
