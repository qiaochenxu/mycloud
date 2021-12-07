package com.personage.springcloud.result;

public enum ResultCode {
    OK(200,"成功");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    ResultCode(){

    }

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
