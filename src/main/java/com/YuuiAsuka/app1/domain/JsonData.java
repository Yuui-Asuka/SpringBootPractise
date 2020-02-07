package com.YuuiAsuka.app1.domain;
import java.io.Serializable;

public class JsonData implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;

    private Object data;

    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonData(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public JsonData(int code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
