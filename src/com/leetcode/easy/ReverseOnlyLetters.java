package com.leetcode.easy;

/**
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 */
public class ReverseOnlyLetters {
    public static void main(String[] args) {
        //Test1ng-Leet=code-Q!
        //a-bC-dEf-ghIj
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    static String reverseOnlyLetters(String str) {
        if (str.length() <= 0 || str.length() == 1) {
            return str;
        }
        int frontPtr = 0;
        int backPtr = str.length() - 1;
        char[] strChars = str.toCharArray();
        while (frontPtr < backPtr) {
            if (!Character.isLetter(str.charAt(frontPtr))) {
                frontPtr++;
                continue;
            }
            if (!Character.isLetter(str.charAt(backPtr))) {
                backPtr--;
                continue;
            }
            //else swap
            swap(frontPtr++, backPtr--, strChars);
        }
        return String.valueOf(strChars);
    }

    private static void swap(int indexA, int indexB, char[] chars) {
        char temp = chars[indexA];
        chars[indexA] = chars[indexB];
        chars[indexB] = temp;
    }
}
