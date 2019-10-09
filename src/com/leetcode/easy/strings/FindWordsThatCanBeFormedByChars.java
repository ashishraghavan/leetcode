package com.leetcode.easy.strings;

/**
 * You are given an array of strings words and a string chars.
 * <p>
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * <p>
 * Return the sum of lengths of all good strings in words.
 * After solution thoughts:
 * Improve the running time. It's 86 ms right now.
 */
public class FindWordsThatCanBeFormedByChars {
    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }

    private static int countCharacters(String[] words, String chars) {
        int count = 0;
        int countCopy;
        String charsCopy;
        for (String word : words) {
            charsCopy = chars;
            countCopy = 0;
            char[] wordCharArray = word.toCharArray();
            int index;
            for (char c : wordCharArray) {
                index = charsCopy.indexOf(c);
                if (index == -1) {
                    countCopy = 0;
                    //character is not present in charsCopy
                    break;
                }
                countCopy++;
                charsCopy = charsCopy.replaceFirst(String.valueOf(charsCopy.charAt(index)), "");
            }
            count += countCopy;
        }
        return count;
    }
}
