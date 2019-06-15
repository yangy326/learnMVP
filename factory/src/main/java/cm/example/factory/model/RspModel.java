package cm.example.factory.model;

import java.util.Date;

public class RspModel<T> {

//    public static final int SUCCEED = 1;
//
//    public static final int ERROR_UNKNOWN = 0;
//
//    public static final int ERROR_NOT_FOUND_USER = 4041;
//    public static final int ERROR_NOT_FOUND_GROUP = 4042;
//    public static final int ERROR_NOT_FOUND_GROUP_MEMBER = 4043;
//
//    public static final int ERROR_CREATE_USER = 3001;
//    public static final int ERROR_CREATE_GROUP = 3002;
//    public static final int ERROR_CREATE_MESSAGE = 3003;
//
//    public static final int ERROR_PARAMETERS = 4001;
//    public static final int ERROR_PARAMETERS_EXIST_ACCOUNT = 4002;
//    public static final int ERROR_PARAMETERS_EXIST_NAME = 4003;
//
//    public static final int ERROR_SERVICE = 5001;
//
//    public static final int ERROR_ACCOUNT_TOKEN = 2001;
//    public static final int ERROR_ACCOUNT_LOGIN = 2002;
//    public static final int ERROR_ACCOUNT_REGISTER = 2003;
//
//    public static final int ERROR_ACCOUNT_NO_PERMISSION = 2010;
    private int code;
    private boolean success;
    private T data;

    public RspModel(int code, boolean success, T data) {
        this.code = code;
        this.success = success;
        this.data = data;
    }

    public RspModel(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    //    public boolean success() {
//        return code == SUCCEED;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public T getResult() {
//        return data;
//    }
//
//    public void setResult(T result) {
//        this.data = result;
//    }
}
