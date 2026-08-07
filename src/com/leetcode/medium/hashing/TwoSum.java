package com.leetcode.medium.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//#1
public class TwoSum {
    public static void main(String[] args) {
        //2,7,11,15|9
        //3, 3|6
        //3, 2, 4|6
        //-1, -2, -3, -4, -5| -8
        //-5, 2, 5, 10|0
        //0, 4, 3, 0|0
        //5, 10, -5|0
        //1, 9999999, 2, -9999999|0
        //1, 2, 3, 4, 5, 6, 7, 100, 200|300
        //5, 2, 9, 13, 1|6
        System.out.println(Arrays.toString(twoSum(new int[]{5, 2, 9, 13, 1},6)));
    }

    //A = 2,7,11,15, k = 9
    public static int[] twoSum(int[] A, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        for(int i=0;i<A.length;i++) {
            int diff = k - A[i];
            if(m.containsKey(diff) && m.get(diff) != i) {
                return new int[]{m.get(diff),i};
            }
            m.put(A[i],i);
        }
        return new int[]{-1,-1};
    }
}
