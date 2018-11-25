package com.coderpwh.chapter3;

import com.coderpwh.chapter2.SqList;

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

    // 求n个正整数的素数环,并以顺序表返回
    public SqList makerPrimeRing(int n) throws Exception {

        if (n % 2 != 0) {
            throw new Exception("素数环不存在!");
        }
        // 构造顺序表
        SqList L = new SqList(n);
        L.insert(0, 1);
        LinkQueue Q = new LinkQueue();
        for (int i = 2; i <= n; i++) {
            Q.offer(i);
        }
        return insertRing(L, Q, 2, n);

    }

    public SqList insertRing(SqList L, LinkQueue Q, int m, int n) throws Exception {

        int count = 0;
        while (!Q.isEmpty() && count <= n - m) {
            int p = (Integer) Q.poll();
            int q = (Integer) L.get(L.length() - 1);
            // 队列中的最后一个元素
            if (m == n) {
                // 满足素数环条件
                if (isPrime(p + q) && isPrime(p + 1)) {
                    L.insert(L.length(), p);
                    return L;
                } else {
                    Q.offer(p);
                }
            } else if (isPrime(p + q)) {
                L.insert(L.length(), p);
                if (insertRing(L, Q, m + 1, n) != null) {
                    return L;
                }
                L.remove(L.length());
                Q.offer(p);

            } else {
                Q.length();
            }
            ++count;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        Example3_5 r = new Example3_5();
        SqList L = r.makerPrimeRing(6);
        for (int i = 0; i < L.length(); i++) {
            System.out.println(L.get(i) + " ");
        }
    }


}
