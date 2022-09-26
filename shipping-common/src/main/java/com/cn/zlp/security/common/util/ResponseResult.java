package com.cn.zlp.security.common.util;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -31677365028363832L;

    private Boolean success;

    private String retCode;

    private String retMsg;

    private T data;



    public static <T> ResponseResult<T> success(String retCode, String retMsg,T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setSuccess(Boolean.TRUE);
        responseResult.setRetMsg(retMsg);
        responseResult.setRetCode(retCode);
        responseResult.setData(data);
        return responseResult;
    }

    public static <T> ResponseResult<T> failure(String retCode, String retMsg) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setSuccess(Boolean.FALSE);
        responseResult.setRetCode(retCode);
        responseResult.setRetMsg(retMsg);
        return responseResult;
    }

//    public static <T> ResponseResult<T> failure(ErrorCodeEnum errorCodeEnum) {
//        return failure(errorCodeEnum.getCode(), errorCodeEnum.getMessage());
//    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}