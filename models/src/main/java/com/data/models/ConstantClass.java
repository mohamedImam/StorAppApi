package com.data.models;

import com.data.models.Responses.CommonResponse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/22/2020  : 15:24
 */
public class ConstantClass {

   public static DateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static class ConstantCodes {
        public static String DONE      = "D";
        public static String PENDING   = "P";
        public static String FAIL      = "F";

    }


    public static class ErorrCodes
    {
        public static final int SUCCESS_CODE                = 200;
        public static final int FAIL_CODE                   = 500;
        public static int RESPONSE_BAD_REQUEST              = 410;
        public static int RESPONSE_CREDENTIALS_ERROR        = 201;
        public static int RESPONSE_INVALID_CURRENCY         = 512;
        public static int RESPONSE_INVALID_DATE             = 515;
        public static int RESPONSE_DUPLICATED_REFNO         = 517;
        public static int RESPONSE_INSUFFICIENT_STOCK       = 518;
        public static int RESPONSE_NO_DATA_FOUND            = 404;
        public static int RESPONSE_CUSTOMER_NO_DATA_FOUND   = 405;
        public static int RESPONSE_INVALID_TRANACTION_NUMBER= 516;
        public static int RESPONSE_API_USER_LOCKED          = 202;
        public static int RESPONSE_PRODUCT_PRICE             = 520;
    }
    public static class ErorrMesseges
    {
        public static final String SuccessMes   = "Success";
        public static final String FailMes      = "Failed";
        //--------------------EXCEPTIONS--------------------------
        public static String EXCEPTIONS_BAD_REQUEST                = "Bad Request Parameters";
        public static String EXCEPTIONS_CREDENTIALS                = "Bad Authentication data";
        public static String EXCEPTIONS_INVALID_CURRENCY           = "InValid Currency";
        public static String EXCEPTIONS_INVALID_DATE               = "InValid Date Format must be (yyyy-MM-dd HH:mm:ss)";
        public static String EXCEPTIONS_DUPLICATED_REFNO           = "Duplicated refno";
        public static String EXCEPTIONS_NO_DATA_FOUND              = "No Record Found";
        public static String EXCEPTIONS_CUSTOMER_NO_DATA_FOUND     = "InValid Customer";
        public static String EXCEPTIONS_INVALID_TRANACTION_NUMBER  = "InValid Transactions Number/ must be greater than zero";
        public static String EXCEPTIONS_API_USER_LOCKED            = "Your API User is locked";
        public static String EXCEPTIONS_INSUFFICIENT_STOCK         = "Insufficient Stock";
        public static String EXCEPTIONS_PRODUCT_PRICE              = "Mismatch product price";



    }
    public static class StatusMesseges
    {
        public static final boolean TrueStatus  = true;
        public static final boolean FalseStatus = false;
    }
    public static class HelperClass {
        public static String getUUID()
        {
           return UUID.randomUUID().toString().replace("-", "");
        }
    }

    public static class PaymentMethod
    {
        public static String PAYMENT_METHOD_CASH           = "C";
        public static String PAYMENT_METHOD_CHEQUE         = "Q";
        public static String PAYMENT_METHOD_ONLINE_PAYMENT = "O";
    }

}
