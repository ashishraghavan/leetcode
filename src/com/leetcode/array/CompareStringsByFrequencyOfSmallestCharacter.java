package com.leetcode.array;

import java.util.Arrays;

/**
 *
 * MEDIUM #1170
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s.
 * For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 *
 * Now, given string arrays queries and words, return an integer array answer,
 * where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
 */
public class CompareStringsByFrequencyOfSmallestCharacter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numSmallerByFrequency(new String[]{"bbb","cc"},new String[]{"a","aa","aaa","aaaa"})));
    }

    static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queryFrequency = new int[queries.length];
        int[] wordFrequency = new int[words.length];
        int count = 0;
        for (String query : queries) {
            queryFrequency[count++] = getLowestCharacterFrequencyWithoutSorting(query.toCharArray());
        }
        count =0;
        for (String word : words) {
            wordFrequency[count++] = getLowestCharacterFrequencyWithoutSorting(word.toCharArray());
        }
        int[] answer = new int[queries.length];
        for(int i=0;i<queryFrequency.length;i++) {
            answer[i] = 0;
            for (int value : wordFrequency) {
                if (value > queryFrequency[i]) {
                    answer[i] += 1;
                }
            }
        }
        return answer;
    }

    //aashiaash
    static int getLowestCharacterFrequencyWithoutSorting(char[] word) {
        char lowest = word[0];
        int lowestCount = 1;
        for(int i=1;i<word.length;i++) {
            if(word[i] < lowest) {
                lowest = word[i];
                lowestCount = 1;
            } else if(word[i] == lowest) {
                lowestCount++;
            }
        }
        return lowestCount;
    }
}
