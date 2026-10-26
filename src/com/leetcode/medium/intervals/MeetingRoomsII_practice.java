package com.leetcode.medium.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//#253
public class MeetingRoomsII_practice {
    public static void main(String[] args) {
        //new int[][]{{1, 5}, {5, 10}, {2, 8}, {8, 12}, {3, 6}}
        //new int[][]{{0, 1000000}, {500000, 1000000}, {250000, 750000}, {100000, 900000}}
        //new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}}
        //new int[][]{{1, 10}, {2, 4}, {5, 9}}
        //new int[][]{{1, 10}, {2, 7}, {3, 5}}
        //new int[][]{{2, 6}, {2, 6}, {2, 6}}
        //new int[][]{{5, 10}}
        //new int[][]{{1, 4}, {4, 7}, {7, 10}}
        //new int[][]{{7, 10}, {2, 4}}
        //new int[][]{{0, 30}, {5, 10}, {15, 20}}
        int[][] input = new int[][]{{7, 10}, {2, 4}};
        System.out.println(meetingRoomII(input));
    }

    public static int meetingRoomII(int[][] m) {
        Arrays.sort(m, Comparator.comparingInt(m2 -> m2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] ints : m) {
            if (pq.isEmpty()) {
                pq.offer(ints[1]);
                continue;
            }
            int lastMeetEndTime = pq.peek();
            if (ints[0] >= lastMeetEndTime) {
                pq.remove();
            }
            pq.offer(ints[1]);
        }
        return pq.isEmpty() ? 1 : pq.size();
    }
}
