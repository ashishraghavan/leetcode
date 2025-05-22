package com.leetcode.easy;

//TODO: pending
//O(n*m) solution
public class IdxOfFirstOccurrence {
    public static void main(String[] args) {
        //sadbutsad sabdsmoothsaddobs sasadbusaddtt
        //sasatdsatsdasasad, sad
        //sasatdsatsdasasab, sad
        //mississippi, issipi
        System.out.println(strStrII("mississippi","issipi"));
    }

    public static int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length();) {
            int j=i;
            int k = 0;
            for(;k<needle.length();k++) {
                if(j < haystack.length() && haystack.charAt(j) == needle.charAt(k)) {
                    j++;
                } else {
                    i=j;
                    break;
                }
            }
            if(k>=needle.length()) {
                System.out.println("needle found at index: "+i);
                return i;
            }
        }
        return -1;
    }

    //sasaddsatsdasasad, sad
    public static int strStrII(String haystack, String needle) {
        if(haystack.length() < needle.length())return -1;
        int k,j;
        for(int i=0;i<haystack.length();i++) {
            k=i;
            for(j=0;j<needle.length();j++) {
                if(k >=haystack.length() || needle.charAt(j) != haystack.charAt(k++)) {
                    break;
                }
            }
            if(j>=needle.length()) {
                return k-needle.length();
            }
        }
        return -1;
    }
}
