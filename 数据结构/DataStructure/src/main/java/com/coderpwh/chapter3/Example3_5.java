package com.coderpwh.chapter3;

/***
 *  求解素数环问题
 */
public class Example3_5 {

    /**
     * 判断正整数是否为素数
     *
     * @param num
     * @return
     */
    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        Double n = Math.sqrt(num);
        for (int i = 2; i <= n.intValue(); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
