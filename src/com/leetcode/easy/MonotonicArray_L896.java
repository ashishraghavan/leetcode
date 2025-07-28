package com.leetcode.easy;

//prob. # 896 - monotonic array
public class MonotonicArray_L896 {
    public static void main(String[] args) {
        //1,2,2,3 -> 1,0,1
        //6,5,4,4 -> -1,-1,0
        //1,3,2
        //-10,-6,-3,0
        //0,-3,-8,-10 -> -3,-5,-2
        //-3,-8,-10,-16 -> -5,-2,-6
        //1,1,2
        //1,1,1,0
        //1,1,2,2,3,4,5,5
        //4,4,4,0
        System.out.println(isMonotonicII(new int[]{1,1,0,1}));
    }

    //suffix,prefix array? incorrect!
    //4,4,4,0 -> [0,0,-1]
    //1,1,1,2 -> [0,0,1]
    //1,1,3,3,7,7,9 -> [t,t,t,t,t,t]
    //1,1,2 -> [t,t]
    //1,1,0

    //-10,-9,-4,-2,0 -> cmp = Integer.compare(-10,0) > 1
    //>= 0
    //1,1,1,0 -< cmp = Integer.compare(1,0) < 0
    //<= 0
    public static boolean isMonotonic(int[] nums) {
        if(nums.length <= 2)return true;
        boolean mt = nums[1] >= nums[0];
        for(int i=2;i<nums.length;i++) {
            if(nums[i] == nums[i-1])continue;
            if((nums[i] > nums[i-1]) != mt)return false;
            mt = nums[i] > nums[i-1];
        }
        return true;
    }

    public static boolean isMonotonicII(int[] nums) {
        if(nums.length <= 2)return true;
        int diff = Integer.compare(nums[0],nums[nums.length-1]);
        for(int i=1;i<nums.length;i++) {
            int currDiff = Integer.compare(nums[i-1],nums[i]);
            if(currDiff == 0)continue;
            if(currDiff != diff)return false;
        }
        return true;
    }
}
