package com.leetcode.medium.array_strings;

//TODO: definitely revise. Took help from co-pilot
// to get intuition behind this problem! - https://copilot.microsoft.com/shares/AjTjYeYh25yK9ccKdSaSS
//prob #162 - find peak element
public class FindPeakElement_L162 {
    public static void main(String[] args) {
        //1,2,1,3,5,6,4
        //1,2,3,1
        //1,2,3,4
        //4,3,2,1
        //2,1
        //1,2
        //3,4,3,2,1
        //6,5,4,3,2,3,2
        System.out.println(findPeakElement(new int[]{6,5,4,3,2,3,2}));
    }

    //1,2,1,3,5,6,4
    public static int findPeakElement(int[] nums) {
        if(nums.length < 3) {
            return (nums.length == 1) ? 0 : ((nums[0] > nums[1]) ? 0 : 1);
        }
        return peak(nums,0,nums.length-1);
    }

    public static int peak(int[] A,int start,int end) {
        if(end - start <= 1) {
            int rem = end - start;
            return switch (rem) {
                case 0 -> start;
                case 1 -> (A[start] > A[end]) ? start : end;
                default -> start;
            };
        }
        int mid = start + (end - start)/2;
        if(A[mid] > A[mid-1] && A[mid] > A[mid+1]) {
            return mid;
        } else if(A[mid] < A[mid+1]) {
            return peak(A,mid+1,end);
        } else {
            return peak(A,start,mid-1);
        }
    }
}
