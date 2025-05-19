package com.leetcode.easy;

//https://www.mathwarehouse.com/arithmetic/numbers/list-of-perfect-squares.php
//TODO: revise
//check https://github.com/doocs/leetcode/tree/main/solution/0300-0399/0367.Valid%20Perfect%20Square for github solution
public class ValidPerfectSquare_L367 {
    public static void main(String[] args) {
        //51529	   227 * 227
        //73441	   271 * 271
        //528529	727 * 727
        //978121 - 989 * 989
        //744769	863 * 863
        //717409	847 * 847
        System.out.println(isPerfectSquare(51529));
    }

    //github solution! USES BINARY SEARCH
    public static boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while(l < r) {
            int mid = (l+r) >>> 1;
            if(mid * mid >= num) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l*l==num;
    }
}
