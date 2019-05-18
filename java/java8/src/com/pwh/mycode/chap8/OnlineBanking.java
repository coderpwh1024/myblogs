package com.pwh.mycode.chap8;

/**
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/5/14 10:56
 * 4
 */
public abstract class OnlineBanking {


    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);

    }

    abstract void makeCustomerHappy(Customer c);

    static private class Customer {

    }

    static private class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }


}
