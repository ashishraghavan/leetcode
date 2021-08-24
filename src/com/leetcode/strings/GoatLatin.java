package com.leetcode.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 * <p>
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * <p>
 * The rules of Goat Latin are as follows:
 * <p>
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * <p>
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * <p>
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 */
public class GoatLatin {
    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }

    private static String toGoatLatin(String goat) {
        Set<Character> vowelsSmall = Stream.of('a', 'e', 'i', 'o', 'u').collect(Collectors.toCollection(HashSet::new));
        Set<Character> vowelsCapital = Stream.of('A', 'E', 'I', 'O', 'U').collect(Collectors.toCollection(HashSet::new));
        Map<Integer, String> aMap = new HashMap<>();
        String[] splitGoat = goat.split(" ");
        String a = "";
        for (int i = 0; i < splitGoat.length; i++) {
            a = a + "a";
            aMap.put(i, a);
        }
        StringBuilder goatBuilder = new StringBuilder();
        for (int i = 0; i < splitGoat.length; i++) {
            String word = splitGoat[i];
            goatBuilder.append(word);
            if (vowelsSmall.contains(word.charAt(0)) ||
                    vowelsCapital.contains(word.charAt(0))) {
                goatBuilder.append("ma");
            } else {
                //consonant
                word.charAt(0);
            }
            goatBuilder.append(aMap.get(i));
        }
        return goatBuilder.toString();
    }
}
