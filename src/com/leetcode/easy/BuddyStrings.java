package com.leetcode.easy;


/**
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * [UNSOLVED]
 */
public class BuddyStrings {
    public static void main(String[] args) {
        //"aaaaaaabc", "aaaaaaacb"
        System.out.println(buddyStrings("aa", "aa"));
    }

    static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        char[] AChar = A.toCharArray();
        char[] BChar = B.toCharArray();
        int ct = 0;
        if (A.equals(B)) {
            char firstChar = AChar[0];
            for (int i = 1; i < A.length(); i++) {
                if (AChar[i] != firstChar) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < AChar.length; i++) {
            if (AChar[i] != BChar[i]) {
                ct++;
            }
        }
        return (ct == 2);
    }
}
