package com.leetcode.easy;

//prob # 796 - rotate string
public class RotateString_L796 {
    public static void main(String[] args) {
        //s = "abcde", goal = "cdeab"
        //s = "abcde", goal = "abced"
        //s = "dunkingkruger", goal = "rugerdunking"
        System.out.println(rotateString("dunkingkruger","rugerdunkingk"));
    }

    //abcde
    //cdeab
    //i in (0,s.length) idx = goal.indexOf(s.substring(i)), if idx >= 0 ? j = idx + s.substring(i).length, if goal.charAt(j++) == s.charAt(k++)

    //abcde
    //abced

    //dunkingkruger
    //rugerdunkingk
    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())return false;
        int idx = -1,i;
        for(i=0;i<s.length();i++) {
            idx = goal.indexOf(s.substring(i));
            if(idx >= 0)break;
        }
        if(idx == -1)return false;
        int reqLen = i;
        int j = idx + (s.length() - i),k=0;
        while(j < goal.length()) {
            if(s.charAt(k) != goal.charAt(j))return false;
            j++;
            k++;
        }
        return k == reqLen;
    }
}
