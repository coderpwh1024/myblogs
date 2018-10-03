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

    /**
     * 按照指数递增顺序插入到多项式有序链表
     */

    public void insert(PolynNode e) throws Exception {

        int j = 0;
        /**
         *  与原有链表中的指数做比较
         */
        while (j < length()) {
            PolynNode t = (PolynNode) get(j);
            if (t.expn > e.expn) {
                break;
            }
            j++;
        }
        insert(j, e);
    }

    // 比较2项多项式大小
    public int cmp(PolynNode a, PolynNode b) {

        if (a.expn < b.expn) {
            return -1;
        } else if (a.expn == b.expn) {
            return 0;
        } else {
            return 1;
        }
    }

    /**
     * 多现实加法
     *
     * @param LA
     * @param LB
     * @return
     */
    public PolynList addPolyn(PolynList LA, PolynList LB) {

        // ha 指向新形成链表的尾结点
        Node ha = LA.head;
        // qa 指向LA 中需要计算的当前值
        Node qa = LA.head.next;
        // qb 指向 LB中需要计算的当前值
        Node qb = LB.head.next;
        while (qa != null && qb != null) {
            PolynNode a = (PolynNode) qa.data;
            PolynNode b = (PolynNode) qb.data;
            switch (cmp(a, b)) {
                // a的指数小
                case -1:
                    ha.next = qa;
                    ha = qa;
                    qa = qa.next;
                    break;
                //a,b系数相等
                case 0:
                    double sum = a.coef + b.coef;
                    if (sum != 0.0) {
                        a.coef = sum;
                        ha.next = qa;
                        ha = qa;
                        qa = qa.next;
                        qb = qb.next;
                    } else {
                        qa = qa.next;
                        qb = qb.next;
                    }
                    break;
                case 1:
                    ha.next = qb;
                    ha = qb;
                    qb = qb.next;
                    break;

            }
        }
        // 插入剩余的结点
        ha.next = (qa != null ? qa : qb);
        return LA;
    }

    public void display() {
        for (int i = 0; i < length(); i++) {
            try {
                PolynNode e = (PolynNode) get(i);
                System.out.println("系数为:" + e.coef + " 指数为:" + e.expn);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入A多项式的项数:");
        int m = sc.nextInt();
        System.out.println("请分别输入多项式A各项的系数和指数:");
        PolynList LA = new PolynList(m);
        System.out.println("请输入B多项式的项数:");
        int n = sc.nextInt();
        System.out.println("请分别输入多项式B各项的系数和指数:");
        PolynList LB = new PolynList(n);
        LA = LA.addPolyn(LA, LB);
        System.out.println("求和后多项式各项为:");
        LA.display();
    }

}
