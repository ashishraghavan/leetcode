package com.leetcode.practice;

/**
 * Patterns in problem solving
 * Sliding window pattern
 *      Find max sum of k consecutive numbers in array of size n
 * problem link : https://www.baeldung.com/cs/sliding-window-algorithm#fixed-size-sliding-window
 */
public class FixedSizeSlidingWindow {
    public static void main(String[] args) {
        //n = 5, k = 3
        int[] arr = new int[]{-7, -1, 17, -9, 5, -12, 18, 15, -4, 7};
        int k = 3;
        //int answer = Arrays.stream(arr).sum();
        //int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0;i < k; i++) {
            sum += arr[i];
        }
        //sum = 9
        //maxSum = 9
        int maxSum = sum;
        int slidWinSum;
        for (int i = k; i < arr.length; i++) {
            slidWinSum = sum + arr[i] - arr[i - k];
            sum = slidWinSum;
            maxSum = Math.max(maxSum, slidWinSum);
        }
        System.out.println("max sum in sub-array of size "+k+" is "+maxSum);
    }
}
