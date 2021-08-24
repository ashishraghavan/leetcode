package com.leetcode.array;

import java.util.Arrays;

/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * <p>
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * <p>
 * You may return any answer array that satisfies this condition.
 * [UNSOLVED]
 */
public class SortByParityII {
    public static void main(String[] args) {
        //2,4,3,1,8,9
        //[2,3,1,1,4,0,0,4,3,3]
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{2, 3, 1, 1, 4, 0, 0, 4, 3, 3})));
    }

    private static int[] sortArrayByParityII(int[] array) {
        int ptr1 = 0;
        //array.length will always be 2,4,6,8...even. so, index of array will always be from 0 : n - 1 [which is always odd]
        int ptr2 = array.length - 1;
        if (array.length == 2) {
            //ptr1 is even
            //ptr2 is odd
            if (array[ptr1] % 2 != 0 && array[ptr2] % 2 == 0) {
                swap(ptr1, ptr2, array);
            }
            return array;
        }
        while (ptr1 < ptr2) {
            //If both pointers are at the correct positions &
            //values at both pointers are correct, increment
            //ptr1 and ptr2 and continue;
            if ((ptr1 % 2 == 0 && ptr2 % 2 != 0) &&
                    (array[ptr1] % 2 == 0 && array[ptr2] % 2 != 0)) {
                //both are at the correct position
                //increment ptr1 and ptr2
                ptr1++;
                ptr2--;
            }
            //ptr1 is odd and ptr2 is even and value at ptr1 is even and value at ptr2 is odd
            //ptr1 is even and ptr2 is odd and value at ptr1 is odd and value at ptr2 is even
            else if (((ptr1 % 2 != 0 && ptr2 % 2 == 0) && ((array[ptr1] % 2 == 0) && array[ptr2] % 2 != 0)) ||
                    ((ptr1 % 2 == 0 && ptr2 % 2 != 0) && (array[ptr1] % 2 != 0 && array[ptr2] % 2 == 0))) {
                //swap both values as both are at at wrong positions
                swap(ptr1, ptr2, array);
                ptr1++;
                ptr2--;
            } else {
                //if ptr1 is even and value at ptr1 is even OR ptr1 is odd and value at ptr1 is odd
                if ((ptr1 % 2 == 0 && array[ptr1] % 2 == 0) || (ptr1 % 2 != 0 && array[ptr1] % 2 != 0)) {
                    ptr1++;
                }
                //if ptr2 is even and value at ptr2 is even OR ptr2 is odd and value at ptr2 is odd
                else if ((ptr2 % 2 == 0 && array[ptr2] % 2 == 0) || (ptr2 % 2 != 0 && array[ptr2] % 2 != 0)) {
                    ptr2--;
                }
            }
        }
        return array;
    }

    private static void swap(int indexA, int indexB, int[] array) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}
