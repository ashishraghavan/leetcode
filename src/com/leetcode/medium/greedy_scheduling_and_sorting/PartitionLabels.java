package com.leetcode.medium.greedy_scheduling_and_sorting;

import java.util.ArrayList;
import java.util.List;

//#763
//refer https://share.gemini.google/zyjPbvFWbrC2
public class PartitionLabels {
    public static void main(String[] args) {
        //ababcbacadefegdehijhklij
        //eccbbbbdec
        //abaccd
        //abcdef
        //aaaaaa
        //abccba
        //caedbdedda
        //abacdefefg
        //abcdefghijklmnopqrstuvwxyza
        System.out.println(partitionLabelsII("abcdefghijklmnopqrstuvwxyza"));
    }

    public static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];

        // 1. Record the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int boundary = 0;

        // 2. Greedily schedule interval cuts
        for (int i = 0; i < s.length(); i++) {
            boundary = Math.max(boundary, last[s.charAt(i) - 'a']);

            // All characters in the current window are fully resolved
            if (i == boundary) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }

        return result;
    }


    //abacdefefg
    public static List<Integer> partitionLabelsII(String s) {
        int[] last = new int[26];
        int boundary = 0,start = 0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            last[s.charAt(i)-'a'] = i;
        }
        for(int i=0;i<s.length();i++) {
            boundary = Math.max(boundary,last[s.charAt(i)-'a']);
            if(i==boundary) {
                result.add(boundary - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
