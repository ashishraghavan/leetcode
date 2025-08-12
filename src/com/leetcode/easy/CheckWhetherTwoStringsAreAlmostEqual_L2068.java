package com.leetcode.easy;

//prob # 2068 - check whether two strings are almost equal
public class CheckWhetherTwoStringsAreAlmostEqual_L2068 {
    public static void main(String[] args) {
        //word1 = "aaaa", word2 = "bccb"
        //word1 = "abcdeef", word2 = "abaaacc"
        //word1 = "cccddabba", word2 = "babababab"
        System.out.println(checkAlmostEquivalent("aaaa","bccb"));
    }

    //word1 = "abcdeef", word2 = "abaaacc"
    //w1Arr = {a:1,b:1,c:1,d:1,e:2,f:1}
    //w2Arr = {a:4,b:1,c:2,d:0,e:0,f:0}
    //two arrays of maximum size = 26
    //a=97,z=122
    //w1Arr = [0, 2, 2, 0, 0, 0, 0...]
    //w2Arr = [4, 0, 0, 0, 0, 0, 0...]
    public static boolean checkAlmostEquivalent(String word1, String word2) {
        int[] w1Arr = new int[26];
        int[] w2Arr = new int[26];
        for(int i=0;i<word1.length();i++) {
            w1Arr[word1.charAt(i) - 'a']++;
            w2Arr[word2.charAt(i) - 'a']++;
        }
        for(int i=0;i<w1Arr.length;i++) {
            if(Math.abs(w1Arr[i]-w2Arr[i]) > 3)return false;
        }
        return true;
    }
}
