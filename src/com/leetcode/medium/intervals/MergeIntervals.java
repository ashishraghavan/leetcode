package com.leetcode.medium.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//#56
public class MergeIntervals {
    public static void main(String[] args) {
        //[1,3],[2,6],[8,10],[15,18]
        //new int[][]{{1, 4}}
        //new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}}
        //new int[][]{{1, 10}, {2, 3}, {4, 5}, {6, 7}}
        //new int[][]{{1, 4}, {0, 4}}
        //new int[][]{{1, 4}, {2, 3}}
        //new int[][]{{1, 4}, {0, 0}}
        //new int[][]{{1, 4}, {0, 2}, {3, 5}}
        //new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}}
        int[][] result = merge(new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}});
        for(int[] ans : result) {
            System.out.println(ans[0]+", "+ans[1]);
        }
    }

    //sort by start time intv[0]
    //[1,3],[2,6],[8,10],[15,18]
    public static int[][] merge(int[][] intv) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intv, (iv1,iv2) -> iv1[0]-iv2[0]);
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
        //String[] y = x.toArray(new String[0]);
        return result.toArray(new int[result.size()][]);
        //return new int[][]{{0,0}};
    }

    public static boolean isOverlapping(int[] a,int[] b) {
        return b[0] <= a[1];
    }
}
