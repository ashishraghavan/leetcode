package com.leetcode.strings;

public class ToLowerCase {
    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));
    }


    /**
     * Character        CodePoint
     * 'a'              97
     * 'b'              98
     * ..               ..
     * ..               ..
     * 'z'              122
     *
     * 'A'              65
     * 'B'              66
     * ..               ..
     * ..               ..
     * 'Z'              90
     *
     * Note that there is a difference of 32 between lower case and upper case
     * characters.
     * codepoint(currentcharacter.lowercase) = codepoint(currentcharacter) + 32 [Not sure if 32 will be the same on all machines though]
     *
     * TODO : Instead of using Character class for checking if current character is uppercase and getting codepoint, use something else
     * @param str The input string which needs to be converted to lower case
     */
    private static String toLowerCase(String str) {
        char[] strCharArray = str.toCharArray();
        for(int i = 0; i < str.length();i++) {
            if(Character.isUpperCase(strCharArray[i])) {
                int currentCodePoint = Character.codePointAt(strCharArray,i);
                strCharArray[i] = (Character.toChars(currentCodePoint + 32))[0];
            }
        }
        return String.valueOf(strCharArray);
    }
}
