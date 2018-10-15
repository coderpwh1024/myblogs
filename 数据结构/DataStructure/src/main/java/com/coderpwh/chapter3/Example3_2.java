package com.coderpwh.chapter3;

/**
 * 实现两个大数相加的和
 */
public class Example3_2 {


    public String add(String a, String b) throws Exception {

        LinkStack sum = new LinkStack();
        LinkStack sA = new LinkStack();
        LinkStack sB = new LinkStack();
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


     return  null;
    }


}
