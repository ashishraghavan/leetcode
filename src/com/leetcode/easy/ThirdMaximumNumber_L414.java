package com.leetcode.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

//TODO: review
//check https://github.com/doocs/leetcode/tree/main/solution/0400-0499/0414.Third%20Maximum%20Number
//for
//more
//details
public class ThirdMaximumNumber_L414 {
    public static void main(String[] args) {
        //2,2,3,1
        //1,2
        //3,2,1
        //7,5,8,4,5,8,6
        //1
        //2,2,2,2,1
        System.out.println(thirdMax(new int[]{1,2}));
    }

    //3,2,1 -> 1,2,3
    //2,2,2,2,1 -> 1,2,2,2,2
    //2,2,3,1 -> 1,2,2,3
    //7,5,8,4,5,8,6 -> 4,5,5,6,7,8,8
    //0,-10,0,-10,-10,0,0
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 3) {
            return nums[nums.length-1];
        }
        int ct = 1;
        int i = nums.length-1;
        int res = -1;
        for(;i>=1;i--) {
            if(nums[i] != nums[i-1]) {
                ++ct;
            }
            if(ct == 3) {
                res = i-1;
                break;
            }
        }
        return ct < 3 ? nums[nums.length-1] : nums[res];
    }

    public static int getMaxIndex(int[] nums) {
        //IntStream.rangeClosed(0,nums.length-1).map(i->nums[i]).max().orElse(-1);
        Integer max = Arrays.stream(nums).boxed().max(Integer::compareTo).orElse(null);
        return -1;
    }
}
