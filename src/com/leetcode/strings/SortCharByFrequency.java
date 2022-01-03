package com.leetcode.strings;

import java.util.Arrays;
import java.util.Map;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. [If there are multiple answers, return any of them.]
 *
 * s = "tree" ==> "eert"
 * e appears twice. r and t appear once. So, either "eert" or "eetr" are correct answers
 *
 * s = "cccaaa" ===> "aaaccc"/"cccaaa" are correct answers
 *
 * s = "Aabb" ===> "bbAa"/"bbaA" are correct answers
 *
 * [s consists of uppercase and lowercase English letters and digits.]
 */
public class SortCharByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    static String frequencySort(String s) {
        int[] ascii = new int[256];
        Arrays.fill(ascii,0);
        char[] chArr = s.toCharArray();
        for(char ch : chArr) {
            ascii[ch]++;
        }

        //O/P ; e:2 r:1 t:1

        return s;
    }
}
