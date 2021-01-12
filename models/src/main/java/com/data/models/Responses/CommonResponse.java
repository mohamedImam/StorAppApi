package com.data.models.Responses;

import java.lang.invoke.ConstantBootstraps;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/22/2020  : 15:18
 */
public class CommonResponse {

    private String ResponseMessage;
    private int ResponseCode;
    private boolean ResponseStatus;
    private String RequestId;

    public CommonResponse() {
    }

    public CommonResponse(String responseMessage, int responseCode, boolean responseStatus, String requestId) {
        ResponseMessage = responseMessage;
        ResponseCode = responseCode;
        ResponseStatus = responseStatus;
        RequestId = requestId;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        ResponseMessage = responseMessage;
    }

    public int getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(int responseCode) {
        ResponseCode = responseCode;
    }

    public boolean getResponseStatus() {
        return ResponseStatus;
    }

    public void setResponseStatus(boolean responseStatus) {
        ResponseStatus = responseStatus;
    }

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }
}
