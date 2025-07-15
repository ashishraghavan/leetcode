package com.leetcode.premium;

import java.util.Arrays;
import java.util.Comparator;

//premium prob. # 252 - meeting room [premium]
//check https://github.com/doocs/leetcode/blob/main/solution/0200-0299/0252.Meeting%20Rooms/README_EN.md for question/solution
public class MeetingRooms_L252 {
    public static void main(String[] args) {
        //{0,30},{5,10},{15,20}
        //{7,10},{2,4}
        //{7,10},{2,4},{4,5},{9,12},{6,8},{0,4}
        //{7,10},{2,4},{4,7},{17,21},{12,15},{0,1}
        System.out.println(canAttendAllMeetings(new int[][]{{7,10},{2,4},{4,7},{17,21},{12,15},{0,1}}));
    }

    static Comparator<int[]> arrComp = Comparator.comparingInt(a -> a[0]);

    //if ivl.isEmpty return true
    //sort based on start time
    //for each pair (xi,yi) if
    //[2,4][7,10]
    public static boolean canAttendAllMeetings(int[][] ivl) {
        if(ivl.length <= 1)return true;
        Arrays.sort(ivl, arrComp);
        for(int i=1;i<ivl.length;i++) {
            if(ivl[i][0] < ivl[i-1][1])return false;
        }
        return true;
    }


}
