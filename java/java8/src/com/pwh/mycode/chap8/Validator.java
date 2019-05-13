package com.pwh.mycode.chap8;

/**
 * 2 * @Author: pengwenhao
 * 3 * @Date: 2019/5/13 17:31
 * 4
 */
public class Validator {

    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }


    public static void main(String[] args) {


        // 策略模式
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaa");
        System.out.println(b1);

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean b2 = lowerCaseValidator.validate("dddd");
        System.out.println(b2);

        // Lambda 表达式




    }

}
