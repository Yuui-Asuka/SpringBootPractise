package com.YuuiAsuka.app1.domain;

//runtimeException是运行时异常的最高类
//自定义异常需要继承RuntimeException这个类
public class MyException extends RuntimeException {

    private String code;
    private String msg;

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
