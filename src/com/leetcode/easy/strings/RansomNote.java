package com.leetcode.easy.strings;

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
        System.out.println(canConstruct("aa","aab"));
    }

    //ransomNoteStr = aaabbccc
    //magazineStr =   bbcaabcca
    static boolean canConstruct(String ransomNoteStr, String magazineStr) {
        //If we exhaust ransomNoteStr characters, return true
        //If even a single character cannot be found in magazineStr, we return false.
        //If ransomNoteStr length is greater than magazineStr, return false as magazine str clearly consists of less characters than ransomNoteStr
        if(ransomNoteStr.length() > magazineStr.length()) {
            return false;
        }
        for(int i=0;i<ransomNoteStr.length();i++) {
            //contains will scan the entire string to give a result.
            if(magazineStr.contains(String.valueOf(ransomNoteStr.charAt(i)))) {
                int foundIndex = magazineStr.indexOf(ransomNoteStr.charAt(i));
                //remove char at index foundIndex and continue
                magazineStr = magazineStr.replaceFirst(String.valueOf(magazineStr.charAt(foundIndex)),"");
            } else {
                return false;
            }
        }
        return true;
    }
}
