package com.leetcode.medium.intervals;

import java.util.Arrays;

//#234 [premium]
//see https://github.com/doocs/leetcode/blob/main/solution/0200-0299/0252.Meeting%20Rooms/README_EN.md
//for question
public class MeetingRooms {
    public static void main(String[] args) {
        //{0,30},{5,10},{15,20}
        //[7,10],[2,4] -> [2,4],[7,10]
        //new int[][]{{1, 5}, {1, 5}}
        //new int[][]{{5, 8}, {1, 4}, {9, 12}, {13, 16}}
        //new int[][]{{1, 5}, {1, 2}}
        //new int[][]{{0, 0}, {0, 0}}
        //new int[][]{{1, 4}, {4, 7}, {7, 9}}
        int[][] input = new int[][]{{1, 4}, {4, 7}, {7, 9}};
        System.out.println(canAttend(input));
    }

    //A.length >= 2
    public static boolean canAttend(int[][] A) {
        //sort by start time
        Arrays.sort(A,(a1,a2)->Integer.compare(a1[0],a2[0]));
        for(int i=0;i<A.length-1;i++) {
            if(A[i+1][0] < A[i][1])return false;
        }
        return true;
    }
}
