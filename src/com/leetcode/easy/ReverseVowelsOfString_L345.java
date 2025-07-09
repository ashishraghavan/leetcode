package com.leetcode.easy;

import java.util.Set;

//prob. # 345 - reverse vowels of a string
public class ReverseVowelsOfString_L345 {
    public static void main(String[] args) {
        //IceCreAm
        //leetcode
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        Set<Character> vowels = Set.of('A','a','E','e','I','i','O','o','U','u');
        int i=0,j=s.length()-1;
        char[] sCh = s.toCharArray();
        while(true) {
            while(i < s.length() && !vowels.contains(sCh[i])){i++;}
            while(j >= 0 && !vowels.contains(sCh[j])){j--;}
            if(i >= j)break;
            char temp = sCh[i];
            sCh[i] = sCh[j];
            sCh[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(sCh);
    }
}
