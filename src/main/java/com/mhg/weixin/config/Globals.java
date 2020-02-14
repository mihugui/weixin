package com.mhg.weixin.config;

public class Globals {


    // weixin ACCESS_TOKEN
    public static String ACCESS_TOKEN = "";
    public static boolean TOKEN_FLAG = false;

    // redis相关
    public static final String REDIS_LOGIN_USER = "loginUser_"; // redis中的用户key
    public static final int REDIS_SECONDS= 1800000;	//redis默认生存时间

    //jwt加密
    public static final String JWT_SECRET = "syl";

    public static int HTTP_CONTINUE = 100; //Continue
    public static int HTTP_OK = 200; //OK
    public static int HTTP_MULTIPLE_CHOICES = 300; //MULTIPLE_CHOICES
    public static int HTTP_BAD_REQUEST = 400; //BAD_REQUEST
    public static int HTTP_NOT_LOGIN = 401; //NOT_LOGIN
    public static int HTTP_LOGIN_TIME_OUT = 40101; //LOGIN_TIME_OUT
    public static int HTTP_LOGIN_CONFLICT = 40102; //LOGIN_CONFLICT
    public static int HTTP_NOT_FOUND = 404; //NOT_FOUND
    public static int HTTP_METHOD_NOT_ALLOWED = 405; //METHOD_NOT_ALLOWED
    public static int HTTP_INTERNAL_SERVER_ERROR = 500; //INTERNAL_SERVER_ERROR
    public static int HTTP_TOKEN_INVALID = 3200; //TOKEN_INVALID
    public static int LICENSE_HASEXPIRED = 6666; //licenseHasExpired

}
