package com.leetcode.easy;

//problem # 374 - guess number higher or lower
public class GuessNumberHigherOrLower_L374 {
    public static void main(String[] args) {
        //n = 10, pick = 6
        //n = 1, pick = 1
        //n = 2, pick = 1
        System.out.println(guessNumber(10));
    }

    //n = 10, pick = 6
    // pick is between 1 to n
    //mid = 1 + (n-1)/2
    public static int guessNumber(int n) {
        int low = 1,mid,res,high = n;
        while(low < high) {
            mid = low + (high-low)/2;
            res = guess(mid);
            if(res == 0)return mid;
            else if(res > 0) {
                //mid is less than pick
                low = mid+1;
            } else {
                //mid is greater than pick
                high = mid-1;
            }
        }
        return high;
    }

    static int guess(int num) {
        return Integer.compare(num,6);
//        if(num > 6)return -1;
//        else if(num < 6)return 1;
//        return 0;
    }
}
