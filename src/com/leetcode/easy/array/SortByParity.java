package com.leetcode.easy.array;

import java.util.Arrays;

public class SortByParity {
    public static void main(String[] args) {
        //3,1,2,4
        //3,4,1,2,7,9
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{4, 7, 8, 1, 10, 5})));
    }

    /**
     * Set a ptr1 (pointer 1) to the beginning of the array and ptr2 (pointer 2) the end of the array.
     * if array contains only 2 values and value at ptr1 is odd and value at ptr2 is even, swap them
     * and return the array.
     * Run a while loop till ptr2 >= ptr1
     * if value at ptr1 is not odd and value at ptr2 is even, swap them because we want all even numbers
     * to be towards the first portion of the array. Then increment ptr1 and decrement ptr2 as both these
     * values are at the right position.
     * else if value at ptr1 is even and value at ptr2 is odd OR value at ptr1 and value at ptr2 are even
     * increment ptr1 because value at ptr1 is already at the right place (towards the beginning of the array)
     * else we know that values at both ptr1 and ptr2 are odd
     * so decrement ptr2 because value at ptr2 is already at the right place (towards the end of the array).
     *
     * @param array The array to be processed
     * @return the array sorted by parity
     */
    private static int[] sortArrayByParity(int[] array) {
        //easiest way would be to create a new array of same size as original array
        //copy over all even elements toward the beginning & delete them from the original array
        //then copy over the rest towards the end.
        if (array.length == 0) {
            return array;
        }
        int ptr1 = 0;
        int ptr2 = array.length - 1;
        if (array.length == 2) {
            if ((array[ptr1] % 2 != 0) && (array[ptr2] % 2 == 0)) {
                swap(ptr1, ptr2, array);
            }
            return array;
        }
        // || (ptr2 != ptr1 + 1)
        while (ptr2 >= ptr1) {
            if (array[ptr2] % 2 == 0 && array[ptr1] % 2 != 0) {
                swap(ptr1, ptr2, array);
                ptr1++;
                ptr2--;
            } else if ((array[ptr1] % 2 == 0 && array[ptr2] % 2 != 0) ||
                    (array[ptr1] % 2 == 0 && array[ptr2] % 2 == 0)) {
                //increment ptr1 because it is in the right place
                //both numbers are even
                ptr1++;
            } else {
                //both are odd
                //decrement ptr2 because ptr2 is already at the right place.
                ptr2--;
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
