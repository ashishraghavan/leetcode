package com.algomonster.problems.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        //1,2,3,4
        //[-1,2,3,4]
        //[0,1,2,3]
        //[100,200,300]
        //[2,-2,3,-3]
        System.out.println(productOfArrayExceptSelf(Arrays.asList(2,-2,3,-3)));
    }

    //1,2,3,4
    //pfSum = [1,1,2,6] -> left=1, pfSum[0]=left, for i in (1,3) left = left*nums.get(i-1), pfSum[i]=left
    //sfSum = [24,12,4,1] -> right=1, sfSum[nums.size()-1]=right, for i in (2,0) right = right*nums.get(i+1), sfSum=right
    //==[24,12,8,6]
    public static List<Integer> productOfArrayExceptSelf(List<Integer> nums) {
        int[] pfSum = new int[nums.size()];
        int[] sfSum = new int[nums.size()];
        int left=1,right=1;
        //pfSum calc.
        pfSum[0]=left;
        for(int i=1;i<pfSum.length;i++) {
            left *= nums.get(i-1);
            pfSum[i] = left;
        }
        //System.out.println(Arrays.toString(pfSum));
        sfSum[sfSum.length-1] = right;
        for(int i=sfSum.length-2;i>=0;i--) {
            right *= nums.get(i+1);
            sfSum[i] = right;
        }
        //System.out.println(Arrays.toString(sfSum));
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<pfSum.length;i++) {
            res.add(pfSum[i]*sfSum[i]);
        }
        return res;
    }
}
