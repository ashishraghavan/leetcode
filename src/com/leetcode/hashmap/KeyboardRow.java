package com.leetcode.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of strings words, return the words that can be typed using letters of the alphabet
 * on only one row of American keyboard like the image below.
 *
 * In the American keyboard:
 *
 * the first row consists of the characters "qwertyuiop",
 * the second row consists of the characters "asdfghjkl", and
 * the third row consists of the characters "zxcvbnm".
 *
 * Input: words = ["Hello","Alaska","Dad","Peace"]
 * Output: ["Alaska","Dad"]
 *
 * Input: words = ["omk"]
 * Output: []
 *
 * Input: words = ["adsdf","sfd"]
 * Output: ["adsdf","sfd"]
 */
public class KeyboardRow {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
        System.out.println(Arrays.toString(findWords(new String[]{"Alaska","Dad"})));
    }

    //my incorrect solution
    static String[] findWords(String[] words) {
        //Hello.sort = ehllo, alaska.sort = aaakls
        Map<String,String> keyMap = new HashMap<>();
        String[] result = new String[words.length];
        char[] first = "qwertyuiop".toCharArray();
        char[] second = "asdfghjkl".toCharArray();
        char[] third = "zxcvbnm".toCharArray();
        Arrays.sort(first);//[e, i, o, p, q, r, t, u, w, y]
        Arrays.sort(second);//[a, d, f, g, h, j, k, l, s]
        Arrays.sort(third);//[b, c, m, n, v, x, z]
        keyMap.put("first",String.valueOf(first));
        keyMap.put("second", String.valueOf(second));
        keyMap.put("third",String.valueOf(third));
        int i = 0;
        for(String word : words) {
            char[] wordChArr = word.toCharArray();
            Arrays.sort(wordChArr);
            System.out.println(String.valueOf(wordChArr));
            //String sortedWord = String.valueOf(wordChArr);
            if (keyMap.get("first").contains(String.valueOf(wordChArr).toLowerCase()) ||
                    keyMap.get("second").contains(String.valueOf(wordChArr).toLowerCase()) ||
                    keyMap.get("third").contains(String.valueOf(wordChArr).toLowerCase())) {
                result[i++] = word;
            }
        }
        return result;
    }
}
