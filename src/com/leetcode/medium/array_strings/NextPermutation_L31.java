package com.leetcode.medium.array_strings;

import java.util.Arrays;

//TODO: with help from https://www.youtube.com/watch?v=JDOXKqF60RQ
//prob #31 - next permutation
public class NextPermutation_L31 {
    public static void main(String[] args) {
        //1,2,3
        //2,3,1
        //3,2,1
        //[1, 2, 3, 4, 5] -> [1, 2, 3, 5, 4]
        //[5, 4, 7, 5, 3, 2] -> [5, 5, 2, 3, 4, 7]
        //[2, 2, 0, 4, 3, 1] -> [2, 2, 1, 0, 3, 4]
        //9,9,9 -> [9,9,9]
        //[1, 3, 5, 4, 2] -> [1, 4, 2, 3, 5]
        //[2, 7, 4, 3, 1] -> [3, 1, 2, 4, 7]
        //[1, 2, 2, 3] -> [1, 2, 3, 2]
        //[1, 2, 3, 4, 6, 5] -> [1, 2, 3, 5, 4, 6]
        //1
        //[1,2]
        //[1,1,5] -> [1,5,1]
        //[2,3,1,3,3] -> [2, 3, 3, 1, 3]
        int[] A = new int[]{2,3,1,3,3};
        nextPermutation(A);
        System.out.println(Arrays.toString(A));
    }

    //[1,2,3] => 123 -> 132
    //1. max # is at ones place ? swap # at ones place with # at tens place
    //1,1,5 => 1,5,1
    //3,2,1 => descending order ? return [sorted in ascending order]
    //1,3,2 => 2,1,3
    //1,4,3,2 => (4,1,3,2) | (3,1,4,2) | (2,4,3,1) | (2,1,4,3) | (2,1,3,4) | (2,3,4,1)
    //2,4,3,1 -> 2,4,1,3 -> 2,1,4,3
    //1,5,4,4,3 -> 3,5,4,4,1 -> 3,5,4,1,4 -> 3,5,1,4,4 -> 3,1,5,4,4 -> 3,1,4,5,4 -> 3,1,4,4,5
    //1,5,4,4,3 -> 1,3,4,4,5 -> 3,1,4,4,5
    //[1,2,7,6,5,4,3] -> 1,2,3,6,5,4,7 -> 1,3,2,6,5,4,7 ->



    //[2,1,5,4,3,0,0]
    //[2,3,5,4,1,0,0]
    //[2,3,1,4,5,0,0]
    //[2,3,0,0,1,4,5]

    //[2,1,3,4,5,0,0]
    //[2,3,1,4,5,0,0]
    //[2,3,0,0,1,4,5]



    //[2,3,1,3,3]
    public static void nextPermutation(int[] nums) {
        int idx = -1;
        for(int i=nums.length-2;i>=0;i--) {
            if(nums[i] < nums[i+1]) {
                idx = i;
                break;
            }
        }
        if(idx == -1) {
            //nums has elements in descending order
            reverse(nums,0,nums.length-1);
            return;
        }
        for(int i=nums.length-1;i>idx;i--) {
            if(nums[i] > nums[idx]) {
                int temp = nums[idx];
                nums[idx]=nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverse(nums,idx+1,nums.length-1);
    }

    public static void reverse(int[] nums,int start,int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
