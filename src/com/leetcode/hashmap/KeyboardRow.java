package com.leetcode.hashmap;

import java.util.*;

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
        //TC for findWords
        //System.out.println(Arrays.toString(findWords(new String[]{"Alaska","Dad"})));

        //TC for findWords_II
        //System.out.println(Arrays.toString(findWords_II(new String[]{"Hello","Alaska","Dad","Peace"})));
        //System.out.println(Arrays.toString(findWords_II(new String[]{"omk"})));
        //System.out.println(Arrays.toString(findWords_II(new String[]{"adsdf","sfd"})));
        //System.out.println(Arrays.toString(findWords_II(new String[]{"","??&ada"})));
        System.out.println(Arrays.toString(findWords_II(new String[]{"daddy","qwertyz"})));
    }

    //attempt #1 - my incorrect solution
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

    //attempt #2 - passing solution (runtime better than 100% of users with Java, memory better than 71.35% users with Java)
    static String[] findWords_II(String[] words) {
        List<String> resList = new ArrayList<>();
        String first = "qwertyuiop";
        String second = "asdfghjkl";
        String third = "zxcvbnm";
        String current;
        for(String word : words) {
            if (word == null || word.isEmpty()) continue;
            current = null;
            char[] wordChArr = word.toLowerCase().toCharArray();
            String firstCh = String.valueOf(wordChArr[0]);
            if (first.contains(firstCh)) {
                current = first;
            } else if (second.contains(firstCh)) {
                current = second;
            } else if (third.contains(firstCh)) {
                current = third;
            }
            if (current == null) continue;
            if (word.length() == 1) {
                resList.add(word);
                continue;
            }
            int i = 1;
            for (; i < wordChArr.length; i++) {
                if (!current.contains(Character.toString(wordChArr[i]))) {
                    break;
                }
            }
            if (i >= wordChArr.length) {
                resList.add(word);
            }
        }
        return resList.toArray(new String[0]);
    }
}
