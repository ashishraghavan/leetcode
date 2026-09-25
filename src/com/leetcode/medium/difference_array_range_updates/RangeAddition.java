package com.leetcode.medium.difference_array_range_updates;

import java.util.Arrays;

//#370
//refer https://share.gemini.google/nVGGRtMGtiIu for solution
public class RangeAddition {
    public static void main(String[] args) {
        int length = 5;
        int[][] input = new int[][]{{1,3,2},{2,4,3},{0,2,-2}};
        System.out.println(Arrays.toString(getModifiedArray(length,input)));
    }

    //We use the concept of prefix sum to compute final values for all indexes.
    //we don't need to update all indices (start -> end). We only update starting & ending + 1 index (if it is less than length of the array)
    //because value is added/applied to all indices from start -> end proportionately.
    //We update only the beginning of the next update cycle because.
    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length];
        for(int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int val = update[2];

            diff[start] += val;
            if(end+1 < length) {
                diff[end+1] -= val;
            }
        }
        for(int i=1;i<diff.length;i++) {
            diff[i] += diff[i-1];
        }
        return diff;
    }
}
