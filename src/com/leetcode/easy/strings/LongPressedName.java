package com.leetcode.easy.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 *
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 *
 *
 *
 * Example 1:
 *
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 *
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 *
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 *
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 *
 * Solution obtained from https://leetcode.com/problems/long-pressed-name/discuss/466870/Java-100-100-very-easy-solution
 *
 * set i, j = 0, loop till i < named.length, j < typed.length. If we encounter same characters in named and typed, we
 * increment i. j will be incremented by loop itself. By the end of loop, count of i should be same as number of characters
 * of named. That is, typed should contain only characters in named. Repeated characters are fine.
 */
public class LongPressedName {
    public static void main(String[] args) {
        //name = "alex", typed = "aaleex"
        //name = "leelee", typed = "lleeelee"
        //name = "laiden", typed = "laiden"
        //"saeed","ssaaedd"
        //laiden,aaleex

        //ashish,shishbroa
        System.out.println(isLongPressedName("ashish","aaashiisssshh"));
        //,
    }

    static boolean isLongPressedName(String name, String typed) {
        char[] nameChar = name.toCharArray();
        char[] typedChar = typed.toCharArray();
        int i=0;
        int j=0;

        for(;i<nameChar.length && j < typedChar.length;j++) {
            if(nameChar[i] == typedChar[j]) {
                i++;
            }
        }
        return i==nameChar.length;
    }

    /*for(int i=0;i<name.length();i++) {
            if(nameMap.containsKey(name.charAt(i))) {
                nameMap.put(name.charAt(i),nameMap.get(name.charAt(i))+1);
            } else {
                nameMap.put(name.charAt(i),1);
            }
        }
        for(int i=0;i<typed.length();i++) {
            if(typedMap.containsKey(typed.charAt(i))) {
                typedMap.put(typed.charAt(i),typedMap.get(typed.charAt(i))+1);
            } else {
                typedMap.put(typed.charAt(i),1);
            }
        }
        //now check if typed map contains equal to or greater the frequency of each character in name.
        for(int j=0;j<name.length();j++) {
            if(!typedMap.containsKey(name.charAt(j))) {
                return false;
            }
            if(typedMap.get(name.charAt(j)) < nameMap.get(name.charAt(j))) {
                return false;
            }*/
}
