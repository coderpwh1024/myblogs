
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,

return [0, 1]

# mycode #






 ```

package com.coderpwh.Leetcode;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/*
 Created by 彭文浩 on 2018/1/15.
 */

 public class Solution {

    public int[] twoSum(int[] nums, int target) {

         Map<Integer ,Integer> map = new HashMap<Integer,Integer>();
          int res[] = new int[2];
          for (int i=0;i<nums.length;++i){
              map.put(nums[i],i);
          }

          for(int i=0;i<nums.length;++i){
              int t = target-nums[i];
              if(map.containsKey(t)&& map.get(t)!=i){
                res[0] = i;
                res[1] = map.get(t);
                break;
              }
          }
        return res;

    }

     @Test
    public void test(){
       int[]  nums = {2, 7, 11, 15};
        int sum[] = twoSum(nums,9);
        for (int i=0;i<sum.length;i++){
            System.out.println(i+",");
        }


    }

}


```


![](https://i.imgur.com/d5x2D8f.png)
 

