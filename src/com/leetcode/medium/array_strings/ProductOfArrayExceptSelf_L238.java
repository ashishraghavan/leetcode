package com.leetcode.medium.array_strings;

import java.util.Arrays;

public class ProductOfArrayExceptSelf_L238 {
    public static void main(String[] args) {
        //1,2,3,4
        //-1,1,0,-3,3
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));
    }

    //1,2,3,4
    //left[] = [1,1,2,6], prod=1, for i in left, left[0] = prod,prod*=nums[0],
    // left[1]=prod,prod*=nums[1] , left[2]=prod,prod*=nums[2], left[3]=prod,prod*=nums[3]
    //right[] = [24,12,4,1], prod=1, for i in right, right[3] = prod,prod*=nums[3] right[2]=prod,prod*=nums[2],
    // right[1]=prod,prod*=nums[1], right[0]=prod,prod*=nums[0]
    //op = [24,12,8,6]
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] res = new int[nums.length];
        int product = 1;
        for(int i=0;i<left.length;i++) {
            left[i]=product;
            product*=nums[i];
        }
        //System.out.println(Arrays.toString(left));
        product=1;
        for(int i=res.length-1;i>=0;i--) {
            res[i]=product;
            product*=nums[i];
        }
        //System.out.println(Arrays.toString(res));
        for(int i=0;i<res.length;i++) {
            res[i] *= left[i];
        }
        //System.out.println(Arrays.toString(res));
        return res;
    }
}
