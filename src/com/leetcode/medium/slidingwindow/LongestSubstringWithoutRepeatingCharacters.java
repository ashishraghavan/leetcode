package com.leetcode.medium.slidingwindow;

import java.util.HashSet;
import java.util.Set;

//#3
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //abcabcbb
        //bbbbb
        //pwwkew
        //abcdef
        //tmmzuxt
        //abba
        //dvdf
        //baa
        //!@#123 %^&*
        //
        System.out.println(lengthOfLongestSubstringUpdated("!@#123 %^&*"));
    }

    //tmmzuxt
    //#1. update condition to make it readable && l will always be less than r ->
    //while(st.contains(s.charAt(r))){
    //  st.remove(s.charAt(l));
    //  l++;
    //}
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())return 0;
        Set<Character> st = new HashSet<>();
        int l=0,r=0,max=Integer.MIN_VALUE;
        for(;r<s.length();r++) {
            while(!st.add(s.charAt(r)) && l < r) {
                st.remove(s.charAt(l));
                l++;
            }
            max = Math.max(max,r-l+1);
        }
        return max;
    }

    public static int lengthOfLongestSubstringUpdated(String s) {
        if(s.isEmpty())return 0;
        Set<Character> st = new HashSet<>();
        int l=0,r=0,max=Integer.MIN_VALUE;
        for(;r<s.length();r++) {
            while(st.contains(s.charAt(r))) {
                st.remove(s.charAt(l));
                l++;
            }
            st.add(s.charAt(r));
            max = Math.max(max,r-l+1);
        }
        return max;
    }
}
