package com.pwh.mycode.chap15.proxy;

/**
 * @author coderpwh
 * @create 2020-03-27 14:38
 * @desc ${DESCRIPTION}
 **/
public class ProxyDesignPatternMain {

    public static void main(String[] args) {

        User user = new User("bobo", "xyz");
        FolderProxy folderProxy = new FolderProxy(user);
        System.out.println("When userNmae and passord are correct:");

        folderProxy.performOperations();

        User userWrong = new User("abc", "abc");
        FolderProxy folderProxyWrong = new FolderProxy(userWrong);
        System.out.println("when userName and password are incorrect");
        folderProxyWrong.performOperations();

    }
}
