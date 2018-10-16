package com.coderpwh.chapter3;

/**
 * 实现两个大数相加的和
 */
public class Example3_2 {


    public static void main(String[] args) throws Exception {
        Example3_2 e = new Example3_2();
        String str = e.add("18 452 543 389 943 209 752 345 473",
                "8 123 542 678 432 986 899 334");
        System.out.println(str);
        System.out.println("两个大数的和为："
                + e.add("18 452 543 389 943 209 752 345 473",
                "8 123 542 678 432 986 899 334"));
    }

    public String add(String a, String b) throws Exception {

        LinkStack sum = new LinkStack();
        LinkStack sA = numSplit(a);
        LinkStack sB = numSplit(b);
        // 对于两个各位的求和
        int partialSum;
        // 进位标示
        boolean isCarry = false;
        while (!sA.isEmpty() && !sB.isEmpty()) {
            partialSum = (Integer) sA.pop() + (Integer) sB.pop();

            // 低位进位
            if (isCarry) {
                partialSum++;
                isCarry = false;
            }

            // 需要进位
            if (partialSum >= 10) {
                partialSum -= 10;
                sum.push(partialSum);
                isCarry = true;
            } else {   // 不进位
                sum.push(partialSum);
            }

        }

        //  指向加数与被加数的非空栈
        LinkStack temp = !sA.isEmpty() ? sA : sB;

        while (!temp.isEmpty()) {
            if (isCarry) {
                int t = (Integer) temp.pop();
                ++t;
                if (t >= 10) {
                    t -= 10;
                    sum.push(t);
                } else {
                    sum.push(t);
                    isCarry = false;
                }
            } else {
                sum.push(temp.pop());
            }
        }
        // 最高位需要进位
        if (isCarry) {
            sum.push(1);
        }
        String str = new String();
        while (!sum.isEmpty()) {
            // 栈中的元素转换成字符串
            str = str.concat(sum.pop().toString());
        }
        return str;
    }

    // 除掉空字符 并转出成数字后存放在栈中
    public LinkStack numSplit(String str) throws Exception {
        LinkStack s = new LinkStack();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (' ' == c) {
                continue;
            } else if ('0' <= c && '9' >= c) {
                s.push(Integer.valueOf(String.valueOf(c)));
            } else {
                throw new Exception("错误:输入了非数字型字符!");
            }
        }
        return s;
    }


}
