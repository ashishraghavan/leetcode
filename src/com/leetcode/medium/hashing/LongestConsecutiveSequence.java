package com.leetcode.medium.hashing;

import java.util.HashSet;
import java.util.Set;

//#128
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        //5,4,3,2,1
        //0,3,7,2,5,8,4,6,0,1
        //1,2,10,11,12,100
        //100, 4, 200, 1, 3, 2
        //0, 1, 1, 2, 2, 3, 4, 5, 5
        //1000000000, 1000000001, -1000000000, -999999999
        //5, 5, 5, 5
        //1, 2, 3, 4, 5
        //5, 4, 3, 2, 1
        //-1, -2, -3, 0, 1, 2
        //10
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    //0,3,7,2,5,8,4,6,1
    //check https://share.gemini.google/pQ556LG8Ad7X
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        Set<Integer> set = new HashSet<>();
        for (int j : nums) {
            set.add(j);
        }
        int mx=1;
        for(Integer num : set) {
            if(!set.contains(num-1)) {
                int c = 1;
                while(set.contains(num + c)) {
                    c++;
                }
                mx = Math.max(mx,c);
            }
        }
        return mx;
    }
}
