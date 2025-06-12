package com.leetcode.easy;

import java.util.Arrays;

//problem #2404 - most frequent even element
public class MostFrequentEvenElement_L2404 {
    public static void main(String[] args) {
        //0,1,2,2,4,4,1
        //4,4,4,9,2,4
        //29,47,21,41,13,37,25,7
        System.out.println(mostFrequentEven(new int[]{29,47,21,41,13,37,25,7}));
    }

    //0,1,2,2,4,4,1 -> [0:0,2:2,4:2]
    //0 <= nums[i] <= 100000
    //int[] A = new int[100001]
    //2nd draft working solution
    public static int mostFrequentEven(int[] nums) {
        int[] A = new int[100001];
        for (int num : nums) {
            if (num % 2 == 0) {
                A[num]++;
            }
        }
        //find max in A
        int maxVal = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i=i+2) {
            if(A[i] != 0 && A[i] > maxVal) {
                maxVal = A[i];
            }
        }
        if(maxVal == 0)return -1;
        //System.out.println("maVal = "+maxVal);
        for(int i=0;i<A.length;i=i+2) {
            if(A[i] != 0 && A[i] == maxVal)return i;
        }
        return -1;
    }
}
