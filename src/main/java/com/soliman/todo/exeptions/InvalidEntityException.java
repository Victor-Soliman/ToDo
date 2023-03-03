package com.soliman.todo.exeptions;

import java.util.List;

public class InvalidEntityException extends RuntimeException{
    private ErrorCodes errorCodes;
    private List<String> errors;

    public ErrorCodes getErrorCodes() {
        return errorCodes;
    }

    public List<String> getErrors() {
        return errors;
    }

    public InvalidEntityException(ErrorCodes errorCodes, List<String> errors) {
        this.errorCodes = errorCodes;
        this.errors = errors;
    }

    public InvalidEntityException(String message, Throwable cause, ErrorCodes errorCodes, List<String> errors) {
        super(message, cause);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }

    public InvalidEntityException(Throwable cause, ErrorCodes errorCodes, List<String> errors) {
        super(cause);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }

    public InvalidEntityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ErrorCodes errorCodes, List<String> errors) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }

    public InvalidEntityException(String message, ErrorCodes errorCodes, List<String> errors) {
        super(message);
        this.errorCodes = errorCodes;
        this.errors = errors;
    }
}
