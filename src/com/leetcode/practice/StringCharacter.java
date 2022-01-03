package com.leetcode.practice;

/**
 * All API's provided by String & Character class.
 */
public class StringCharacter {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "bxa";
        //Is str2 anagram of str1??

        //get sum of all character ASCII values for str1
        long str1Sum = 0L;
        for(char ch : str1.toCharArray()) {
            str1Sum += (int)ch;
        }

        //get sum of all character ASCII values for str2
        long str2Sum = 0L;
        for(char ch : str2.toCharArray()) {
            str2Sum += (int)ch;
        }
        System.out.println("str1Sum = "+str1Sum+", str2Sum = "+str2Sum);
        //If all characters in str2 are same as in str1 (including the frequency)
        //str1sum should be equal to str2
        System.out.println("Is anagram : "+(str1Sum == str2Sum));
    }
}
