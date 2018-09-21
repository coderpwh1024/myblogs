package com.coderpwh.chapter2;


/**
 * 实现查找线性表(0,1,2,*****n-1)中的第i个(1<=i<=n)个元素的直接前驱，并输出其值，要求在单链表上实现
 */

import java.util.Scanner;

public class Example2_3 {
    public static void main(String[] args) throws Exception {
        int n = 10;
        LinkList L = new LinkList();
        for (int i = 0; i < n; i++) {
            L.insert(i, i);
        }
        System.out.println("请输入i的值:");
        int i = new Scanner(System.in).nextInt();
        if (0 < i && i <= n) {
            System.out.println("第" + i + "个元素的直接前驱是:" + L.get(i - 1));
        } else {
            System.out.println("第" + i + "个元素的直接前驱不存在!");
        }


    }
}
