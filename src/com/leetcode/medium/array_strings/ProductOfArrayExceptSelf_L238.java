package com.leetcode.medium.array_strings;

import java.util.Arrays;

//prob #238 - product of array except self
//TODO: refer https://copilot.microsoft.com/shares/Sa1mL7GxYmL6SEn3mbDVt for explanation of solution - productExceptSelfII(..)
public class ProductOfArrayExceptSelf_L238 {
    public static void main(String[] args) {
        //1,2,3,4
        //-1,1,0,-3,3
        System.out.println(Arrays.toString(productExceptSelfIII(new int[]{1,2,3,4})));
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

    //1,2,3,4
    //24,12,4,1
    //1,1,2,6
    //product=res[0], i in nums, res[i]*=product,product*=nums[i]
    public static int[] productExceptSelfII(int[] nums) {
        int[] res = new int[nums.length];
        int product=1;
        for(int i=res.length-1;i>=0;i--) {
            res[i]=product;
            product*=nums[i];
        }
        product=1;
        for(int i=0;i<nums.length;i++) {
            res[i]*=product;
            product*=nums[i];
        }
        return res;
    }


    //-1,1,0,-3,3
    //1,2,3,4
    //pf[] = [1,1,2,6]
    //sf[] = [24,12,4,1]
    //[] = [24,12,8,6]
    public static int[] productExceptSelfIII(int[] nums) {
        int[] pfProduct = new int[nums.length];
        int[] sfProduct = new int[nums.length];
        int[] resProduct = new int[nums.length];
        //pfProduct[0]=1;
        //sfProduct[sfProduct.length-1]=1;
        int product = 1;
        for(int i=0;i<nums.length;i++) {
            pfProduct[i] = product;
            product *= nums[i];
        }
        product = 1;
        for(int i=nums.length-1;i>=0;i--) {
            sfProduct[i] = product;
            product *= nums[i];
        }
        System.out.println(Arrays.toString(pfProduct));
        System.out.println(Arrays.toString(sfProduct));
        for(int i=0;i<resProduct.length;i++) {
            resProduct[i] = pfProduct[i] * sfProduct[i];
        }
        return resProduct;
    }

    //1,2,3,4
    //res = [1,1,2,6] -> [1*2*3*4,1*3*4,2*1*4,6*1], i=3, rprd=1, i=2, rprd*=nums[i+1]=4,  i=1, rprd*=nums[i+1]=12,  i=0, rprd*=nums[i+1]=24
    public static int[] productExceptSelfIV(int[] nums) {
        int[] resProduct = new int[nums.length];
        int product = 1;
        for(int i=0;i<nums.length;i++) {
            resProduct[i] = product;
            product *= nums[i];
        }
        System.out.println(Arrays.toString(resProduct));
        product = 1;
        for(int i=nums.length-2;i>=0;i--) {
            product *= nums[i+1];
            resProduct[i] *= product;
        }
        System.out.println(Arrays.toString(resProduct));
        return resProduct;
    }
}
