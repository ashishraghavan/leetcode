package com.leetcode.medium.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//#49
public class GroupAnagrams {
    public static void main(String[] args) {
        //"eat","tea","tan","ate","nat","bat"
        //"a", "aa", "aaa"
        //"abc", "abc", "abc"
        //"a", "b", "c", "d"
        System.out.println(groupAnagrams(new String[]{"a", "b", "c", "d"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(String str : strs) {
            String freqArr = strFreq(str);
            mp.computeIfAbsent(freqArr,k -> new ArrayList<>()).add(str);
//            if(mp.containsKey(freqArr)) {
//                mp.get(freqArr).add(str);
//            } else {
//                List<String> subList = new ArrayList<>();
//                subList.add(str);
//                mp.put(freqArr,subList);
//            }
        }
        return new ArrayList<>(mp.values());
    }


    public static String strFreq(String str) {
        char[] freq = new char[26];
        for(int i=0;i<str.length();i++) {
            freq[str.charAt(i) - 'a']++;
        }
        return new String(freq);
    }

    //use char[26] instead of int[26] if you know the maximum frequency each index will hold.
    //Each char can hold maximum of 16 bits, whereas each int can hold maximum of 32 bits
    public static String strFreqII(String str) {
        char[] freq = new char[26];
        int[] freq2 = new int[26];
        for(int i=0;i<str.length();i++) {
            freq[str.charAt(i)-'a']++;
            freq2[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<freq2.length;i++) {
            sb.append(freq2[i]).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        String result = new String(freq);
        System.out.println("appending comma to int array = "+sb);
        System.out.println("instance of str using char array = "+result);
//        return sb.toString();
        return result;
    }
}
