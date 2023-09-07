package com.leetcode.array;

import java.util.Arrays;

//interviewbit - remove duplicates from sorted array II
public class RemoveDuplicatesFromSortedArray_II {
    public static void main(String[] args) {
        //arr has been sorted, time comp. = O(nlogn) using quick sort
        //int[] A = new int[]{1,1,1,2,2,2,2,4,4,4};
        //int[] A = new int[]{1,1,1,2,2,2,2,4};
        int[] A = new int[]{1,1,2,2,4};
        int count = 1, i = 1, curr = A[0];
        //O(n)
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
        int a = -1, b;
        //O(n)
        for (int k = 0; k < A.length; k++) {
            if (A[k] == -1) {
                a = k;
                break;
            }
        }
        if ( a == -1 ) {
            //no element = -1 in A, print original length of array & return
            System.out.println(A.length);
            return;
        }
        b = a + 1;
        //O(n) -- ??
        while ( a < b && b < A.length) {
            if (A[b] != -1) {
                swap(A, a, b);
                a++;
            }
            b++;
        }
        System.out.println(Arrays.toString(A));
        System.out.println("length : "+a);
    }

    private static void swap(int[] A, int idx1, int idx2) {
        int temp = A[idx1];
        A[idx1] = A[idx2];
        A[idx2] = temp;
    }
}
