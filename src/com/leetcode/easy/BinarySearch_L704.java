package com.leetcode.easy;

//prob. # 704 - binary search
public class BinarySearch_L704 {
    public static void main(String[] args) {
        //-1,0,3,5,9,12     9
        //-1,0,3,5,9,12     2
        System.out.println(search(new int[]{-1,0,3,5,9,12},13));
    }

    public static int search(int[] nums, int target) {
        //if(nums.length == 1)return nums[0] == target ? 0 : -1;
        int start = 0, end = nums.length - 1,mid;
        while(start < end) {
            mid = start + ((end-start)/2);
            if(target == nums[mid])return mid;
            else if(target < nums[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return (nums[start] == target) ? start : -1;
    }
}
