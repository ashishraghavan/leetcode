package com.leetcode.medium;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


//TODO : Use the sliding window technique for Strings. Below method does not work for all strings i.e it is not the correct solution.
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    private static int lengthOfLongestSubstring(@NotNull String str) {
        //For appending to build the longest substring. Will be cleared off after a repeated character is encountered.
        //A list which keeps track of characters in the longest substring that have been currently parsed.
        List<Character> characterTracker = new ArrayList<>();
        int currentLongestSubstringCount = 0;
        for(int i =0; i <str.length();i++) {
            if(!characterTracker.contains(str.charAt(i))) {
                characterTracker.add(str.charAt(i));
                continue;
            }
            //The longest substring size will be the character tracker list size since we
            //have been putting all non-repeating characters of a substring in this list.
            if(characterTracker.size() > currentLongestSubstringCount) {
                currentLongestSubstringCount = characterTracker.size();
            }
            //We do a reset of the character tracker list by clearing it.
            characterTracker.clear();
            //Add the repeated character to the character tracker list and start over again.
            characterTracker.add(str.charAt(i));
        }
        if((currentLongestSubstringCount == 0 && characterTracker.size() > 0) ||
                (characterTracker.size() > currentLongestSubstringCount)) {
            currentLongestSubstringCount = characterTracker.size();
        }
        return currentLongestSubstringCount;
    }
}
