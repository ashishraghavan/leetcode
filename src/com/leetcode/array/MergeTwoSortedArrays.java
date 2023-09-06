package com.leetcode.array;

import java.util.Arrays;

//leetcode #88
//naive solution
public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] A = new int[]{1,1,3,5,7,0,0,0,0};
        int [] B = new int[]{0,1,1,4};
        int i = 0, j = 0, k;
        while ( j < B.length ) {
            if ( A[i] >= B[j]) {
                if ( A[i] == B[j] ) {
                    i++;
                    continue;
                }
                k = i;
                shiftRight(A, B.length - j, k);
                A[i] = B[j];
                i++;
                j++;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(A));
    }

    static void shiftRight(int[] A, int len, int k) {
        int e = A.length - len;
        while (e > k) {
            A[e] = A[e-1];
            e--;
        }
    }
}
