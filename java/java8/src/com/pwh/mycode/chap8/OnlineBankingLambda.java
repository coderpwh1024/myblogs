package com.pwh.mycode.chap8;

import java.util.function.Consumer;

/**
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/5/14 11:05
 * 4
 */
public class OnlineBankingLambda {
    public static void main(String[] args) {

        new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello!"));
    }


    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

    static private class Customer {

    }

    static private class Database {
        static Customer getCustomerWithId(int id) {
            return new Customer();
        }
    }


}
