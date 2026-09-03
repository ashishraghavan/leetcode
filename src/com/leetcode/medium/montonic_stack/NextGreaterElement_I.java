package com.leetcode.medium.montonic_stack;

import java.util.*;

//#496
public class NextGreaterElement_I {
    public static void main(String[] args) {
        //[4,1,2], [1,3,4,2]
        //nums1 = [2,4], nums2 = [1,2,3,4]
        //[3, 1], [5, 4, 3, 2, 1]
        //[1, 3], [1, 2, 3, 4]
        //[2, 1], [2, 1, 0, -1, 5]
        //[1], [1]
        //[4, 2], [1, 2, 3, 4, 5]
        //[6, 3], [6, 3, 1, 2, 4, 5]
        //[2, 4, 1, 3], [2, 4, 1, 3]
        //[10], [5, 10, 8, 9]
        int[] n1 = new int[]{-5, -2};
        int[] n2 = new int[]{-5, -7, -2, -1};
        System.out.println(Arrays.toString(nextGreaterElementOptimized(n1,n2)));
    }

    //[4,1,2], [1,3,4,2]
    public static int[] nextGreaterElement(int[] n1, int[] n2) {
        int[] nums = new int[10000];
        Arrays.fill(nums,-1);
        Deque<Integer> stk = new ArrayDeque<>();
        for(int i=0;i<n2.length;i++) {
            while(!stk.isEmpty() && n2[i] > n2[stk.peek()]) {
                int prevIdx = stk.pop();
                nums[n2[prevIdx]] = n2[i];
            }
            stk.push(i);
        }
        for(int i=0;i<n1.length;i++) {
            n1[i] = nums[n1[i]];
        }
        return n1;
    }

    public static int[] nextGreaterElementOptimized(int[] n1, int[] n2) {
        Deque<Integer> stk = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n2.length;i++) {
            while(!stk.isEmpty() && n2[i] > stk.peek()) {
                int prev = stk.pop();
                map.put(prev,n2[i]);
            }
            stk.push(n2[i]);
        }
        for(int i=0;i<n1.length;i++) {
            n1[i] = map.getOrDefault(n1[i],-1);
        }
        return n1;
    }
}
