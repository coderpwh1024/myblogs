package com.itzixi.authenticator;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author coderpwh
 * @Date: 2018/4/25.
 * @Description:
 */
public class Pwdmd5Test {
    public static void main(String[] args) {

        String password = "test001";

        String passwordMd5 = new Md5Hash(password).toString();
        String passwordMd5Salt = new Md5Hash(password,"abcd").toString();
        String passwordMd5SaltNum = new Md5Hash(password,"abcd",2).toString();

        System.out.println("密码MD5加密后的值为：" + passwordMd5);
        System.out.println("密码MD5使用盐加密后的值为：" + passwordMd5Salt);
        System.out.println("密码MD5使用盐加密并且散列2次后的值为：" + passwordMd5SaltNum);


    }

}
