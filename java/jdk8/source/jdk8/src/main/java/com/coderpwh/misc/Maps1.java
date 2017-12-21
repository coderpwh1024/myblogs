package com.coderpwh.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by coderpwh on 2017/12/21.
 */
public class Maps1 {
    public static void main(String[] args) {

      Map<Integer,String> map = new HashMap<Integer,String>();

      for(int i=0;i<10;i++){
          // jdk8  新特性 底层调用依旧是put方法
          map.putIfAbsent(i,"val_"+i);
      }

      map.forEach((id,val)-> System.out.println(val));

        System.out.println("= = = = = = = = = = = = = = = = =");

        map.computeIfPresent(3,(num,val)->val+num);

        System.out.println(map.get(3));

        map.computeIfPresent(3,(num,val)->val+num);
        System.out.println(map.containsKey(9));

        map.computeIfPresent(9,(num,val)->null);
        System.out.println(map.get(9));

        // 源码剖析  computeIfPresent 方法中value 为null,key移除
        System.out.println(map.containsKey(9));   // false ?

        // map 遍历
           Set<Integer> set =   map.keySet();
        for (Integer in:set) {
           //  System.out.println(in);   // 此时 key 中不含有9
        }

        map.computeIfAbsent(23,num->"val"+num);
        System.out.println(map.containsKey(23)); // true

        map.computeIfAbsent(3,num->"bam");
        System.out.println(map.get(3));

        System.out.println(map.getOrDefault(42,"not found"));

        map.remove(3,"val3");  // false
        // map.remove(3);
        //   map.remove（） 直接移除key 值, 而 map.remove(key,vlaue) 要满足key 和valule同时相同才被移除
        //  map.remove(key) 与 map.remove(key,value);
        System.out.println(map.get(3));

        map.remove(3,"val_333");
        System.out.println(map.get(3));

        System.out.println("====================");
        map.merge(9,"val_9",(value,newValue)->value.concat(newValue));
        System.out.println(map.get(9));






















































    }
}
