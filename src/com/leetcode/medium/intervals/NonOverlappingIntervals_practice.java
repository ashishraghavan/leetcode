package com.leetcode.medium.intervals;

import java.util.Arrays;
import java.util.Comparator;

//#435, refer for optimized approach - https://share.gemini.google/uzTe8Y7zCeub
public class NonOverlappingIntervals_practice {
    public static void main(String[] args) {
        //new int[][]{{0, 2}, {1, 10}, {2, 4}, {3, 10}, {4, 6}, {5, 10}} -> 3
        //new int[][]{{5, 10}, {-20, -10}, {12, 20}, {-5, 2}} -> 0
        //new int[][]{{1, 3}, {2, 3}, {3, 5}, {4, 5}} -> 2
        //new int[][]{{1, 5}, {2, 5}, {3, 5}, {4, 5}} -> 3
        //new int[][]{{1, 6}, {2, 8}, {7, 12}, {10, 16}} -> 2
        //new int[][]{{1, 10}, {2, 9}, {3, 8}, {4, 7}} -> 3
        //new int[][]{{-10, -5}, {-6, 2}, {1, 5}, {4, 8}} -> 2
        //new int[][]{{-2147483648, -2147483647}, {2147483646, 2147483647}} -> 0
        int[][] intervals = new int[][]{{-2147483648, -2147483647}, {2147483646, 2147483647}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    // *** sort by end time to optimize ***
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i->i[0]));
        int count = 0;
        int[] last = intervals[0];
        for(int i=1;i<intervals.length;i++) {
            if(isOverlapping(last,intervals[i])) {
                if(intervals[i][1] <= last[1]) {
                    last = intervals[i];
                }
                count++;
            } else {
                //set last = interval with max end time
                if(intervals[i][1] >= last[1]) {
                    last = intervals[i];
                }
            }
        }
        return count;
    }

    public static boolean isOverlapping(int[] a,int[] b) {
        return b[0] < a[1];
    }
}
