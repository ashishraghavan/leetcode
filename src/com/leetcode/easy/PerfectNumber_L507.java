package com.leetcode.easy;

//problem # 507 - perfect number
//check https://github.com/doocs/leetcode/tree/main/solution/0500-0599/0507.Perfect%20Number for github solution
public class PerfectNumber_L507 {
    public static void main(String[] args) {
        //6
        //7
        //28
        //496
        //500
        //8128
        //8179
        //33550336
        //33550379
        //100000000
        System.out.println(checkPerfectNumberII(28));
    }

    //inefficient solution
    //for i in 1 to 28/2 if num%i == 0 && res < num {res+=i}
    public static boolean checkPerfectNumber(int num) {
        int res = 0;
        for(int i=1;i<=num/2;i++) {
            if(res > num)return false;
            if(num%i == 0) {
                res+=i;
            }
        }
        return res==num;
    }

    //TODO: revise below github solution, is efficient! each iteration i reduces the TO range to num/i,
    // also check euclidean perfect number
    public static boolean checkPerfectNumberII(int num) {
        if (num == 1) {
            return false;
        }
        int s = 1;
        for (int i = 2; i <= num / i; ++i) {
            if (num % i == 0) {
                s += i;
                if (i != num / i) {
                    s += num / i;
                }
            }
        }
        return s == num;
    }
}
