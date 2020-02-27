package com.pwh.mycode.chap9;

/**
 * @author coderpwh
 * @create 2020-02-23 13:50
 * @desc ${DESCRIPTION}
 **/
public class Doctor {

    private String userName;

    private int age;

    private String number;

    

    private String address;

    private String phone;


    @Override
    public String toString() {
        return "Doctor{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Doctor(String userName, int age, String number, String address, String phone) {
        this.userName = userName;
        this.age = age;
        this.number = number;
        this.address = address;
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
