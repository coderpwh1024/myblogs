package com.coderpwh.lambda;

/**
 * Created by coderpwh on 2017/12/18.
 */
public class Interface1 {

    interface  Formula{
        double calculate(int a);

        default double sqrt(int a){
            return Math.sqrt(positive(a));
        }

        static  int positive(int a){
            return  a>0?a:0;
        }
    }

    public static void main(String[] args) {
        Formula formula1 = new Formula() {
            @Override
            public double calculate(int a) {
                return a*100;
            }
        };

        formula1.calculate(100);
        System.out.println( formula1.calculate(100));

        formula1.sqrt(-23);
        System.out.println(formula1.sqrt(-23));


        Formula.positive(-4);
        System.out.println( Formula.positive(-4));

//        Formula formula2 = (a)->sqrt(a*100);


    }




}
