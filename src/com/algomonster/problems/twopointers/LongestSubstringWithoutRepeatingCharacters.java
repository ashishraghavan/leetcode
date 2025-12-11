package com.algomonster.problems.twopointers;

import java.util.HashSet;
import java.util.Set;

//TODO: definitely [revise], solution with help from algomonster
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //abccabcabcc
        //aaaabaaa
        //"bbbbb"
        //"abcdef"
        //"tmmzuxt"
        //"dvdf"
        //"anviaj"
        //"abcdeafghij"
        //"abcdabcdeabcdabcde"
        //"longestsubstringwithoutrepeatingcharacters"
        //"abbaabbaabba"
        //"pwwkew"
        System.out.println(longestSubstringWithoutRepeatingCharactersII("pwwkew"));
    }

    //tmmzuxt
    //dvdf
    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        int l=0,maxLen = Integer.MIN_VALUE,len=0;
        Set<Character> set = new HashSet<>();
        for(int r=0;r<s.length();r++) {
            if(set.contains(s.charAt(r))) {
                len = r-l+1;
                for(;l<r;l++){
                    if(s.charAt(l) == s.charAt(r)) {
                        set.remove(s.charAt(l));
                        len--;
                        break;
                    }
                }
            }
            set.add(s.charAt(r));
            maxLen = Math.max(Math.max(maxLen,r-l+1),len);
        }
        return maxLen;
    }

    //tmmzuxt
    //dvdf
    public static int longestSubstringWithoutRepeatingCharactersII(String s) {
        if(s.isEmpty())return 0;
        int maxLen = Integer.MIN_VALUE,l=0;
        Set<Character> set = new HashSet<>();
        for(int r=0;r<s.length();r++) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}
