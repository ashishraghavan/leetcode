package com.leetcode.easy.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }

    static int romanToInt(String roman) {
        Map<String,Integer> charMap = new HashMap<>();
        Map<String,Integer> superMap = new HashMap<>();
        Map<String,Integer> subCharMap = new HashMap<>();

        charMap.put("V",5);
        charMap.put("L",50);
        charMap.put("D",500);
        return -1;
    }
}
