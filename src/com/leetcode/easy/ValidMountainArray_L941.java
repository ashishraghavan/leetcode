package com.leetcode.easy;

import java.util.stream.IntStream;

//TODO: review
//problem # 941 - validate mountain array
//check https://github.com/doocs/leetcode/tree/main/solution/0900-0999/0941.Valid%20Mountain%20Array
//for
//more
//details
public class ValidMountainArray_L941 {
    public static void main(String[] args) {
        //3,5,6,10,8,3,1
        //10,8,6,5,1
        //1,5,6,8,10
        //0,2,3,3,5,2,1,0
        //10,8,6,6,1
        //6,5,6,8,10
        //2,1
        //3,5,5
        //0,3,2,1
        System.out.println(validMountainArray(new int[]{10,8,6,6,1}));
    }

    public static boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int max = IntStream.rangeClosed(0,arr.length-1).map(i->arr[i]).max().orElse(-1);
        if(max == -1)return false;
        int mxIndex = getMaxIndex(arr,max);
        if(mxIndex == -1)return false;
        return validateLeftSubArray(arr,mxIndex-1,0) &&
                validateRightSubArray(arr,mxIndex+1,arr.length-1);
    }

    public static int getMaxIndex(int[] arr,int max) {
        int mxCt = 0;
        int mxIndex = -1;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == max) {
                mxIndex = i;
                mxCt++;
            }
        }
        return mxCt == 1 ? mxIndex : -1;
    }

    //10,8,6,5,1
    public static boolean validateLeftSubArray(int[] arr,int start,int end) {
        if(start < end) return false;
        for(int i = start; i > end; i--) {
            if(arr[i] <= arr[i-1]) {
                return false;
            }
        }
        return true;
    }

    //1,5,6,8,10
    public static boolean validateRightSubArray(int[] arr,int start,int end) {
        if(start > end) return false;
        for(int i = start; i < end; i++) {
            if(arr[i] <= arr[i+1]) {
                return false;
            }
        }
        return true;
    }
}
