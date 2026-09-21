package com.leetcode.medium.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//#57
//refer https://share.gemini.google/Y6ua7YwIaqc6
public class InsertInterval {
    public static void main(String[] args) {
        //new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};    new int[]{4,8};
        //new int[][]{}     new int[]{5, 7}
        //new int[][]{{2, 3}, {5, 7}, {8, 10}} | new int[]{1, 12}
        int[][] a = new int[][]{{2, 3}, {5, 7}, {8, 10}};
        int[] b = new int[]{1, 12};
        int[][] result = insertII(a,b);
        for(int[] ans : result) {
            System.out.println(ans[0]+", "+ans[1]);
        }
    }

    //new int[][]{{2, 3}, {5, 7}, {8, 10}} | new int[]{1, 12}
    public static int[][] insertII(int[][] intervals, int[] newInterval) {
        int i = 0;
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        while(i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        while(i < n && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
                i++;
        }
        result.add(newInterval);
        while(i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    //{1,2},{3,5},{6,7},{8,10},{12,16} | {4,8}
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] copyIntervals = new int[intervals.length+1][2];
        int i=0;
        for(;i<intervals.length;i++) {
            copyIntervals[i] = intervals[i];
        }
        copyIntervals[i] = newInterval;
        return merge(copyIntervals);
    }

    public static int[][] merge(int[][] intv) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intv, (iv1, iv2) -> iv1[0]-iv2[0]);
        result.add(intv[0]);
        for(int i=1;i<intv.length;i++) {
            int[] lastInterval = result.get(result.size()-1);
            if(isOverlapping(lastInterval,intv[i])) {
                //update lastInterval coordinates
                lastInterval[1] = Math.max(lastInterval[1],intv[i][1]);
            } else {
                //add interval to result
                result.add(intv[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static boolean isOverlapping(int[] a,int[] b) {
        return b[0] <= a[1];
    }
}
