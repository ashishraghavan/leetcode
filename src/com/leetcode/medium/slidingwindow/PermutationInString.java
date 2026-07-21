package com.leetcode.medium.slidingwindow;

import java.util.Arrays;

//#567
public class PermutationInString {
    public static void main(String[] args) {
        //s1 = "ab", s2 = "eidbaooo"
        //s1 = "ab", s2 = "eidboaoo"
        //ab,eidbaooa
        //bab,eidbaooa
        //xyz,abcdef
        //abcdef,abc
        //abc,bca
        //xyz,abxyz
        //xyz,yzxab
        //aab,aaab
        //hello,ooolleoooleh
        //abc,ccccbbbbaaaa
        //a,a
        System.out.println(checkInclusionII("a","a"));
    }

    //******* incorrect!! if s1="ab", s2 must contain either the substring - "ab" or "ba" *******//
    public static boolean checkInclusion(String s1, String s2) {
        int[] ch = new int[26];
        for(int i=0;i<s1.length();i++) {
            ch[s1.charAt(i)-'a']++;
        }
        for(int j=0;j<s2.length();j++) {
            ch[s2.charAt(j)-'a']--;
        }
        for(int i=0;i<s1.length();i++) {
            int val = ch[s1.charAt(i)-'a'];
            if(val > 0)return false;
        }
        return true;
    }

    public static boolean checkInclusionII(String s1, String s2) {
        int[] ch1 = new int[26];
        int[] ch2 = new int[26];
        int len=s1.length();
        for(int i=0;i<len;i++) {
            ch1[s1.charAt(i)-'a']++;
        }
        int l=0,r=0;
        for(;r<s2.length();r++) {
            ch2[s2.charAt(r)-'a']++;
            if(r-l+1 == len) {
                if(Arrays.equals(ch1,ch2)) {
                    return true;
                } else {
                    ch2[s2.charAt(l)-'a']--;
                    l++;
                }
            }
        }
        return false;
    }
}
