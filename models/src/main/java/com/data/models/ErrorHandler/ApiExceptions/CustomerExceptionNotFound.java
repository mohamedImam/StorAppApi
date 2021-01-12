package com.data.models.ErrorHandler.ApiExceptions;

import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiBaseException;
import org.springframework.http.HttpStatus;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/29/2020  : 10:56
 */
public class CustomerExceptionNotFound extends ApiBaseException {


    public CustomerExceptionNotFound() {
        super();
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.OK;
    }

    @Override
    public int getErrorCode2() {
        return ConstantClass.ErorrCodes.RESPONSE_CUSTOMER_NO_DATA_FOUND;
    }

    @Override
    public boolean getStatus() {
        return ConstantClass.StatusMesseges.FalseStatus;
    }

    @Override
    public String getResponseMessage() {
        return ConstantClass.ErorrMesseges.EXCEPTIONS_CUSTOMER_NO_DATA_FOUND;
    }

}
