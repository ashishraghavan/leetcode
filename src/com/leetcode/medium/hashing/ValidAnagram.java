package com.leetcode.medium.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//#242
//check https://share.gemini.google/ZcyD7wOqZA4v
public class ValidAnagram {
    public static void main(String[] args) {
        //anagram, nagaram
        //rat, car
        //a,ab
        //aab,abb
        //ac,bb
        System.out.println(isAnagramIII("anagram","nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        Map<Character,Integer> sm = new HashMap<>();
        Map<Character,Integer> tm = new HashMap<>();
        for(int i=0,j=0;i<s.length();i++,j++) {
            sm.put(s.charAt(i),sm.getOrDefault(s.charAt(i),0)+1);
            tm.put(t.charAt(j),tm.getOrDefault(t.charAt(j),0)+1);
        }
        return sm.equals(tm);
    }

    public static boolean isAnagramII(String s, String t) {
        if(s.length() != t.length())return false;
        int[] zeroArr = new int[26];
        int[] sfreq = new int[26];
        for(int i=0;i<s.length();i++) {
            sfreq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++) {
            sfreq[t.charAt(i)-'a']--;
        }
        return Arrays.equals(zeroArr,sfreq);
    }

    public static boolean isAnagramIII(String s, String t) {
        if(s.length() != t.length())return false;
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++) {
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int val : freq) {
            if(val != 0)return false;
        }
        return true;
    }
}
