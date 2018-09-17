package com.coderpwh.chapter2;

public class Example2_4 {
    public static void main(String[] args) throws Exception {
        System.out.println("请输入单链表中的10个结点的值:");
        LinkList L = new LinkList(10, true);
        System.out.println("删除重复结点前单链表中的各个结点值:");
        L.display();
        removeRepeatElm(L);
        System.out.println("删除重复结点后单链表中的各个结点值为:");
        L.display();
    }

    // 删除单链表中重复的结点
    private static void removeRepeatElm(LinkList L) throws Exception {
        // 首结点 p
        Node p = L.head.next, q;
        // 等同于  Node q;

        while (p != null) {
            // 链表中的位置(p的位置)
            int order = L.indexOf(p.data);
            q = p.next;
            while (q != null) {
                if ((p.data).equals(q.data)) {
                    L.remove(order + 1);
                } else {
                    ++order;
                }
            }
            p = p.next;
        }
    }


}
