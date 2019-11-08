package com.leetcode.practice;

import java.util.Arrays;

//1,0,2,3,0,4,5,0
public class ShiftingArrayElementsRight {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,5,7,0,8,0};
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == 0 && (i+1 < arr.length)) {
                shiftArrayElementsRight(i+1,arr);
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    //Expected : {1,1,2,3,4}
    static void shiftArrayElementsRight(int index,int[] arr) {
        for(int i=arr.length-1;i>=index;i--) {
            arr[i] = arr[i-1];
        }
    }
}
