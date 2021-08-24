package com.leetcode.array;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        //1,0,0,0,0,7,0,8,0,10,0,0
        //expected : 1,7,8,10,0,0,0,0,0,0,0,0
        int[] arr = new int[]{0,1,0,3,12};
        //expected : 1,3,13,0,0
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeroes(int[] arr) {
        if(arr.length <= 1) {
            return;
        }
        int nonZeroPtr = 0;
        int loopPtr = 0;
        if(arr.length == 2) {
            if(arr[0] == 0) {
                swap(0,1,arr);
            }
            return;
        }
        //if arr.length > 2
        while(loopPtr < arr.length) {
            if(arr[loopPtr] != 0) {
                arr[nonZeroPtr] = arr[loopPtr];
                nonZeroPtr++;
            }
            loopPtr++;
        }

        for(int j=nonZeroPtr;j<arr.length;j++) {
            arr[j] = 0;
        }
    }

    @SuppressWarnings("unused")
    private static void moveZeroesWithAdditionalSpace(int[] arr) {
        int[] addArr = new int[arr.length];
        int ptr = 0;
        for (int value : arr) {
            if (value != 0) {
                addArr[ptr++] = value;
            }
        }
        System.arraycopy(addArr, 0, arr, 0, arr.length);
    }

    static void swap(int indexA,int indexB,int[] arr) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
