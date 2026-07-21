package com.leetcode.medium.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//#18, see https://share.gemini.google/BujPF4GCxiOf
public class FourSum {
    public static void main(String[] args) {
        //1,0,-1,0,-2,2|0
        //2, 2, 2, 2, 2|8 - F
        //1,2,3|6
        //1000000000, 1000000000, 1000000000, 1000000000| -294967296 - F
        //-2, -2, -2, 0, 0, 0, 2, 2, 2|0 - F
        System.out.println(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000},-294967296));
    }

    //-2,-1,0,0,1,2, target=0
    //fix -2,-1, -2-1+r+s=target=0 -> r+s = 3 l=1,r=5 [-2,-1,1,2] ->
    //fix -2,0, -2+0+r+s=0 -> r+s=2 l=3,r=5 [-2,0,0,2]
    //fix -2,0,
    //fix
    //fix -1,0, -1+0+r+s=0 -> r+s=1, [-1,0,0,1]
    //fix 0,0, 0+0+r+s=0, r+s=0, NA

    //-10, -5, -1, 0, 1, 5, 10, target = 0
    //fix -10, [1,6] -> fix -5 [-10,-5,5,10], fix -1 [-10,-1,1,10]
    //fix -5, [2,6] -> fix 0.... [-5,-1,1,5]

    //2, 2, 2, 2, 2, target=8
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++) {
            if(i>0 && nums[i]==nums[i-1])continue;
            for(int j=i+1;j<nums.length-2;j++) {
                //By using j > i + 1 below, we are explicitly telling the algorithm: "It is okay if the number at j is the exact
                //same as the number at i, because they represent two different slots in our quadruplet.
                //But j is NOT allowed to be the same number as the PREVIOUS j."
                if(j>i+1 && nums[j]==nums[j-1])continue;
                int k = j+1, l = nums.length-1;
                while(k < l) {
                    //below sum can overflow so casting it to long
                    long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum == target) {
                        result.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        //TODO: why skip only when we find the solution
                        while(k < l && nums[k] == nums[k+1]) {
                            k++;
                        }
                        //TODO: why skip only when we find the solution
                        while(k < l && nums[l]==nums[l-1]) {
                            l--;
                        }
                        k++;
                        l--;
                    } else if(sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return result;
    }
}
