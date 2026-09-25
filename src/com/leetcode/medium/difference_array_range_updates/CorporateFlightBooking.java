package com.leetcode.medium.difference_array_range_updates;

import java.util.Arrays;

//#1109 - very similar to RangeAddition.java
public class CorporateFlightBooking {
    public static void main(String[] args) {
        //{{1, 1, 5}} | 1
        //{{1, 5, 50}}; | 5
        //{{1, 1, 100}, {5, 5, 200}}; | 5
        //{{1, 5, 10}, {2, 4, 20}, {3, 3, 30}}; | 5
        //{{1, 2, 10}, {2, 3, 20}, {3, 4, 30}, {4, 5, 40}}; | 5
        //{{2, 4, 15}, {2, 4, 25}, {2, 4, 10}}; | 5
        //{{1, 2, 100}, {5, 6, 200}}; | 6
        //{
        //    {1, 4, 10000},
        //    {2, 3, 10000},
        //    {1, 2, 10000},
        //    {3, 4, 10000}
        //}; | 4
        int[][] bookings = {
                {1, 4, 10000},
                {2, 3, 10000},
                {1, 2, 10000},
                {3, 4, 10000}
        };
        int n = 4;
        System.out.println(Arrays.toString(corpFlightBookings(bookings,n)));
    }

    //int[][] bookings = new int[][]{{1,2,10},{2,3,20},{2,5,25}};
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for(int[] booking : bookings) {
            int first = booking[0]-1;
            int last = booking[1]-1;
            int seats = booking[2];

            res[first] += seats;
            if(last+1 < n) {
                res[last+1] -= seats;
            }
        }
        for(int i=1;i<res.length;i++) {
            res[i] += res[i-1];
        }
        //System.out.println(Arrays.toString(res));
        return res;
    }
}
