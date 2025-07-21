package com.leetcode.easy;

import java.util.Arrays;

//TODO: definitely revise, 45 mins to come up with a working solution
//prob. #26 - remove duplicates from sorted array
public class RemoveDuplicatesFromSortedArray_L26 {
    public static void main(String[] args) {
        //0,0,1,1,1,2,2,3,3,4
        //0.1,2,3,4,4,4,4
        //1,1,1,1,1,1
        //0,1,2,3,4
        int[] nums = new int[]{0,1,2,3,4};
        System.out.println(removeDuplicates(nums));
    }

    //2 pointer
    //0,0,1,1,1,2,2,3,3,4   exp. 0,1,2,3,4,*,*,*,*,* return 5
    //i=1,j=1 [i]<=[i-1]i++, [j]<=[j-1] || [j]<=[i-1]j++, swap(i,j),i++,j++ i=2,j=3 -> 0,1,2,1,1,0,2,3,3,4, i=3,j=6 -> 0,1,2,3,1,0,2,1,3,4, i=4,j=7 -> 0,1,2,3,1,0,2,1,3,4
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1)return 1;
        int i=1,j=1;
        while(j < nums.length) {
            while(i < nums.length && nums[i] > nums[i-1])i++;
            while(j < nums.length && (nums[j] <= nums[j-1] || nums[j] <= nums[i-1])){
                j++;
            }
            if(i >= nums.length || j >= nums.length)break;
            swap(nums,i,j);
            i++;
            j++;
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }

    public static void swap(int[] nums,int x,int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
