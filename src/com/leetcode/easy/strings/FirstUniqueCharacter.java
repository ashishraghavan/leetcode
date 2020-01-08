package com.leetcode.easy.strings;

import java.util.LinkedHashMap;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 * TODO : Run time is too high. Update needed!
 */
public class FirstUniqueCharacter {
    public static void main(String[] args) {
        //leetcode
        System.out.println(firstUniqChar("loveleetcode"));
    }

    static int firstUniqChar(String str) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<str.length();i++) {
            if(map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            } else {
                map.put(str.charAt(i),1);
            }
        }
        for(Character key :map.keySet()) {
            if(map.get(key) == 1) {
                return str.indexOf(key);
            }
        }
        return -1;
    }
}
