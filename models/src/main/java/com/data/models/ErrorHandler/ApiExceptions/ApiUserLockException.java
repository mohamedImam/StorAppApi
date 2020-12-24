package com.data.models.ErrorHandler.ApiExceptions;


import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiBaseException;
import org.springframework.http.HttpStatus;

public class ApiUserLockException extends ApiBaseException {


    public ApiUserLockException()

    {
        super();
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.OK;
    }

    @Override
    public int getErrorCode2() {
        return ConstantClass.ErorrCodes.RESPONSE_API_USER_LOCKED;
    }

    @Override
    public boolean getStatus() {
        return ConstantClass.StatusMesseges.FalseStatus;
    }

    @Override
    public String getResponseMessage() {
        return ConstantClass.ErorrMesseges.EXCEPTIONS_API_USER_LOCKED;
    }

}
