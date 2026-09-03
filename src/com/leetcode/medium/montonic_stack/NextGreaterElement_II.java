package com.leetcode.medium.montonic_stack;

import java.util.*;

//#503
public class NextGreaterElement_II {
    public static void main(String[] args) {
        //1,2,3,4,3
        //1,2,1
        //new int[]{4, 3, 2, 1};
        //new int[]{1, 2, 3, 4, 5};
        //new int[]{7, 7, 7, 7};
        //new int[]{42};
        //new int[]{-2, -3, -1};
        //new int[]{5, 1, 2, 1, 5};
        //new int[]{10, 1, 10, 1, 10};
        //new int[]{9, 8, 7, 3, 2, 1, 6};
        //new int[]{2, 2, 2, 2, 3};
        int[] nums = new int[]{9, 8, 7, 3, 2, 1, 6};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stk = new ArrayDeque<>();
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        for(int i=0;i<2*nums.length;i++) {
            int idx = i % nums.length;
            while(!stk.isEmpty() && nums[idx] > nums[stk.peek()]) {
                int prevIdx = stk.pop();
                result[prevIdx] = nums[idx];
            }
            if(i < nums.length) {
                stk.push(idx);
            }
        }
        return result;
    }
}
