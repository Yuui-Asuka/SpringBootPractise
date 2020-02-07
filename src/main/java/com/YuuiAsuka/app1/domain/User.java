package com.YuuiAsuka.app1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {

    private String Username;

    @JsonProperty("account")      //不能把JavaBean的字段暴露给外界
    private int age;

    @JsonIgnore    //不返回密码信息
    private String pwd;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date CreateDate;

    public User(String username, int age, String pwd, Date createDate) {
        super();
        Username = username;
        this.age = age;
        this.pwd = pwd;
        CreateDate = createDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public String getUsername() {
        return Username;
    }

    public int getAge() {
        return age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
