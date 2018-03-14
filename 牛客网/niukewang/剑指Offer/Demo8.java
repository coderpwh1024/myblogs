package com.coderpwh.niukewang;

/**
 * @author coderpwh
 * @Date: 2018/3/7.
 * @Description:
 */

/***
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 */
public class Demo8 {


    /**
     * 递归方法
     * @param target
     * @return
     */
    public int JumpFloor(int target) {

         if(target<=0){
             return 0;
         }else if(target==1){
             return 1;
         }else if(target==2){
             return 2;
         }else{
             return JumpFloor(target-1)+JumpFloor(target-2);
         }


    }
}
