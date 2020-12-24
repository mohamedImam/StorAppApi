package com.data.models.ErrorHandler.ApiExceptions;


import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiBaseException;
import org.springframework.http.HttpStatus;


public class BadRequestException extends ApiBaseException {
  //  CommonClass com = new CommonClass();
    ConstantClass constantClass=new ConstantClass();


    public BadRequestException()

    {
        super();
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.OK;
    }

    @Override
    public int getErrorCode2() {
        return ConstantClass.ErorrCodes.RESPONSE_BAD_REQUEST;
    }

    @Override
    public boolean
    getStatus() {
        return ConstantClass.StatusMesseges.FalseStatus;
    }

    @Override
    public String getResponseMessage() {
        return ConstantClass.ErorrMesseges.EXCEPTIONS_BAD_REQUEST;
    }

}
