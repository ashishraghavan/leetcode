package com.algomonster.problems.twopointers_or_sliding_window;

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
        System.out.println(longestSubstringWithoutRepeatingCharactersIII("longestsubstringwithoutrepeatingcharacters"));
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

    //dvdf -> vdf, i=0,j in [0,s.length-1]
    //boolean added = set.add(s.charAt(j)). if !added - while(i<j && s.charat(i)!=s.charat(j))set.remove(s.charat(i)), mx=max(mx,j-i+1)
    //bbbbb
    //tmmzuxt
    public static int longestSubstringWithoutRepeatingCharactersIII(String s) {
        if(s.isEmpty())return 0;
        Set<Character> st = new HashSet<>();
        int i=0,mx=Integer.MIN_VALUE;
        for(int j=0;j<s.length();j++) {
            if(!st.add(s.charAt(j))) {
                for(;i < j;i++) {
                    char ch = s.charAt(i);
                    st.remove(ch);
                    if(ch == s.charAt(j)){i++;break;}
                }
                st.add(s.charAt(j));
            }
            mx = Math.max(mx,st.size());
        }
        return mx;
    }
}
