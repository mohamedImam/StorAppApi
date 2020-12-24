package com.data.models.ErrorHandler;

import org.springframework.http.HttpStatus;

public abstract class ApiBaseException extends RuntimeException {
    public ApiBaseException() {
        super();
    }

    public abstract HttpStatus getStatusCode();

    public abstract int getErrorCode2();

    public abstract boolean getStatus();

    public abstract String getResponseMessage();
}
