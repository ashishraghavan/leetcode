package com.leetcode.medium.binary_search_on_answer;

//#410, [HARD]
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        //7,2,5,10,8|2
        //1,2,3,4,5|2
        System.out.println(splitArray(new int[]{1,2,3,4,5},2));
    }

    public static int splitArray(int[] A, int k) {
        int left = -1;
        int right = 0;

        //we take left = max(A) because it is given that each sub-array should be non-empty.
        //If k=A.length, there will be total of A.length sub-array's and the answer in this case will be max(A)

        //we take right = sumOf(A) because that is the maximum possible answer.
        //If k=1, the answer is sumOf(A) as 1 sub-array == entire array.

        //Therefore, range for binarySearch is (max(A),sumOf(A))
        for(int val : A) {
            left = Math.max(left,val);
            right += val;
        }
        while(left < right) {
            int mid = left + (right - left)/2;
            if(isValid(A,mid,k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isValid(int[] A,int maxSum,int k) {
        //min subarray count = 1. there will always be a 1 element subarray(given that A.length != 0)
        int count = 1;
        int currSum = 0;
        for(int val : A) {
            if(currSum + val > maxSum) {
                currSum = val;
                count++;
            } else {
                currSum += val;
            }
        }
        return count <= k;
    }
}
