package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

//problem # 953 - verifying an alien dictionary
public class VerifyingAlienDictionary_L953 {
    public static void main(String[] args) {
        //"hello","leetcode"    hlabcdefgijkmnopqrstuvwxyz
        //"word","world","row"  worldabcefghijkmnpqstuvxyz
        //"kuvp","q"    ngxlkthsjuoqcpavbfdermiywz
        System.out.println(isAlienSortedII(new String[]{"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz"));
    }

    //ascii val updated within range 0:25
    //chArr = int[26], i in order order.charAt(i)-'a' 0=[w], chArr[order[0]-'a']
    //Map<Character,Integer> map -> w:0, o:1....
    //i in (0,words.length-1) compare words[i],words[i+1],
    //isSorted(String word1, String word2){while(i<word1.length && j < word2.length) if word1[i]==word2[j] i
    //NAIVE SOLUTION
    public static boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1)return true;
        Map<Character,Integer> freq = new HashMap<>();
        IntStream.rangeClosed(0,order.length()-1).forEach(i->freq.put(order.charAt(i),i));
        for(int i=0;i<words.length-1;i++) {
            if(!isSorted(words[i],words[i+1],freq))return false;
        }
        return true;
    }

    //"kuvp","q"    ngxlkthsjuoqcpavbfdermiywz
    //NAIVE SOLUTION
    public static boolean isSorted(String word1,String word2,Map<Character,Integer> freq) {
        int len = Integer.min(word1.length(),word2.length());
        int i=0;
        while(i < len) {
            if(word1.charAt(i) == word2.charAt(i)) {
                i++;
                continue;
            }
            //check order of first different character
            return freq.get(word1.charAt(i)) < freq.get(word2.charAt(i));
        }
        return i >= word1.length();
    }

    //OPTIMIZED SOLUTION
    public static boolean isAlienSortedII(String[] words, String order) {
        if(words.length == 1)return true;
        int[] freq = new int[26];
        for(int i=0;i<order.length();i++) {
            //a=97, b=98, c=99....z=122
            //freq[0]=0, freq[1]=1, freq[2]=2....freq[25]=25
            freq[order.charAt(i)-'a'] = i;
        }
        for(int i=0;i<words.length-1;i++) {
            if(!isSortedII(words[i],words[i+1],freq))return false;
        }
        return true;
    }

    //OPTIMIZED SOLUTION
    public static boolean isSortedII(String word1,String word2,int[] freq) {
        int len = Integer.min(word1.length(),word2.length());
        int i=0;
        while(i < len) {
            if(word1.charAt(i) == word2.charAt(i)) {
                i++;
                continue;
            }
            //check order of first different character
            return freq[word1.charAt(i)-'a'] < freq[word2.charAt(i)-'a'];
        }
        return i >= word1.length();
    }
}
