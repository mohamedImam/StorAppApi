package com.data.models.ErrorHandler.ApiExceptions;

import com.data.models.ErrorHandler.ApiBaseException;
import org.springframework.http.HttpStatus;

public class ConflictException extends ApiBaseException {

    public ConflictException() {
        super();

    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }

    @Override
    public int getErrorCode2() {
        return 301;
    }

    @Override
    public  boolean getStatus() {
        return false;
    }

    @Override
    public String getResponseMessage() {
        return "Another Record by same name";
    }
}
