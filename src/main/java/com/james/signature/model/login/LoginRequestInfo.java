package com.james.signature.model.login;

public class LoginRequestInfo {
    private String userName;
    private String userPwd;

    public LoginRequestInfo() {
    }

    public LoginRequestInfo(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}
