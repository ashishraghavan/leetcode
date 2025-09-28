package com.leetcode.easy;

//prob # 1550 - 3 consecutive odds
public class ThreeConsecutiveOdds_L1550 {
    public static void main(String[] args) {
        //1,2,34,3,4,5,7,23,12
        //2,6,4,1
        System.out.println(threeConsecutiveOdds(new int[]{1,2,34,3,4,5,7,23,12}));
    }

    //1,2,34,3,4,5,7,23,12
    public static boolean threeConsecutiveOdds(int[] arr) {
        for(int i=1;i<=arr.length-2;i++) {
            if(arr[i] % 2 == 0)continue;
            if(arr[i-1] % 2 != 0 && arr[i+1] % 2 != 0)return true;
        }
        return false;
    }
}
