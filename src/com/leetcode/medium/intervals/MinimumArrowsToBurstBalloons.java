package com.leetcode.medium.intervals;

import java.util.Arrays;

//#452
//refer https://share.gemini.google/lMyxk9Br8RLg for solution
public class MinimumArrowsToBurstBalloons {
    public static void main(String[] args) {
        //{{10,16},{2,8},{1,6},{7,12}}
        //new int[][]{{1, 10}, {2, 3}, {4, 5}, {6, 7}}
        //new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}}
        //new int[][]{{-10, -5}, {-6, -2}, {-3, 0}, {0, 4}}
        //new int[][]{{1, 5}, {1, 5}, {1, 5}}
        //new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}
        //new int[][]{{1, 10}, {2, 9}, {3, 8}, {4, 7}}
        //new int[][]{{5, 5}}
        //new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}
        //new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}
        //new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}
        int[][] input = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(input));
    }

    //{1,6},{2,8},{7,12},{10,16}
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(p1,p2)->Integer.compare(p1[1],p2[1]));
        int currArrPos = points[0][1], arrCnt = 1;
        for(int i=1;i<points.length;i++) {
            if(points[i][0] > currArrPos) {
                arrCnt++;
                currArrPos = points[i][1];
            }
        }
        return arrCnt;
    }
}
