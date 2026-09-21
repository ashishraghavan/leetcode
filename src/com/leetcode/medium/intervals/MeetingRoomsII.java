package com.leetcode.medium.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

//#253[premium]
//refer https://github.com/doocs/leetcode/blob/main/solution/0200-0299/0253.Meeting%20Rooms%20II/README_EN.md
//for question
//refer https://share.gemini.google/zQI91F5nBWmk for solution
public class MeetingRoomsII {
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
        int[][] input = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println(meetingRoomII(input));
    }

    //{1, 5}, {2, 8}, {3, 6}, {5, 10}, {8, 12}
    public static int meetingRoomII(int[][] m) {
        Arrays.sort(m,(m1,m2)->Integer.compare(m1[0],m2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] meeting : m) {
            if(!pq.isEmpty() && pq.peek() <= meeting[0]) {
                pq.poll();
            }
            pq.offer(meeting[1]);
        }
        return pq.size();
    }
}
