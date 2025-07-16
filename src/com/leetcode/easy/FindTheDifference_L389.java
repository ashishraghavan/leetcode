package com.leetcode.easy;

import java.util.Arrays;

//TODO: pending optimized solution
//prob. # 389 - find the difference
public class FindTheDifference_L389 {
    public static void main(String[] args) {
        //abcd, abcde
        //"", "y"
        System.out.println(findTheDifference("","y"));
    }

    //int[26]
    public static char findTheDifference(String s, String t) {
        int[] intCh = new int[26];
        int ans = 0;
        Arrays.fill(intCh,0);
        for(int i=0;i<s.length();i++) {
            intCh[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++) {
            intCh[t.charAt(i)-'a']--;
        }
        for(int i=0;i<intCh.length;i++) {
            if(intCh[i] < 0) {
                ans = i+97;
                break;
            }
        }
        return (char)ans;
    }
}
