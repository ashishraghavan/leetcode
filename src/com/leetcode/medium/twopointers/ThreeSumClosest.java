package com.leetcode.medium.twopointers;

import java.util.Arrays;

//#16, see https://share.gemini.google/uD7l7KdzAcfJ
public class ThreeSumClosest {
    public static void main(String[] args) {
        //-1,2,1,-4|1
        //0,0,0|1
        //1, 1, 1, 0|-100
        //1, 1, 1, 0|100
        //-10, -5, 0, 5, 10|4
        //1, 1, 1, 1, 1|3
        //4, 0, 5, -5, 3, 3, 0, -4, -5|-2
        //-100, -100, -100, 100, 100, 100|-100
        //1, 2, 3, 4, 5|1
        //-5, -4, -3, -2, -1|-1
        System.out.println(threeSumClosest(new int[]{-5, -4, -3, -2, -1},-1));
    }

    //-4,-1,1,2, target=1
    //p=-4, -4+y+z<=1 -> y+z<=5
    //-2,0,2,5,6,8, target=7
    //p=-2,q=0,r=8, sum=6, diff=1
    //p=-2,q=2,r=8
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int targetDiff=Integer.MAX_VALUE,currentSum,targetSum=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++) {
            int j=i+1,k=nums.length-1,diff;
            while(j<k) {
                currentSum=nums[i]+nums[j]+nums[k];
                if(currentSum == target) {
                    return currentSum;
                }
                diff = Math.abs(target-currentSum);
                if(diff < targetDiff) {
                    targetDiff = diff;
                    targetSum = currentSum;
                }
                if(currentSum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return targetSum;
    }
}
