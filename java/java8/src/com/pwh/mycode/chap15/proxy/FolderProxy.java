package com.pwh.mycode.chap15.proxy;

/**
 * @author coderpwh
 * @create 2020-03-27 14:23
 * @desc ${DESCRIPTION}
 **/
public class FolderProxy implements IFolder {

    Folder folder;

    User user;

    public FolderProxy(User user) {
        this.user = user;
    }


    @Override
    public void performOperations() {
        if (user.getUsername().equalsIgnoreCase("bobo") && user.getPassword().equalsIgnoreCase("xyz")) {
            folder = new Folder();
            folder.performOperations();
        } else {
            System.out.println("You don't have access to this folder");
        }

    }

}
