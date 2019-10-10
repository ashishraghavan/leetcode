package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonCharacters {
    public static void main(String[] args) {
        //"bella","label","roller"
        //"cool","lock","cook"
        System.out.println(commonChars(new String[]{"ashish", "ashi", "shishbro", "shishipupu", "shitbag", "batshit"}));
    }

    static List<String> commonChars(String[] words) {
        String minimumLenStr = words[0];
        int minimumIndex = 0;
        List<String> repeatedList = new ArrayList<>();
        if (words.length == 1) {
            return Arrays.asList(words);
        }
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < minimumLenStr.length()) {
                minimumLenStr = words[i];
                minimumIndex = i;
            }
        }
        List<String> wordList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (i != minimumIndex) {
                wordList.add(words[i]);
            }
        }
        for (int i = 0; i < minimumLenStr.length(); i++) {
            String _charStr = Character.toString(minimumLenStr.charAt(i));
            int repeatCount = 0;
            for (String word : wordList) {
                if (word.contains(_charStr)) {
                    repeatCount++;
                    wordList.set(wordList.indexOf(word), word.replaceFirst(_charStr, ""));
                }
            }
            if (repeatCount == words.length - 1) {
                repeatedList.add(_charStr);
            }
        }
        return repeatedList;
    }
}
