package com.leetcode.easy.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        //"gin", "zen", "gig", "msg"
        //"abc","abc","def"
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    @SuppressWarnings("ForLoopReplaceableByForEach")
    static int uniqueMorseRepresentations(String[] words) {
        //morse code strings for characters 'a' to 'z'
        String[] morseCodeArray = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Map<Character, String> morseCodeMap = new HashMap<>();
        char startingChar = 'a';
        for (int i = 0; i < morseCodeArray.length; i++) {
            morseCodeMap.put(startingChar++, morseCodeArray[i]);
        }
        StringBuilder morseCodeStrBuilder = new StringBuilder();
        Set<String> morseCodeUniqueSet = new HashSet<>();
        Map<String, String> morseCodeWordMap = new HashMap<>();
        for (int j = 0; j < words.length; j++) {
            char[] wordCharArray = words[j].toCharArray();
            morseCodeStrBuilder.setLength(0);
            for (char wordChar : wordCharArray) {
                morseCodeStrBuilder.append(morseCodeMap.get(wordChar));
            }
            morseCodeWordMap.put(words[j], morseCodeStrBuilder.toString());
        }
        for (String morseCodeKey : morseCodeWordMap.keySet()) {
            morseCodeUniqueSet.add(morseCodeWordMap.get(morseCodeKey));
        }
        return morseCodeUniqueSet.size();
    }
}
