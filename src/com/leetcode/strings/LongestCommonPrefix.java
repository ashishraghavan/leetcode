package com.leetcode.strings;

//Q. 14 Longest common prefix
public class LongestCommonPrefix {
    public static void main(String[] args) {
        //flower,flow,flight
        //"flower","flow","flour"
        //"cir","car"
        //"a"
        //"a","b"
        System.out.println(longestCommonPrefix(new String[]{"a","b"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        if(strs.length==1 && strs[0].length() == 1) {
            return String.valueOf(strs[0].charAt(0));
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs[0].length();i++) {
            boolean isMatch = false;
            char ch = strs[0].charAt(i);
            for (int j=1;j<strs.length;j++) {
                if (strs[j].isEmpty() || i > strs[j].length()-1) {
                    isMatch=false;
                    break;
                } else if (strs[j].charAt(i) != ch) {
                    isMatch=false;
                    break;
                } else {
                    isMatch=true;
                }
            }
            if(!isMatch) {
                break;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
