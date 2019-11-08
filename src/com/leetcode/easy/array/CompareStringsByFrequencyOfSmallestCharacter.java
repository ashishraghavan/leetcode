package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s.
 * For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 *
 * Now, given string arrays queries and words, return an integer array answer,
 * where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
 */
//Arrays.toString(numSmallerByFrequency(new String[]{"bbb","cc"},new String[]{"a","aa","aaa","aaaa"})))
public class CompareStringsByFrequencyOfSmallestCharacter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numSmallerByFrequency(new String[]{"cbd"},new String[]{"zaaaz"})));
    }

    static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queryFrequency = new int[queries.length];
        int[] wordFrequency = new int[words.length];
        int count = 0;
        for (String query : queries) {
            char[] queryCharArray = query.toCharArray();
            //O(nlogn)
            Arrays.sort(queryCharArray);
            queryFrequency[count++] = getLowestCharacterFrequency(queryCharArray);
        }
        count =0;
        for (String word : words) {
            char[] wordCharArr = word.toCharArray();
            Arrays.sort(wordCharArr);
            wordFrequency[count++] = getLowestCharacterFrequency(wordCharArr);
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

    static int getLowestCharacterFrequency(char[] word) {
        //First character is the lowest.
        char lowest = word[0];
        int lowestCount = 0;
        int index = 0;
        //Find how many times is the first character repeated
        while(index < word.length && word[index++] == lowest) {
            lowestCount++;
        }
        return lowestCount;
    }
}
