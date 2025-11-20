package com.leetcode.medium.array_strings;

//TODO: definitely [revise], implementation of kadane's algorithm. Make sure to do the following related problems
// 1. https://leetcode.com/problems/longest-turbulent-subarray/
// 2. https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
// 3. https://leetcode.com/problems/maximum-subarray-sum-after-one-operation/
// 4. https://leetcode.com/problems/find-the-substring-with-maximum-cost/
// 5. https://leetcode.com/problems/maximum-good-subarray-sum/
//prob #53 - maximum subarray sum
public class MaximumSubarray_L53 {
    public static void main(String[] args) {
        //-2,1,-3,4,-1,2,1,-5,4
        //5,4,-1,7,8
        //100,-90,80,-70,60,-50,40
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int localMax = nums[0];
        int globalMax = nums[0];
        for(int i=1;i<nums.length;i++) {
            localMax = Math.max(nums[i],nums[i]+localMax);
            globalMax = Math.max(localMax,globalMax);
        }
        return globalMax;
    }
}
