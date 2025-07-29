package com.leetcode.easy;

//prob # 3392 - subarray count of length = 3 with given condition
public class SubArrayCntOfLength3WithCondition_L3392 {
    public static void main(String[] args) {
        //1,2,1,4,1
        //1,1,1
        //-1,-4,-1,4
        System.out.println(countSubarrays(new int[]{-1,-4,-1,4}));
    }

    public static int countSubarrays(int[] nums) {
        int i=0,j=2,cnt=0;
        for(;j<nums.length;i++,j++) {
            if((double)(nums[i] + nums[j]) == (double)nums[i+1]/2)cnt++;
        }
        return cnt;
    }
}
