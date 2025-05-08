package com.leetcode.easy;

import java.util.stream.Collectors;

//problem # 263 - ugly number
//TODO: review
//check https://github.com/doocs/leetcode/tree/main/solution/0200-0299/0263.Ugly%20Number
//for github implementation
public class UglyNumber_L263 {
    public static void main(String[] args) {
        //6 - 3 * 2
        //1
        //14 - 7 * 2
        //35 - 5 * 7
        //63 - 7 * 9
        //121 - 11 * 11
        System.out.println(isUgly(14));
    }

    //-2147483648 <= n <= 2147483647
    //only prime factors of n should be 2 || 3 || 5
    //63 - 7 * 9 = 7 * 3 * 3 -> 63%2 != 0 : start from 63/2 - 1=29,
    public static boolean isUgly(int n) {
        //Integer num = 2^31;
        //check divisibility by 2,3 and 5 -> if none return false
        //n%2 != 0 && (sum of digits of n)%3 != 0 && (last digit of n is 0 || last digit of n is 5)
        //String num = String.valueOf(n);
        //boolean isEven = n % 2 == 0;
        //int sumNum = num.chars().mapToObj(intCh->(char)intCh).map(ch->Character.digit(ch,10))

        //if(n < 1) return false;
        // if n % (2 || 3 || 4 || 5) != 0 return false
        // while(n%2 == 0) {
        //     n = n/2;
        // }
        // while(n%3 == 0) {
        //  n = n/3;
        // }
        // while(n%5 == 0) {
        //  n = n/5;
        // }
        //return n==1
        return false;
    }
}
