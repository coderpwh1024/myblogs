package com.coderpwh.chapter2;

import java.util.Scanner;

/**
 * 学生成绩查询
 */
public class StudentManagSystem extends SqList {


    // 顺序结构
    public StudentManagSystem(int maxSize, int n) throws Exception {
        super(maxSize);
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            StudentNode node = new StudentNode(sc);
            if (node != null) {
                // 此处是表尾插入
                insert(node);
            } else {
                i--;
            }

        }
    }

    public static void main(String[] args) throws Exception {

        int maxSize = 1000;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生的总数:");
        int n = sc.nextInt();
        System.out.println("请按学号，姓名，性别，大学英语和高等数学的顺序输入学生信息:");
        StudentManagSystem L = new StudentManagSystem(maxSize, n);
        L.display();
        System.out.println("请输入需要查询的学生的学号:");
//        L.displayNode((StudentNode) L.get(sc.nextInt()));
        L.displayNode(L.get(sc.nextInt()));


        System.out.println("请输入需要删除学生的学号:");
        L.remove(sc.nextInt());
        System.out.println("删除成功!");
        L.display();

        System.out.println("请输入需要增加的学生信息:");
        L.insert(new StudentNode(sc));
        L.display();


    }

    @Override
    public StudentNode get(int number) throws Exception {
        System.out.println(length());
        for (int i = 0; i < length(); i++) {
            StudentNode node = (StudentNode) super.get(i);
            if (node.number == number) {
                return node;
            }
        }
        throw new Exception("学号" + number + "不存在");
    }

    // 重载父类的方法，表尾插入一个学生信息
    public void insert(StudentNode node) throws Exception {
        super.insert(this.length(), node);
    }

    //  重写父类的remove方法
    @Override
    public void remove(int number) throws Exception {
        for (int i = 0; i < length(); i++) {
            StudentNode node = (StudentNode) super.get(i);
            if (node.number == number) {
                super.remove(i);
                return;
            }
        }
        throw new Exception("学号" + number + "不存在");
    }

    @Override
    public void display() {
        for (int i = 0; i < length(); i++) {
            try {
                StudentNode node = (StudentNode) super.get(i);
            } catch (Exception e) {
            }

        }
    }

    // 输出单个元素的值
    public void displayNode(StudentNode node) {
        System.out.println("学号:" + node.number + "姓名:" + node.name + "性别:" + node.sex
                + "大学英语成绩:" + node.english + "高等数学成绩:" + node.math);
    }


}
