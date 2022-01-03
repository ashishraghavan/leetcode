package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;


/**
 * GeeksForGeeks
 * Given 3 sorted arrays A, B and C with lengths n1, n2 and n3, find elements
 * that are common to all three arrays.
 * TARGET : O(n1 + n2 + n3) time & O(n1 + n2 + n3) space complexity.
 */
public class GetDesiredArrayIndex {

    public static void main(String[] args) {
        //A = new int[]{1,7,9,2,3,6}
        int[] A = new int[]{1,2,3,6,7,9};
        //B = new int[]{9,5,4,1,0}
        int[] B = new int[]{0,1,4,5,9};
        //C = new int[]{1,7,2,9,6};
        int[] C = new int[]{1,2,6,7,9};
        //get common elements from above 3 sorted array in O(n1 + n2 + n3) time where n1, n2 & n3 are lengths
        //of arrays A, B and C respectively.
        for(Integer element : getCommonElements(A,B,C)) {
            System.out.print(element+" ");
        }
    }

    static List<Integer> getCommonElements(int[] A, int[] B, int[] C) {
        List<Integer> result = new ArrayList<>();
        int i=0,j=0,k=0;
        while(i < A.length && j < B.length && k < C.length) {
            int aVal = A[i];
            int bVal = B[j];
            int cVal = C[k];
            if(aVal == bVal && bVal == cVal) {
                result.add(aVal);
                i++;
                j++;
                k++;
                continue;
            }
            //increment index with least value.
            //A[i] = 5, B[j] = 9, C[k] = 7
            //A[i] = 1, B[j] = 0, C[k] = 1
            //A[i] = 9, B[j] = 9, C[k] = 7
            if(aVal <= bVal) {
                if(aVal <= cVal) {
                    i++;
                } else {
                    k++;
                }
            } else {
                if(bVal <= cVal) {
                    j++;
                } else {
                    k++;
                }
            }
        }
        return result;
    }
}
