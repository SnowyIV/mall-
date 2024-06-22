package com.geekaca.web.domain;

import java.util.List;

public class LoginUser {
    private String loginName;
    private String password;
    private String addr;
    private List<String> likes;

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public List<String> getLikes() {
        return likes;
    }

    public void setLikes(List<String> likes) {
        this.likes = likes;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", addr='" + addr + '\'' +
                ", likes=" + likes +
                '}';
    }
}
