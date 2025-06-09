package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//problem # 66 - plus one
public class PlusOne_L66 {
    public static void main(String[] args) {
        //9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9
        //1,9,9,9
        //3,9,8,9
        System.out.println(Arrays.toString(plusOne(new int[]{4,9,9,9})));
    }

    //max value of digits[i] + 1 = 10 coz 0<=digits[i]<=9
    //9,9,9 -> 1,0,0,0
    //9,9,9 + 0,0,1 -> 0,0,0,1 -reverse-> 1,0,0,0
    //8,0,9 + 0,0,1 -> 0,1,8 -reverse-> 8,1,0
    //inefficient solution
    public static int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int sum, carry = 0;
        for(int i=digits.length-1;i>=0;i--) {
            sum = (i == digits.length-1) ? digits[i] + 1 : digits[i] + carry;
            if(sum > 9) {
                carry = sum/ 10;
                res.add(sum%10);
            } else {
                carry = 0;
                res.add(sum);
            }
        }
        if(carry > 0) {
            res.add(carry);
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
