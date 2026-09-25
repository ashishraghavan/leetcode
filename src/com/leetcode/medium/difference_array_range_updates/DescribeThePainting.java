package com.leetcode.medium.difference_array_range_updates;

import java.util.*;

//#1943
public class DescribeThePainting {
    public static void main(String[] args) {
        //{{1,4,5},{4,7,7},{1,7,9}}
        //{{1,7,9},{6,8,15},{8,10,7}}
        //{{1, 10, 2}, {3, 7, 4}};
        //{{1, 5, 2}, {1, 5, 3}, {5, 8, 3}, {5, 12, 10}};
        //{{1, 4, 3}, {7, 10, 5}};
        //{{1, 4, 2}, {4, 7, 5}};
        //{{2, 6, 4}, {2, 6, 5}};
        //{{1, 10, 2}, {3, 7, 4}};
        //{{1, 7, 5}, {4, 10, 7}};
        //{{1, 4, 5}, {4, 7, 2}, {4, 7, 3}};
        //{{1, 5, 2}, {1, 5, 3}, {5, 8, 3}, {5, 12, 10}};
        //{{1, 3, 1}, {2, 4, 2}, {3, 5, 3}};
        //{{1, 5, 1000000000}, {3, 7, 1000000000}};
        int[][] input = {{1, 5, 1000000000}, {3, 7, 1000000000}};
        System.out.println(splitPaintingII(input));
    }

    //{{1,7,9},{6,8,15},{8,10,7}}
    //(1,6)=9, (6,7)=9, (6,7)=15, (7,8)=15, (8,10)=7
    //(1,6)=9, (6,7)=24, (7,8)=15, (8,10)=7
    //

    public static List<List<Long>> splitPainting(int[][] segments) {
// diff map to store change in color values at endpoints
        // Using TreeMap keeps the endpoints sorted automatically
        TreeMap<Integer, Long> diff = new TreeMap<>();

        for (int[] seg : segments) {
            int start = seg[0];
            int end = seg[1];
            int color = seg[2];

            diff.put(start, diff.getOrDefault(start, 0L) + color);
            diff.put(end, diff.getOrDefault(end, 0L) - color);
        }

        List<List<Long>> result = new ArrayList<>();
        long currentSum = 0;
        Integer prev = null;

        for (var entry : diff.entrySet()) {
            int point = entry.getKey();
            long change = entry.getValue();

            // If there's an active interval with a non-zero sum, record it
            if (prev != null && currentSum > 0) {
                result.add(Arrays.asList((long) prev, (long) point, currentSum));
            }

            currentSum += change;
            prev = point;
        }

        return result;
    }

    //{{1,7,9},{6,8,15},{8,10,7}}
    //(1,6)=9, (6,7)=9, (6,7)=15, (7,8)=15, (8,10)=7
    //(1,6)=9, (6,7)=24, (7,8)=15, (8,10)=7
    //{{1,6,9},{6,7,24},{7,8,15},{8,10,7}}

    //{1, 5, 2}, {1, 5, 3}, {5, 8, 3}, {5, 12, 10}
    //(1,5)=5, (5,8)=13, (8,12)=10
    //{1,5,5},{5,8,13},{8,12,10}
    public static List<List<Long>> splitPaintingII(int[][] segments) {
        Map<Integer,Long> mp = new TreeMap<>();
        for(int[] segment : segments) {
            int start = segment[0];
            int end = segment[1];
            int color = segment[2];

            mp.put(start,mp.getOrDefault(start,0L) + color);
            mp.put(end,mp.getOrDefault(end, 0L) - color);
        }
        Integer prev = null;
        long currentSum = 0;
        List<List<Long>> result = new ArrayList<>();
        for(var entry : mp.entrySet()) {
            int start = entry.getKey();
            long color = entry.getValue();

            if(prev != null && currentSum > 0) {
                result.add(Arrays.asList((long)prev,(long)start,currentSum));
            }
            currentSum += color;
            prev = start;
        }
        //System.out.println(mp);
        //return Collections.emptyList();
        return result;
    }
}
