package com.leetcode.easy;

//prob # 1822 - sign of product of array
public class SignOfProductOfArray_L1822 {
    public static void main(String[] args) {
        //-1,-2,-3,-4,3,2,1
        //1,5,0,2,-3
        //-1,1,-1,1,-1
        System.out.println(arraySign(new int[]{-1,1,-1,1,-1}));
    }

    //-1,-2,-3,-4,3,2,1
    //for in in (0,nums.length-1) if nums[i]==0 return 0
    //if cnt(-ve) % 2 == 0 ? return 1 : -1
    public static int arraySign(int[] nums) {
        int nCt = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) nCt++;
        }
        return (nCt % 2 == 0) ? 1 : -1;
    }
}
