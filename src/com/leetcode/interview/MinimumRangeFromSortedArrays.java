package com.leetcode.interview;

import java.util.Arrays;

public class MinimumRangeFromSortedArrays {
    public static void main(String[] args) {
//        int[] A = new int[]{4,12,27,99};
//        int[] B = new int[]{1,5,53,92,102};
        int[] A = new int[]{0,4,12,27,59,99,103,120};
        int[] B = new int[]{1,6,53,92,104};
//        int[] A = new int[]{5,8,13,14,18,25,28,31,37,40,42};
//        int[] B = new int[]{22,35,41,45,48,53,59,64,67,71,74,78,80};
//        int[] A = new int[]{5,8,13,14,18,25,28,31,37,40,42};
//        int[] B = new int[]{22,35,48,53,59,64,67,71,74,78,80};
        //System.out.println(Arrays.binarySearch(B,0));
        System.out.println(Arrays.toString(minimumRangeFromSortedArrays(A,B)));
    }

    //for each i in A, search for B[j] >= A[i] in B.
    //return (A[i], B[j]) ==> time complexity will be O(mlogn)
    //where m is size of array A, n is size of array B
    //binary search on sorted array B takes O(logn) time
    static int[] minimumRangeFromSortedArrays(int[] A, int[] B) {
        int[] range = new int[]{-1,-1};
        if (A.length == 0 || B.length == 0) {
            return range;
        }
        int minRange = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int idxBS = Arrays.binarySearch(B,A[i]);
            if (idxBS >= 0) {
                return new int[]{A[i],B[idxBS]};
            }
            //idx = (-(insertion point) - 1) = -insertion_point - 1
            int actualIdx = Math.abs(idxBS) - 1;
            if (actualIdx >= B.length) {
                actualIdx--;
            }
            int first;
            int second;
            if (actualIdx == 0 || ((B[actualIdx] - A[i]) < (A[i] - B[actualIdx - 1]))) {
                first = A[i];
                second = B[actualIdx];
            } else {
                first = B[actualIdx - 1];
                second = A[i];
            }
            if (Math.abs(second - first) < minRange) {
                minRange = Math.abs(second - first);
                range[0] = first;
                range[1] = second;
            }
        }
        return range;
    }
}
