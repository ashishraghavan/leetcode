package com.leetcode.easy;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * You may assume all the characters consist of printable ascii characters.
 */
public class ReverseString {
    public static void main(String[] args) {
        //'H','a','n','n','a','h'
        reverseString(new char[]{'E', 's', 't', 'e', 'b', 'a', 'n', ' ', 'G', 'a', 'r', 'c', 'i', 'a'});
    }

    static void reverseString(char[] s) {
        int frontPtr = 0;
        int lastPtr = s.length - 1;
        while (frontPtr < lastPtr) {
            //swap s[frontPtr] with s[lastPtr]
            swap(frontPtr++, lastPtr--, s);
        }
    }

    static void swap(int indexA, int indexB, char[] chars) {
        char temp = chars[indexA];
        chars[indexA] = chars[indexB];
        chars[indexB] = temp;
    }
}
