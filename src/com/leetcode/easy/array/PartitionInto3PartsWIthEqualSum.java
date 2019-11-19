package com.leetcode.easy.array;

/**
 * Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
 *
 * Formally, we can partition the array i
 * f we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 *
 * Calculate total of the array and divide by k (k is the number of subarray's that this array needs to be divided into)
 * Each partition should now be equal to the total Sum/k. FOUND THIS SOLUTION ON YOUTUBE!!
 */
public class PartitionInto3PartsWIthEqualSum {
    //
    //0,2,1,-6,6,-7,9,1,2,0,1,8
    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
    }

    static boolean canThreePartsEqualSum(int[] arr) {
        int arrSum = 0;
        int sum =0;
        int sumCount = 0;
        int reqSum;
        for(int arrValue : arr) {
            arrSum += arrValue;
        }
        reqSum = arrSum/3;
        for (int arrValue : arr) {
            sum += arrValue;
            if (sum == reqSum) {
                sumCount++;
                sum = 0;
            }
            if (sumCount > 3) {
                return false;
            }
        }
        return (sumCount == 3);
    }
}
