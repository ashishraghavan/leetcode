package com.leetcode.easy;

import java.util.Arrays;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsInAString {
    public static void main(String[] args) {
        //My name is Ashish
        System.out.println(reverseWords("My name is Ashish"));
    }

    private static String reverseWords(String str) {
        StringBuilder reversedWord = new StringBuilder();
        int frontPtr;
        int backPtr;
        if (!str.contains(" ")) {
            frontPtr = 0;
            backPtr = str.length() - 1;
            char[] strCharArray = str.toCharArray();
            while (frontPtr < backPtr) {
                swap(frontPtr++, backPtr--, strCharArray);
            }
            return Arrays.toString(strCharArray);
        }

        String[] splitString = str.split(" ");
        for (int i = 0; i < splitString.length; i++) {
            char[] chars = splitString[i].toCharArray();
            frontPtr = 0;
            backPtr = splitString[i].length() - 1;
            while (frontPtr < backPtr) {
                swap(frontPtr++, backPtr--, chars);
            }
            reversedWord.append(new String(chars));
            if (i < splitString.length - 1) {
                reversedWord.append(" ");
            }
        }
        return reversedWord.toString();
    }

    private static void swap(int indexA, int indexB, char[] chars) {
        char temp = chars[indexA];
        chars[indexA] = chars[indexB];
        chars[indexB] = temp;
    }
}
