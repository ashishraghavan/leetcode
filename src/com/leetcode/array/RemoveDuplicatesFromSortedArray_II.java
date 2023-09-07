package com.leetcode.array;

import java.util.Arrays;

//interviewbit - remove duplicates from sorted array II
public class RemoveDuplicatesFromSortedArray_II {
    public static void main(String[] args) {
        //arr has been sorted, time comp. = O(nlogn) using quick sort
        int[] A = new int[]{1,1,1,2,2,2,2,4,4,4};
        int count = 1, i = 1, curr = A[0];
        while ( i < A.length ) {
            if ( A[i] == curr ) {
                count++;
            } else {
                curr = A[i];
                count = 1;
            }
            if ( count > 2 ) {
                A[i] = -1;
            }
            i++;
        }
        System.out.println(Arrays.toString(A));
    }
}
