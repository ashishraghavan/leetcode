package com.leetcode.easy;

import java.util.Arrays;

//TODO: [revise] can do better with execution time
//prob # 1502 - can make arithmetic progression
public class CanMakeArithmeticProgression_L1502 {
    public static void main(String[] args) {
        //[10, 7, 4, 1, -2]
        //4,-2,10,1,7 -> -2,1,4,7,10
        //-1,-6,-2,9,-8,-8,10,6,-4
        //3,5,1
        //10,4,-2,-8,-14
        //-1, -4, -7, -10, -13
        System.out.println(canMakeArithmeticProgression(new int[]{10,4,-2,-8,-14}));
    }

    //-1,-6,-2,9,-8,-8,10,6,-4 -sort-> -8,-8,-6,-4,-2,-1,6,9,10
    //10,2,8,4,6 -sort-> 2,4,6,8,10
    //formula for calculating arithmetic progression, (a,b) -> a = b + 2d
    //sort, find common difference by doing d = arr[1]-arr[0], start i=2 if arr[i]-arr[i-1] != d return false
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1]-arr[0];
        for(int i=2;i<arr.length;i++) {
            if(arr[i]-arr[i-1] != d)return false;
        }
        return true;
    }
}
