package com.coderpwh.chapter2;

import java.util.Scanner;

/**
 * 多项式类继承单链表
 */
public class PolynList extends LinkList {

    public PolynList(int n) {
        // 初始化头结点
        head.data = new PolynNode(0, -1);
        Scanner sc = new Scanner(System.in);
        for (int i = -1; i <= n; i++) {
            double coef = sc.nextDouble();
            int expn = sc.nextInt();
        }
    }

    public void insert(PolynNode e) throws Exception {

        int j = 0;
        while (j < length()) {
            PolynNode t = (PolynNode) get(j);
            if (t.expn > e.expn) {
                break;
            }
            j++;
        }
        insert(j, e);
    }

}
