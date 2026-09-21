package com.leetcode.medium.intervals;

import java.util.Arrays;

//#435
//refer https://share.gemini.google/4q04xlQCn3df for solution
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        //new int[][]{{1, 10}, {2, 3}, {3, 4}, {4, 5}}
        //new int[][]{{3, 4}, {2, 3}, {1, 2}}
        //new int[][]{{1, 4}, {2, 3}}
        //new int[][]{{-50, -20}, {-30, -10}, {-25, -15}, {-10, 0}}
        //new int[][]{{1, 5}, {2, 3}, {3, 4}, {4, 6}}
        //new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}}
        int[][] input = new int[][]{{1, 5}, {2, 3}, {3, 4}, {4, 6}};
        System.out.println(eraseOverlapIntervals(input));
    }

    //{2, 3}, {3, 4}, {4, 5}, {1, 10}
    //
    //why sort end times ascending? = because we want to keep the interval with earliest end time
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1)return 0;
        Arrays.sort(intervals,(i1,i2)->Integer.compare(i1[1],i2[1]));
        int prevEnd = intervals[0][1],removals = 0;
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0] < prevEnd) {
                removals++;
            } else {
                prevEnd = intervals[i][1];
            }
        }
        return removals;
    }
}
