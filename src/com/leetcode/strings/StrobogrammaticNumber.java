package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    public static void main(String[] args) {
        //6969 -> 9696 -> 6969, return true
        System.out.println(isStrobogrammaticNumber("69769"));
    }

    public static boolean isStrobogrammaticNumber(String str) {
        System.out.println(str);
        Map<Character,Character> stbMap = new HashMap<>();
        stbMap.put('1','~');
        stbMap.put('2','~');
        stbMap.put('3','~');
        stbMap.put('4','~');
        stbMap.put('5','~');
        stbMap.put('6','9');
        stbMap.put('7','~');
        stbMap.put('8','8');
        stbMap.put('9','6');

        //reverse str
        String reverse = new StringBuilder(str).reverse().toString();
        char[] reverseCh = reverse.toCharArray();
        for(int i=0;i<reverseCh.length;i++) {
            reverseCh[i] = stbMap.get(reverse.charAt(i));
        }
        String reverseStr = new String(reverseCh);
        System.out.println(reverseStr);
        return reverseStr.equals(str);
    }
}
