package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

//TODO : pending, took too much time
public class UniqueWordAbbreviation {

    static ValidWordAbbr vwa;
    public static void main(String[] args) {
        vwa = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card", "dear", "cart", "cane", "make", "cake","internationalization"});
        //System.out.println("abbreviation : "+abbreviate("internationalization"));
        //System.out.println("abbreviation : "+abbreviate("it"));
        //System.out.println("abbreviation : "+abbreviate("jackass"));
        //System.out.println("abbreviation : "+abbreviate("s"));
        //System.out.println("isUnique : "+isUnique("cart"));
    }

    static boolean isUnique(String word) {
        //key = abbr, value = word
        Map<String,String> abbrMap = new HashMap<>();
        String[] dictionary = vwa.validWordAbbr;
        //Arrays.stream(dictionary).map(UniqueWordAbbreviation::abbreviate).
        for (String dictWord : vwa.validWordAbbr) {

        }
        String abWord = abbreviate(word);
//        if (!abbrMap.containsKey(abWord)) {
//            return true;
//        }
        return abbrMap.get(abWord).equalsIgnoreCase(word);
    }

    static String abbreviate(String word) {
        //given word has at least one character
        if (word.length() <= 2) {
            return word;
        }
        //word has at least 3 characters
        return Character.toString(word.charAt(0)) + (word.length() - 2) + (word.charAt(word.length() - 1));
    }

    static class ValidWordAbbr {
        String[] validWordAbbr;
        ValidWordAbbr(String[] validWordAbbr) {
            this.validWordAbbr = validWordAbbr;
        }
    }
}
