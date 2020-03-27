package com.pwh.mycode.chap15.proxy;

/**
 * @author coderpwh
 * @create 2020-03-27 14:14
 * @desc ${DESCRIPTION}
 **/
public class Folder implements  IFolder {

    @Override
    public void performOperations() {
        System.out.println("Performing operation on folde");
    }

}
