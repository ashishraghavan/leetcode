package com.leetcode.easy;

//O(n*m) solution
//problem # 28 - index of first occurrence
//TODO: understand rabin karp algorithm for string matching to reduce time complexity to O(n+m) &
// space complexity to O(1)
// check https://github.com/doocs/leetcode/tree/main/solution/0000-0099/0028.Find%20the%20Index%20of%20the%20First%20Occurrence%20in%20a%20String
// for github solution
public class IdxOfFirstOccurrence_L28 {
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
