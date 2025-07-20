package com.leetcode.easy;

import java.util.Arrays;

//TODO: pending optimized solution
//prob# 1446 - consecutive characters
public class ConsecutiveCharacters_L1446 {
    public static void main(String[] args) {
        //abbcccddddeeeeedcba
        //leetcode
        //abcde
        //aa
        //a
        System.out.println(maxPowerII("aba"));
    }

    //INCORRECT LOGIC!
    //abccde
    //max length of substring consisting of same character
    //intCh = int[26], intCh[s[0]-'a']++, maxP = 1, currP = 1
    //i in (1,s.len-1), if s[i]==s[i-1], intCh[s[i-1]-'a']++ else intCh[s[i]-'a']++
    public static int maxPower(String s) {
        int[] intCh = new int[26];
        intCh[s.charAt(0)-'a']++;
        int maxP=1;
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                intCh[s.charAt(i-1)-'a']++;
            } else {
                intCh[s.charAt(i)-'a']++;
            }
        }
        System.out.println(Arrays.toString(intCh));
        return -1;
    }

    //i=0,cnt=1,pow=cnt  i+1 < s.len-1
    //s[i]==s[i-1]cnt++ else pow = max(cnt,pow),cnt=1
    public static int maxPowerII(String s) {
        if(s.length()==1)return 1;
        int i=1,cnt=1,pow=cnt;
        while(i < s.length()) {
            if(s.charAt(i) == s.charAt(i-1)) {
                cnt++;
            } else {
                pow = Math.max(cnt,pow);
                cnt=1;
            }
            i++;
        }
        return Math.max(cnt,pow);
    }

    //sliding window
    //maxLen = MIN_VALUE, currLen=1
    //i=0,j=0, j < s.length-1 && s[j]==s[j-1] currLen++; else i=j,j=j+1

//    int i=0,j=0,maxLen = Integer.MIN_VALUE,currLen=1;
//        while(true) {
//        while(j < s.length()-1 && s.charAt(j)==s.charAt(j-1)) {
//            currLen++;
//        }
//        if(currLen >= maxLen) {
//            maxLen = currLen;
//        }
//        currLen=1
//    }
}
