package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

//problem # 219 - contains duplicate II
public class ContainsDuplicateII_L219 {
    public static void main(String[] args) {
        //[1,2,3,1], k = 3
        //[1,0,1,1], k = 1
        //[1,2,3,1,2,3], k = 2
        //[1,0,1,1], k=4
        //{12, -83, -75, 52, 4, 33, 33, 83, -60, 57, -19, 77, -8, 66, 91, -50, -54, -20, -66, -70}, k=1
        System.out.println(containsNearbyDuplicate(new int[]{99,99},2));
    }

    //find duplicate integers in array with difference in their indexes <= k
    //{1,2,3,1,2,3}, 2 -> map:{1:0,2:1,3:2,}
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i],i);
                continue;
            }
            if(Math.abs(i-map.get(nums[i])) <= k) {
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
