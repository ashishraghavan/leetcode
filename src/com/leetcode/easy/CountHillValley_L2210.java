package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

//prob # 2210 - count hills & valleys in an array
public class CountHillValley_L2210 {
    public static void main(String[] args) {
        //6,6,5,5,4,1
        //2,4,1,1,6,5
        //2,2,2,5,1,3,3,6,8,12,10,7,7
        System.out.println(countHillValley(new int[]{2,2,2,5,1,3,3,6,8,12,10,7,7}));
    }

    //6,6,5,5,4,1
    //for each index i, give me last non-equal number in range (0,i-1) & first non-equal number in range (i+1,n-1)
    //List<int> l = {6,5,4,1} return 0

    //2,4,1,1,6,5
    //l = {2,4,1,6,5} return 3

    //2,2,2,5,1,3,3,6,8,12,10,7,7
    //l = {2,5,1,3,6,8,12,10,7} return 3

    public static int countHillValley(int[] nums) {
        List<Integer> l = new ArrayList<>();
        l.add(nums[0]);
        for(int i=1;i<nums.length;i++) {
            if(l.get(l.size()-1).equals(nums[i]))continue;
            l.add(nums[i]);
        }
        int cnt = 0;
        for(int i=1;i<l.size()-1;i++) {
            int curr = l.get(i);
            if((curr < l.get(i-1) && curr < l.get(i+1)) || (curr > l.get(i-1) && curr > l.get(i+1)))cnt++;
        }
        return cnt;
    }
}
