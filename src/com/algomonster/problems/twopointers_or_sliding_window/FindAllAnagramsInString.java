package com.algomonster.problems.twopointers_or_sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TODO: definitely [revise], good problem on sliding window
public class FindAllAnagramsInString {
    public static void main(String[] args) {
        //cbaebabacd, abc
        //abab, ab
        //"abcabcabc", "abc"
        //act, cact
        System.out.println(findAllAnagramsII("act","cact"));
    }

    //cbaebabacd, abc
    //int[] chArr = new [26]
    //int[]
    public static List<Integer> findAllAnagrams(String original, String check) {
        int[] chArrCtr = new int[26];
        int[] ogArrCtr = new int[26];
        List<Integer> res = new ArrayList<>();
        int chLen = check.length();
        int ogLen = original.length();
        //populate chkArrCtr & window size in ogArrCtr
        for(int i=0;i<chLen;i++) {
            chArrCtr[check.charAt(i) - 'a']++;
            ogArrCtr[original.charAt(i) - 'a']++;
        }
//        System.out.println(Arrays.toString(chArrCtr));
//        System.out.println(Arrays.toString(ogArrCtr));
        if(Arrays.equals(chArrCtr,ogArrCtr))res.add(0);
        for(int j = chLen; j < ogLen; j++) {
            ogArrCtr[original.charAt(j - chLen) - 'a']--;
            ogArrCtr[original.charAt(j) - 'a']++;
            if(Arrays.equals(ogArrCtr,chArrCtr)) res.add(j - chLen + 1);
        }
        return res;
    }

    public static List<Integer> findAllAnagramsII(String original, String check) {
        if(check.length() > original.length())return List.of();
        int[] chArrCtr = new int[26];
        int[] ogArrCtr = new int[26];
        int chLen = check.length();
        int ogLen = original.length();
        List<Integer> res = new ArrayList<>();
        //populate chArrCtr & windowSize in ogArrCtr
        for(int i=0;i<chLen;i++) {
            chArrCtr[check.charAt(i) - 'a']++;
            ogArrCtr[original.charAt(i) - 'a']++;
        }
        if(Arrays.equals(chArrCtr,ogArrCtr))res.add(0);
        for(int j=chLen; j < ogLen; j++) {
            ogArrCtr[original.charAt(j - chLen) - 'a']--;
            ogArrCtr[original.charAt(j) - 'a']++;
            if(Arrays.equals(ogArrCtr,chArrCtr))res.add(j - chLen + 1);
        }
        return res;
    }
}
