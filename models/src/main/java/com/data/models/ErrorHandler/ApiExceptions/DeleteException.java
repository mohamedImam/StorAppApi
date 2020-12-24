package com.data.models.ErrorHandler.ApiExceptions;

import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiBaseException;
import org.springframework.http.HttpStatus;

public class DeleteException extends ApiBaseException {

    public DeleteException() {
        super();
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_ACCEPTABLE;
    }

    @Override
    public int getErrorCode2() {
        return 302;
    }

    @Override
    public boolean getStatus() {
        return ConstantClass.StatusMesseges.FalseStatus;
    }

    @Override
    public String getResponseMessage() {
        return "Deletion of Record fail";
    }
}
