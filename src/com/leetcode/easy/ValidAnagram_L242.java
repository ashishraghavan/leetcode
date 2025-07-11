package com.leetcode.easy;

import java.util.Arrays;

//prob. # 242 - valid anagram
public class ValidAnagram_L242 {
    public static void main(String[] args) {
        //s = "anagram", t = "nagaram"
//        listen/silent
//        evil/vile
//        dusty/study
//        earth/heart
//        race/care
        System.out.println(isAnagram("anagram","nagaram"));
    }

    //freq of chars in t == freq of chars in t ? return true
    //int[26] freq to hold frequency of chars as only lowercase english letters
    //iterate s, store frequency in freq[]
    //iterate t, decrease freq[] as you encounter chars in t
    //iterate s, check if freq of each char in s is 0 in freq.
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for(int j=0;j<t.length();j++) {
            //----commenting line # 30 improves run time----
            //if(freq[t.charAt(j) - 'a'] == 0)return false;
            freq[t.charAt(j) - 'a']--;
        }
        for(int i=0;i<s.length();i++) {
            if(freq[s.charAt(i) - 'a'] != 0)return false;
        }
        return true;
    }
}
