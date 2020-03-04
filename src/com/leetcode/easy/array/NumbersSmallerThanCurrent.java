package com.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//TODO : Yet to be solved!! It's an easy problem.
public class NumbersSmallerThanCurrent {
    public static void main(String[] args) {
        //8,1,2,2,3
        //7,7,7,7
        //6,5,4,8
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8,1,2,2,3})));
    }

    //8,1,2,2,3
    //after sorting - 1,2,2,3,8
    static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numCopy = Arrays.copyOf(nums,nums.length);
        Arrays.sort(numCopy);
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int i=0;i<numCopy.length;i++) {
            if(!countMap.containsKey(numCopy[i])) {
                countMap.put(numCopy[i],1);
            } else {
                countMap.put(numCopy[i],countMap.get(numCopy[i]) + 1);
            }
        }

        int j = numCopy.length - 1;
        while(j>=0) {
            int count = countMap.get(numCopy[j]);
            int temp = j;
            j = Math.abs(j-count);
            countMap.put(numCopy[temp],j+1);
        }
        for(int k=0;k<nums.length;k++) {
            nums[k] = countMap.get(nums[k]);
        }
        return nums;
    }
}
