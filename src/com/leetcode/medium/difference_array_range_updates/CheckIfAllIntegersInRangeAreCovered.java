package com.leetcode.medium.difference_array_range_updates;

import java.util.Arrays;

//#1893
public class CheckIfAllIntegersInRangeAreCovered {
    public static void main(String[] args) {
        //{{1,2},{3,4},{5,6}};
        //{{20, 30}, {5, 15}, {10, 25}, {1, 5}};
        //{{1, 25}, {26, 50}};
        //{{1, 1}, {2, 2}, {3, 3}, {4, 5}}; 1,5
        //{{1, 50}};
        //{{5, 10}, {10, 15}}; 1,12
        //{{1, 10}, {10, 20}};
        //{{1, 4}, {6, 10}}; | 5,5 ---> fail
        //{{1, 5}, {10, 15}};
        //{{1, 10}, {12, 20}}; | 5,15 ---> fail
        //{{20, 30}, {5, 15}, {10, 25}, {1, 5}}; 3,28
        int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
        int left = 2;
        int right = 5;
        System.out.println(isCoveredII(ranges,left,right));
    }

    public static boolean isCovered(int[][] ranges, int left, int right) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int[] range : ranges) {
            min = Math.min(min,range[0]);
            max = Math.max(max, range[1]);
        }
        return left >= min && right <= max;
    }

    public static boolean isCoveredII(int[][] ranges, int left, int right) {
        Arrays.sort(ranges,(r1,r2)->Integer.compare(r1[0],r2[0]));
        for(int[] range : ranges) {
            int start = range[0];
            int end = range[1];
            if(left >= start && left <= end) {
                left = end + 1;
            }
            if(left > right) {
                return true;
            }
        }
        return left > right;
    }
}
