package com.pwh.mycode.chap5;

/**
 * 2 * @Author: coderpwh
 * 3 * @Date: 2019/4/15 18:04
 * 4
 */
public class Trader {

    private String city;

    private String name;

    
     public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }
    

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
