package com.leetcode.easy;

import java.util.Set;

//prob # 1903 - largest odd number in string
public class LargestOddNumberInString_L1903 {
    public static void main(String[] args) {
        //35427
        //52
        //4206
        //693051242680
        //692040242680
        System.out.println(largestOddNumber("4206"));
    }

    //i = num.length()-1, while i >= 0 ? if Character.digit(num.charAt(i),10)%2 != 0 return num.substring(0,i+1)
    //693051242680
    //692040242680
    public static String largestOddNumber(String num) {
        int i= num.length()-1,digit;
        while(i >= 0) {
            digit = Character.digit(num.charAt(i),10);
            if(digit % 2 != 0)return num.substring(0,i+1);
            i--;
        }
        return "";
    }

    //
    public static String largestOddNumberII(String num) {
        Set<Character> oddSet = Set.of('1','3','5','7','9');
        for(int i=num.length()-1;i>=0;i--) {
            if(oddSet.contains(num.charAt(i))) {
                return num.substring(0,i+1);
            }
        }
        return "";
    }
}
