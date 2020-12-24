package com.data.models.ErrorHandler.ApiExceptions;


import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiBaseException;
import org.springframework.http.HttpStatus;

public class CurrencyException extends ApiBaseException {


    public CurrencyException()

    {
        super();
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.OK;
    }

    @Override
    public int getErrorCode2() {
        return ConstantClass.ErorrCodes.RESPONSE_INVALID_CURRENCY;
    }

    @Override
    public boolean getStatus() {
        return ConstantClass.StatusMesseges.FalseStatus;
    }

    @Override
    public String getResponseMessage() {
        return ConstantClass.ErorrMesseges.EXCEPTIONS_INVALID_CURRENCY;
    }
}
