package com.leetcode.interview;

import java.util.Arrays;

public class MinimumRangeFromSortedArrays {
    public static void main(String[] args) {
        int[] A = new int[]{4,12,27,99};
        int[] B = new int[]{1,5,53,92,102};
        //for each i in A, search for B[j] >= A[i] in B.
        //return (A[i], B[j]) ==> time complexity will be O(mlogn)
        //where m is size of array A, n is size of array B
        //binary search on sorted array B takes O(logn) time

        //System.out.println(Arrays.binarySearch(B, 4));
        System.out.println(Arrays.toString(minimumRangeFromSortedArrays(A,B)));
    }

    static int[] minimumRangeFromSortedArrays(int[] A, int[] B) {
        int[] range = new int[]{-1,-1};
        if (A.length == 0 || B.length == 0) {
            return range;
        }
        int minRange = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int idx = Arrays.binarySearch(B,A[i]);
            if (idx >= 0) {
                return new int[]{A[i],B[idx]};
            }
            //idx = (-(insertion_point) - 1) = -insertion_point + 1
            int currAbsDiff = Math.abs(B[Math.abs(idx) - 1] - A[i]);
            if (currAbsDiff < minRange) {
                minRange = currAbsDiff;
                range[0] = A[i];
                range[1] = B[Math.abs(idx) - 1];
            }
        }
        return range;
    }
}
