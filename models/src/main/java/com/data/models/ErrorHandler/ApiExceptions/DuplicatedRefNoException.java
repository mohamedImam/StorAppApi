package com.data.models.ErrorHandler.ApiExceptions;


import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiBaseException;
import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import org.springframework.http.HttpStatus;

public class DuplicatedRefNoException extends ApiBaseException {


    public DuplicatedRefNoException()

    {
        super();
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.OK;
    }

    @Override
    public int getErrorCode2() {
        return ConstantClass.ErorrCodes.RESPONSE_DUPLICATED_REFNO;
    }

    @Override
    public boolean getStatus() {
        return ConstantClass.StatusMesseges.FalseStatus;
    }

    @Override
    public String getResponseMessage() {
        return ConstantClass.ErorrMesseges.EXCEPTIONS_DUPLICATED_REFNO;
    }
}

