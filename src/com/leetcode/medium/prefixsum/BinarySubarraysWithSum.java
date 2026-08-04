package com.leetcode.medium.prefixsum;

import java.util.HashMap;
import java.util.Map;

//#930
public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        //1,0,1,0,1
        //0, 1, 0, 0, 1, 0, 0|0
        //0, 0, 1, 0, 0, 0, 1, 0, 0|2
        //1, 1, 1, 1, 1|2
        //1, 1, 1|4
        //1|1
        //0|1
        //1, 1, 0, 1, 1|4
        //0, 1, 1, 1, 1, 0|3
        System.out.println(numSubarraysWithSum(new int[]{0, 1, 1, 1, 1, 0},3));
    }

    //A=[1,0,1,0,1],g=2
    //mp={0:1}
    //i=0,sum=1,1-2=-1
    public static int numSubarraysWithSum(int[] A, int g) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int sum=0,cnt=0;
        for(int i=0;i<A.length;i++) {
            sum += A[i];
            if(mp.containsKey(sum - g)) {
                cnt += mp.get(sum-g);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return cnt;
    }

    //l=0,r=[0,4]
    //[1,0,1,0] -> cnt=2
    //[0,1,0] -> cnt=2
    //[0,1,0,1] -> cnt=3
    //[1,0,1] -> cnt=4
}
