package com.coderpwh.niukewang;

/**
 * @author coderpwh
 * @Date: 2018/3/2.
 * @Description:
 */

import org.testng.annotations.Test;

/**

 */
public class Demo4 {

    public int[] multiply(int[] A) {

        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            int sum = 1;
            for (int j = 0; j < A.length; j++) {
                 int temp=1;
                if (i == j) {
                    temp = A[j];
                    System.out.println("A[j]:"+A[j]);
                    A[j]=1;
                }
                sum = sum * A[j];
            }
            B[i] = sum;
            System.out.println("sum:" + B[i]);
        }
        return B;
    }




    public int  multiplyB(int[] A){

        int B[] = new int[A.length];

         int sum1 = 1;

         int sum2 = 1;

          // B[i]=sum1的前面部分
           for(int i=0;i<B.length;i++){
                for(int j=0;j<A.length;j++){
                    if(i==0){
                        sum1=1;
                    }else{
                        sum1=sum1*A[j-1];
                    }
                }
           }

        return  0;
    }




    @Test
    public void test() {
        int[] b = {1, 2, 3, 4, 5};
        System.out.println(multiplyB(b));

//        int[] c = multiplyB(b);
       /* for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }*/

    }

}
