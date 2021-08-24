package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {

    public static void main(String[] args) {
        //aaabbccc, bbcaabcca
        System.out.println(canConstruct("aa","ab"));
    }

    //ransomNoteStr = aaabbccc
    //magazineStr =   bbcaabcca
    static boolean canConstruct(String ransomNoteStr, String magazineStr) {
        //If we exhaust ransomNoteStr characters, return true
        //If ransomNoteStr length is greater than magazineStr, return false as magazine str clearly consists of less characters than ransomNoteStr
        if(ransomNoteStr.length() > magazineStr.length()) {
            return false;
        }
        Map<Character,Integer> charCount = new HashMap<>();
        for(int i=0;i<magazineStr.length();i++) {
            if(charCount.containsKey(magazineStr.charAt(i))) {
                charCount.put(magazineStr.charAt(i),charCount.get(magazineStr.charAt(i))+1);
            } else {
                charCount.put(magazineStr.charAt(i),1);
            }
        }
        for(int i=0;i<ransomNoteStr.length();i++) {
            char ch = ransomNoteStr.charAt(i);
            if(!charCount.containsKey(ch)) {
                return false;
            }
            if(charCount.get(ch) <= 0) {
                return false;
            }
            charCount.put(ch,charCount.get(ch) - 1);
        }
        return true;
    }
}
