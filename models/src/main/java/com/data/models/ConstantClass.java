package com.data.models;

import java.util.UUID;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/22/2020  : 15:24
 */
public class ConstantClass {

    public static class ErorrCodes
    {
        public static final int SuccessCode = 0;
        public static final int FailCode = 500;
        public static final int NotFound = 404;
        public static int RESPONSE_BAD_REQUEST              = 410;
        public static int RESPONSE_CREDENTIALS_ERROR        = 201;
        public static int RESPONSE_INVALID_CURRENCY         = 512;
        public static int RESPONSE_INVALID_DATE             = 515;
        public static int RESPONSE_DUPLICATED_REFNO= 517;
        public static int RESPONSE_NO_DATA_FOUND            = 400;
        public static int RESPONSE_INVALID_TRANACTION_NUMBER= 516;
        public static int RESPONSE_API_USER_LOCKED          = 202;
    }
    public static class ErorrMesseges
    {
        public static final String SuccessMes = "Success";
        public static final String FailMes = "Fail";
        public static final String  NotFoundMes = "Not Found";
        //--------------------EXCEPTIONS--------------------------
        public static String EXCEPTIONS_BAD_REQUEST                = "Bad Request Parameters";
        public static String EXCEPTIONS_CREDENTIALS                = "Bad Authentication data";
        public static String EXCEPTIONS_INVALID_CURRENCY           = "InValid Currency";
        public static String EXCEPTIONS_INVALID_DATE               = "InValid Date Format must be (YYYY-MM-DD)";
        public static String EXCEPTIONS_DUPLICATED_REFNO = "Duplicated refno";
        public static String EXCEPTIONS_NO_DATA_FOUND              = "No Record Found";
        public static String EXCEPTIONS_INVALID_TRANACTION_NUMBER  = "InValid Transactions Number/ must be greater than zero";
        public static String EXCEPTIONS_API_USER_LOCKED            = "Your API User is locked";


    }
    public static class StatusMesseges
    {
        public static final boolean TrueStatus = true;
        public static final boolean FalseStatus = false;
    }
    public static class HelperClass {
        public static String getUUID()
        {
           return UUID.randomUUID().toString().replace("-", "");
        }
    }

}
