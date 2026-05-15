package com.algomonster.problems.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        //[[8,10],[2,6],[15,18],[1,3]]
        //[[1,4],[2,3],[5,6]]
        //Arrays.asList(Arrays.asList(8,10),Arrays.asList(2,6),Arrays.asList(15,18),Arrays.asList(1,3))
        System.out.println(mergeIntervals(Arrays.asList(Arrays.asList(1,4),Arrays.asList(2,3),Arrays.asList(5,6))));
    }

    //[[1,3],[2,6],[8,10],[15,18]]
    //sort by start time
    //[[1, 3], [2, 6], [8, 10], [15, 18]]
    //res = [[1,6],[8,10],[15,18]]
    public static List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {
        List<List<Integer>> res = new ArrayList<>();
        intervals.sort((l1,l2)->l1.get(0).compareTo(l2.get(0)));
        for(List<Integer> interval : intervals) {
            if(res.isEmpty() || !overlap(res.get(res.size()-1),interval)) {
                res.add(interval);
            } else {
                List<Integer> lastInterval = res.get(res.size()-1);
                //if condition takes care of case when there is no overlap
                //max(interval.get(0),lastInterval.get(0)),min(interval.get(1),lastInterval.get(1))
                lastInterval.set(1,Math.max(lastInterval.get(1),interval.get(1)));
            }
        }
        return res;
    }

    //[1, 3], [2, 6]
    //max(1,2),min(3,6)
    public static boolean overlap(List<Integer> l1,List<Integer> l2) {
        return Math.max(l1.get(0),l2.get(0)) <= Math.min(l1.get(1),l2.get(1));
    }
}
