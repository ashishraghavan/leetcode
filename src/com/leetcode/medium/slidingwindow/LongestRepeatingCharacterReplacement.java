package com.leetcode.medium.slidingwindow;

import java.util.HashMap;
import java.util.Map;

//#424
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        //ABAB,2
        //AABABBA,1
        //#2 AABBAAA, 0
        //#3 ABCDE, 5
        //#4 AAAA,2
        //#5 ABBBCCA,2
        //#6 ABCDEF,2
        //#7 ABABABAB,3
        //#8 A,1
        //#9 BAAA,1
        //#10 AABAABBA,2
        System.out.println(characterReplacement("AABAABBA",2));
    }

    //at any given time given left(l) & right(r) pointers, the max frequency of characters in (l,r) should not be more than k if
    //(l,r) is valid if no of distinct characters is <= k
    //for the string (l,r) to be valid
    //ABBBCCA,2
    public static int characterReplacement(String s, int k) {
        int l=0,r=0,max=Integer.MIN_VALUE,maxFreq=Integer.MIN_VALUE;
        int[] chFreq = new int[26];
        for(;r<s.length();r++) {
            chFreq[s.charAt(r)-'A']++;
            maxFreq = Math.max(maxFreq,chFreq[s.charAt(r)-'A']);
            while(!isValid(l,r,k,maxFreq)) {
                chFreq[s.charAt(l)-'A']--;
                l++;
            }
            max = Math.max(max,r-l+1);
        }
        return max;
    }

    //i.e. if s=ABBBCCA, k=2, l=0,r=2, string ABB is valid coz dist. chars <= k && freq is A=1,B=2, max(freq) <= k
    //string ABBB is valid coz A=1,B=3, remove A
    //string BBB is valid as B=3, dist. chars = 1
    //string BBBC is valid as B=3,C=1 -> replace C
    //string BBBCC is valid as B=3,C=2 -> replace C with B twice, len=5
    //string BBBCCA is invalid as B=3,C=2,A=1
    //string BBCCA is invalid as B=2,C=2,A=1

    //(r-l+1)-max_freq(l,r) <= k
    //ex. s=ABBBCCA, ABBB, l=0,r=3, 4-3=1 <= k
    //for given string, you want to remove the characters which are not part of max frequency
    public static boolean isValid(int l,int r,int k,int maxFreq) {
        return (r-l+1)-maxFreq <= k;
    }
}
