package com.leetcode.easy;

//prob # 2293 - min max game
public class MinMaxGame_L2293 {
    public static void main(String[] args) {
        //1,3,5,2,4,8,2,2
        //3
        System.out.println(minMaxGame(new int[]{3}));
    }

    public static int minMaxGame(int[] nums) {
        if(nums.length == 1)return nums[0];
        int[] newNums = new int[nums.length/2];
        for(int i=0;i<newNums.length;i++) {
            if(i%2 == 0) {
                newNums[i] = Math.min(nums[2*i],nums[(2*i) + 1]);
            } else {
                newNums[i] = Math.max(nums[2*i],nums[(2*i)+1]);
            }
        }
        return minMaxGame(newNums);
    }
}
