Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack

Example 1:


```
Input: haystack = "hello", needle = "ll"
Output: 2
```

Example 2:


```
Input: haystack = "aaaaa", needle = "bba"
Output: -1
```


 # mycode #



```

package com.coderpwh.Leetcode;

import org.testng.annotations.Test;

/**
 * Created by 彭文浩 on 2018/1/21.
 */
public class ImplementStrstr {

    public int strStr(String haystack, String needle) {

        Boolean flag = haystack.contains(needle);

        if (flag) {
            int a = haystack.indexOf(needle);
            System.out.println(a);
            return 1;
        } else {
            return -1;
        }


    }


    @Test
    public void test() {

        strStr("helloll", "ll");
    }
}


```