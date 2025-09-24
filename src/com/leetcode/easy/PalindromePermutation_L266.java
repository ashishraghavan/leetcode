package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation_L266 {
    public static void main(String[] args) {
        //carerac
        //code
        //aab
        //abcdcba
        //abcdddcba
        //abdaddadba
        //tacocat
        //wasitacatisaw
        //yobananaboy
        //ahsatanseesnatasha
        //amanaplanacanalpanama
        //atoyota
        //dennisandednasinned
        System.out.println(isPalindromePermutation("tacocati"));
    }

    //carerac, r=2,a=2,c=2,e=1
    //abdaddadba, a=4,b=2,d=4
    //is palin. if
    // a) all characters are same
    // b) freq of all characters is an even number except one - whose freq can be odd or even
    // c) freq of all characters is an even number
    //if s.length = n, n-1 characters should have even freq & 1 character of any freq OR n characters with even freq
    public static boolean isPalindromePermutation(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            freq.merge(s.charAt(i),1,(Integer::sum));
        }
        if(freq.size() == 1)return true;
        System.out.println(freq);
        int oddFqCnt = 0,evenFqCnt = 0;
        for(Character ch : freq.keySet()) {
            if(freq.get(ch) % 2 != 0) {
                oddFqCnt++;
            } else {
                evenFqCnt++;
            }
        }
        return oddFqCnt <= 1 && evenFqCnt >= freq.size()-1;
    }
}
