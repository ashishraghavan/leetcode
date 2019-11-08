package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 *
 * Do the above modifications to the input array in place, do not return anything from your function.
 */
public class DuplicateZeroes {
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void duplicateZeros(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == 0 && (i+1 < arr.length)) {
                shiftArrayElementsRight(i+1,arr);
                i++;
            }
        }
    }

    static void shiftArrayElementsRight(int index,int[] arr) {
        for(int i=arr.length-1;i>=index;i--) {
            arr[i] = arr[i-1];
        }
    }
}
