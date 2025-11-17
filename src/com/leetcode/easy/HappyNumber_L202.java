package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

//TODO: [revise], loosely based on concept of floyd warshall's cycle detection algorithm!!
// Refer https://copilot.microsoft.com/shares/CMALMQLrDWbrNbJntpFr8 for intuitive solution
//problem #202 - happy number
public class HappyNumber_L202 {
    public static void main(String[] args) {
        System.out.println(isHappy(12));
    }

    //19 - 1+81=82
    //82 - 64+4=68 = |6-8|=2
    //68 - 36+64 = |1-0-0|=1

    //25 - 4+25=29 = |2-9|=7
    //29 - 4+36=38 = |3-8|=5
    //38 - 9+64=73 = |7-3|=4
    //73 - 49+9=58 = |5-8|=3
    //58 - 25+64=89= |8-9|=1
    //89 - 64+81=145=|5-4-1|=0
    //145 - 1+16+25=42=|4-2|=2
    //42 - 20 = |2-0|=2
    //20 - 40 = |4-0|=4
    //40 - 16 = |1-6|=5
    //16 - 37 = |3-7|=4
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum;
        while(n != 1) {
            sum = 0;
            while(n >= 1) {
                sum += (int)(Math.pow(n%10,2));
                n=n/10;
            }
            if(set.contains(sum))return false;
            set.add(sum);
            n=sum;
        }
        return true;
    }
}
