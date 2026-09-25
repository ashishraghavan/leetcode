package com.leetcode.medium.difference_array_range_updates;

import java.util.Map;
import java.util.TreeMap;

//#1094
//refer https://share.gemini.google/rW7e6E1U0T6Y for solution
public class CarPooling {
    public static void main(String[] args) {
        //{2,1,5},{3,3,7} | 4
        //new int[][]{{4, 1, 2}, {2, 3, 5}, {1, 6, 8}}; | 1
        //new int[][]{{2, 6, 9}, {3, 1, 10}, {2, 2, 5}}; | 5
        //new int[][]{{4, 0, 3}, {3, 3, 6}, {1, 1, 4}}; | 5
        //new int[][]{{1, 0, 1}}; | 0
        //new int[][]{{2, 1, 4}, {2, 2, 5}, {2, 3, 6}}; | 5
        //new int[][]{{2, 1, 4}, {3, 1, 4}, {1, 1, 4}}; | 5
        //new int[][]{{5, 1, 4}}; | 4
        //new int[][]{{3, 2, 8}}; | 3
        //new int[][]{{2, 1, 5}, {3, 3, 7}}; | 5
        //new int[][]{{2, 1, 5}, {3, 5, 7}}; | 3
        //new int[][]{{2, 1, 5}, {3, 5, 7}}; | 3
        //new int[][]{{2, 1, 5}, {3, 3, 7}}; | 4
        int[][] trips = new int[][]{{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        System.out.println(carPoolingII(trips,capacity));
    }

    //{2,1,5},{3,3,7} | 4
    public static boolean carPooling(int[][] trips, int capacity) {
        // Map: location -> net change in passenger count
        Map<Integer, Integer> timeline = new TreeMap<>();

        for (int[] trip : trips) {
            int passengers = trip[0];
            int from = trip[1];
            int to = trip[2];

            timeline.put(from, timeline.getOrDefault(from, 0) + passengers);
            timeline.put(to, timeline.getOrDefault(to, 0) - passengers);
        }

        int currentPassengers = 0;
        for (int change : timeline.values()) {
            currentPassengers += change;
            if (currentPassengers > capacity) {
                return false;
            }
        }

        return true;
    }

    public static boolean carPoolingII(int[][] trips, int capacity) {
        Map<Integer,Integer> mp = new TreeMap<>();
        for(int[] trip : trips) {
            int passenger = trip[0];
            int start = trip[1];
            int end = trip[2];

            mp.put(start,mp.getOrDefault(start,0) + passenger);
            mp.put(end,mp.getOrDefault(end,0) - passenger);
        }
        int currentPassenger = 0;
        for(Integer passenger : mp.values()) {
            currentPassenger += passenger;
            if(currentPassenger > capacity) {
                return false;
            }
        }
        return true;
    }
}
