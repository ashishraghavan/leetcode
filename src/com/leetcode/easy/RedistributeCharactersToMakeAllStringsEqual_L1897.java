package com.leetcode.easy;

//prob # 1897 - redistribute characters to make all strings equal
public class RedistributeCharactersToMakeAllStringsEqual_L1897 {
    public static void main(String[] args) {
        //"abc","aabc","bc"
        //"ab","a"
        //"abc","def","ghi"
        //"geeksquiz","zuiqkeegs"
        //"act", "cat", "tact"
        System.out.println(makeEqual(new String[]{"act", "catt", "tact"}));
    }

    //"abc","aabc","bc"
    //1. how to find which string to be used as final string?
    // a=3,b=3,c=3 => if frequency of all characters used in all strings is same (except 1?), return true else false ?? incorrect
    //"abc","def","ghi"
    //
    public static boolean makeEqual(String[] words) {
        int[] chArr = new int[26];
        for(String str : words) {
            if(str.isEmpty())return false;
            for(int i=0;i<str.length();i++) {
                chArr[str.charAt(i) - 'a']++;
            }
        }
        for(int val : chArr) {
            if(val > 0) {
                if(val % words.length != 0)return false;
            }
        }
        return true;
    }
}
