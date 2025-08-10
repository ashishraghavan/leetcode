package com.leetcode.easy;

//prob # 1137 - Nth tribonacci number
public class NthTribonacciNumber_L1137 {
    public static void main(String[] args) {
        System.out.println(tribonacci(3));
    }

    //T0 = 0, T1 = 1, T2 = 1
    //T3 = T0 + T1 + T2 = 2
    //T4 = T1 + T2 + T3 = 4
    //T5 = T2 + T3 + T4 = 7
    public static int tribonacci(int n) {
        int t0 = 0,t1 = 1, t2 = 1,idx = 3,sum = 2;
        if(n < idx) return n == 0 ? 0 : 1;
        while(idx <= n) {
            sum = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = sum;
            idx++;
        }
        return sum;
    }
}
