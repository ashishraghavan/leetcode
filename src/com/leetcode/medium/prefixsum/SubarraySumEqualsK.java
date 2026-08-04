package com.leetcode.medium.prefixsum;

import java.util.HashMap;
import java.util.Map;

//#560, #930
//using ex. 3, 4, 1, 6  target=7
//intuition - Imagine you are standing at Index 3, where your current running total is 14.
//You want to know: Is there any contiguous slice of numbers ending right here at Index 3 that adds up to our target k = 7?
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        //3, 4, 1, 6|7
        //1, 2, 3, -3, -2, -1|0
        //-1, -2, -3|-3
        //0, 0, 0, 0, 0|0
        //3|3
        //1, 2, 3, -3, -2, -1|0
        //100, -100, 100, -100|0
        //1, -1, 1, -1, 1, -1|1
        //1, 1, 1|2
        //1, -1, 0|0
        //1, 0, 1, 0, 1|2
        //0, 1, 0, 0, 1, 0, 0|0 --> ans=7
        //0, 0, 1, 0, 0, 0, 1, 0, 0|2
        //1, 1, 1, 1, 1|2
        //1, 1, 0, 1, 1|4
        //0, 1, 1, 1, 1, 0| 3
        System.out.println(subarraySum(new int[]{0, 1, 1, 1, 1, 0},3));
    }

    public static int subarraySum(int[] A, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        m.put(0,1);
        int sum = 0,cnt = 0;
        for (int j : A) {
            sum += j;
            if (m.containsKey(sum - k)) {
                cnt += m.get(sum - k);
            }
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
