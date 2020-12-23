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
    }
    public static class ErorrMesseges
    {
        public static final String SuccessMes = "Success";
        public static final String FailMes = "Fail";
        public static final String  NotFoundMes = "Not Found";
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
