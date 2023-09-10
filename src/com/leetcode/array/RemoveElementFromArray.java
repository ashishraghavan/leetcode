package com.leetcode.array;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 *
 * interviewbit.com - see Two Pointers Problems
 * leetcode - #27
 * Given A : [4,1,4,1,4,2] & B = some value in the array,
 * remove all instances of B from A.
 * update the array so that all instances of B
 * are towards the end of the array like such : [1,1,2,4,4,4] &
 * return the length of the updated array - 3 in this case.
 * What remains after you remove all duplicates from the array does not matter
 */
public class RemoveElementFromArray {
    public static void main(String[] args) {
        //int[] A = new int[]{4,1,4,1,4,2};//B = 4
        //int[] A = new int[]{1, 6, 8, 10, 0, 3, 10, 3};//B = 3
        int[] A = new int[]{7, 2, 5, 3, 6, 8, 6, 9};//B = 6
        int i = 0, j = 0, B = 10;
        //if B doesn't exist in A, print array & length = A.length
        //time comp. === O(n), space comp. === O(1)
        if (!Arrays.stream(A).filter(element -> element == B).findFirst().isPresent()) {
            System.out.println(Arrays.toString(A));
            System.out.println("length : "+(A.length));
            return;
        }
        //
        while ( j < A.length ) {
            if ( A[j] == B ) {
                j++;
                continue;
            } else {
                swap(A,i,j);
                i++;
            }
            if (A[i] == B) {
                j = i + 1;
            }
        }
        System.out.println(Arrays.toString(A));
        System.out.println("length : "+i);
    }

    private static void swap(int[] A, int idx1, int idx2) {
        int temp = A[idx1];
        A[idx1] = A[idx2];
        A[idx2] = temp;
    }
}
