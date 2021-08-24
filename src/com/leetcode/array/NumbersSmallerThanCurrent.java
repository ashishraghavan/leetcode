package com.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * Return the answer in an array.
 * Constraints:
 *
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class NumbersSmallerThanCurrent {
    public static void main(String[] args) {
        //8,1,2,2,3
        //7,7,7,7
        //6,5,4,8
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{7,7,7,7})));
        //after sorting
        //1,2,2,8,3 - Set<Integer>.add(1) - on 2 -> position will be the count
        //1,2,2,8,3 - Map<Integer,Integer> map = 1 -> check to see if map contains 1. If it does, continue
        //                                       2 -> check to see if map contains 2. If not
    }

    //8,1,2,2,3
    //after sorting - 1,2,2,3,8
    static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] numCopy = Arrays.copyOf(nums,nums.length);
        Arrays.sort(numCopy);
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<numCopy.length;i++) {
            if(map.containsKey(numCopy[i])) {
                continue;
            }
            map.put(numCopy[i],i);
        }
        for(int i=0;i<nums.length;i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }
}
