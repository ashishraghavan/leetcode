package com.leetcode.easy.strings;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 */
public class DetectCapital {

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("mL"));
    }

    static boolean detectCapitalUse(String word) {
        char[] wordChars = word.toCharArray();
        if(wordChars.length == 1) {
            return true;
        }
        return ((Character.isUpperCase(word.charAt(0)) && areAllLettersSmall(wordChars))
                || areNoneCapital(wordChars)
                || areAllCapital(wordChars));
    }

    static boolean  areAllLettersSmall(char[] wordCharStr) {
        for (int i=1;i<wordCharStr.length;i++) {
            if (Character.isUpperCase(wordCharStr[i])) {
                return false;
            }
        }
        return true;
    }

    static boolean areNoneCapital(char[] wordChars) {
        for (char wordChar : wordChars) {
            if (Character.isUpperCase(wordChar)) {
                return false;
            }
        }
        return true;
    }

    static boolean areAllCapital(char[] wordChars){
        for (char wordChar : wordChars) {
            if (Character.isLowerCase(wordChar)) {
                return false;
            }
        }
        return true;
    }
}
