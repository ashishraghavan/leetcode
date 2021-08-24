package com.leetcode.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * <p>
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 */
public class MaximumNoOfBalloons {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("aloonbbaoonllll"));
    }

    static int maxNumberOfBalloons(String text) {
        String balloon = "balloon";
        Map<String, Integer> balloonCount = new HashMap<>();
        balloonCount.put("balloon", 0);
        while (true) {
            //for each character in balloon, check if we can find it in "text"
            for (int i = 0; i < balloon.length(); i++) {
                String character = Character.toString(balloon.charAt(i));
                if (!text.contains(character)) {
                    return balloonCount.get("balloon");
                }
                text = text.replaceFirst(character, "");
            }
            balloonCount.put("balloon", balloonCount.get("balloon") + 1);
        }
    }
}
