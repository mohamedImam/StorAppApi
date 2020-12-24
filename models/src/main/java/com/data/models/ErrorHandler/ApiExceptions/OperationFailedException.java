package com.data.models.ErrorHandler.ApiExceptions;

import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiBaseException;
import org.springframework.http.HttpStatus;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/24/2020  : 11:38
 */
public class OperationFailedException  extends ApiBaseException {


    public OperationFailedException()

    {
        super();
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.OK;
    }

    @Override
    public int getErrorCode2() {
        return ConstantClass.ErorrCodes.FAIL_CODE;
    }

    @Override
    public boolean getStatus() {
        return ConstantClass.StatusMesseges.FalseStatus;
    }

    @Override
    public String getResponseMessage() {
        return ConstantClass.ErorrMesseges.FailMes;
    }

}
