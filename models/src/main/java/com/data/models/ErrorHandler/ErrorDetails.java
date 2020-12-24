package com.data.models.ErrorHandler;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.util.Date;

public class ErrorDetails {

    private int ResponseCode;
    private String ResponseMessage;
    private String uri;
    private boolean ResponseStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy hh:mm:ss")
    private Date timpstamp;


    public ErrorDetails() {
        this.timpstamp = new Date();
    }

    public ErrorDetails(int responseCode, String uri, String ResponseMessage, boolean ResponseStatus) {
        this();
        this.ResponseCode = responseCode;
        this.ResponseMessage = ResponseMessage;
        this.uri = uri;
        this.ResponseStatus = ResponseStatus;


    }


    public boolean getResponseStatus() {
        return ResponseStatus;
    }

    public void setResponseStatus(boolean responseStatus) {
        ResponseStatus = responseStatus;
    }

    public int getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(int responseCode) {
        ResponseCode = responseCode;
    }

    public String getResponseMessage() {
        return ResponseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.ResponseMessage = responseMessage;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getTimpstamp() {
        return timpstamp;
    }

    public void setTimpstamp(Date timpstamp) {
        this.timpstamp = timpstamp;
    }
}
