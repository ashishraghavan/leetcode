package com.leetcode.easy.strings;

/**
 * Give a string s, count the number of non-empty (contiguous) substrings that have
 * the same number of 0's and 1's, and all the 0's and all the 1's in these
 * substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 *
 * strings need to have equal count of both 0 and 1 and grouped together. THis
 * means 00 and 11 won't count. 10 or 01 are good because they contain one 0
 * and one 1 each.
 *
 * [UNSOLVED]
 */
public class CountBinarySubStrings {
    public static void main(String[] args) {
        System.out.println("00110011");
    }

    //you can't separate out the 1's and 0's
    //which would change the ordering.
    //for each sliding window, count no
    //of 1's and 0's. If they are equal,
    //add substring starting from start
    //of the window to end.
    static int countBinarySubstrings(String str) {
        //first start with original string
        if(str == null || str.isEmpty() || str.length() == 1) {
            return 0;
        }
        if(str.length() == 2) {
            if((str.charAt(0) == 0 && str.charAt(1) == 1) ||
                    (str.charAt(0) == 1 && str.charAt(1) == 0)) {
                return 1;
            }
        }
        char[] chars = str.toCharArray();
        int startIndex = 0;
        int windowLength = 3;
        int endIndex = 2;
        int i = startIndex;
        int j = endIndex;
        for(;i<chars.length;i=i+windowLength,j=j+endIndex+1) {

        }
        return -1;
    }
}
