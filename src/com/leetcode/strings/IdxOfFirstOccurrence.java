package com.leetcode.strings;

public class IdxOfFirstOccurrence {
    public static void main(String[] args) {
        //sadbutsad sabdsmoothsaddobs sasadbusaddtt
        System.out.println(strStr("sabdsmoothsaddobs","sad"));
    }

    public static int strStr(String haystack, String needle) {
        int idx = Integer.MAX_VALUE;
        for(int i=0;i<haystack.length();i++) {
            int j=i;
            int k = 0;
            for(;k<needle.length();k++) {
                if(j < haystack.length() && haystack.charAt(j) != needle.charAt(k)) {
                    i=j;
                    break;
                } else {
                    j++;
                }
            }
            if(k>=needle.length()) {
                System.out.println("needle found at index: "+i);
                idx = Math.min(idx,i);
                i=j;
            }
        }
        return idx;
    }
}
