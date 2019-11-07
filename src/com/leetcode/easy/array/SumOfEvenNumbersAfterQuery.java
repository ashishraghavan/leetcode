package com.leetcode.easy.array;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQuery {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{1,2,3,4},
                new int[][]{
                        {1,0},
                        {-3,1},
                        {-4,0},
                        {2,3}})));
    }

    static int[] sumEvenAfterQueries(int[] arr, int[][] queries) {
        int[] modQueries = new int[arr.length];
        int evenCount;
        int arrCount = 0;
        for(int i=0;i<arr.length;i++) {
            evenCount = 0;
            int val = queries[i][0];
            int index = queries[i][1];
            if(index >= arr.length) {
                continue;
            }
            arr[index] += val;
            //sum of even values
            for (int value : arr) {
                if (value % 2 == 0) {
                    evenCount += value;
                }
            }
            modQueries[arrCount++]=evenCount;
        }
        return modQueries;
    }
}
