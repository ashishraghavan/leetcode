package com.leetcode.easy;

//prob. # 268 - missing number
public class MissingNumber_L268 {
    public static void main(String[] args) {
        //3,0,1
        //9,6,4,2,3,5,7,0,1
        System.out.println(missingNumber(new int[]{3,0,1}));
    }

    //3,0,1     n=3, sum(3) = 3*4/2 = 6, act. sum = 4 rem. = 6-4 = 2
    //0,1,2,3   n=4, sum(4) = 10, act. sum = 6, rem. = 10-6 = 4
    //sum = 9*10/2 = 45, act. sum = 37, rem. 45-37 = 8
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int expSum = (n * (n+1))/2;
        int actSum = 0;
        for (int num : nums) {
            actSum += num;
        }
        return expSum - actSum;
    }
}
