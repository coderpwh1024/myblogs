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

}
