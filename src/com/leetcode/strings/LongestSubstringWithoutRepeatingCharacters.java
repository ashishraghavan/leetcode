package com.leetcode.strings;


import java.util.HashMap;
import java.util.Map;

/**
 * MEDIUM #3
 * 08-24-2021 - doing problem again.
 * 09-04-2021 - accepted
 *
 * <strong>Sliding window technique</strong>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    //
    //bbbbb
    //pwwkew
    //abcabcbbabcdef
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    //abcabcbb
    //abc - a is repeated, store abc in map & track its length as current max.
    //next character is new start - a,b,c - encounter b
    // "abc", "abc", "bb", "abcdef"
    //
    private static int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int cmax;
        Map<Character,Integer> hm = new HashMap<>();
        for(;end<s.length();end++) {
            Character ch = s.charAt(end);
            if(hm.containsKey(ch)) {
                //get max for index for this character & make it the new start
                //before that, get length of this substring.
                start = Math.max(hm.get(ch)+1,start);
            }
            cmax = (end - start) + 1;
            if(cmax > max) {
                max = cmax;
            }
            hm.put(ch,end);
        }
        return max;
    }
}
