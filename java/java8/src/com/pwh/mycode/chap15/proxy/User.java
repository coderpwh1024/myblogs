package com.pwh.mycode.chap15.proxy;

/**
 * @author coderpwh
 * @create 2020-03-27 14:05
 * @desc ${DESCRIPTION}
 **/
public class User {

    private String username;

    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
