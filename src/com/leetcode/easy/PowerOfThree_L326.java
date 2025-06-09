package com.leetcode.easy;

//problem #326 - power of three
public class PowerOfThree_L326 {
    public static void main(String[] args) {
        //1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907
        System.out.println(isPowerOfThree(-1));
    }

    //logb(x) = log(x) / log(b)
    //27 = 3^n, n = log27 base 3 = log 27 base e/log 3 base e
    public static boolean isPowerOfThree(int n) {
        if(n <= 0)return false;
        double res = Math.round((Math.log(n)/Math.log(3)));
        //System.out.println("res= "+res);
        //System.out.println(Math.pow(3,res));
        return Math.pow(3,res) == n;
    }
}
