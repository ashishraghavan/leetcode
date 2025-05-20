package com.leetcode.easy;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//problem # 819 - most common word
//check https://github.com/doocs/leetcode/tree/main/solution/0800-0899/0819.Most%20Common%20Word for github optimized solution
//TODO: review to understand usage of Pattern, Matcher classes!
public class MostCommonWord_L819 {
    public static void main(String[] args) {
        //"Bob hit a ball, the hit BALL flew far after it was hit." || "hit"
        //a. || []
        //Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. || "lorem","ipsum"
        //"a, a, a, a, b,b,b,c, c" || "a"
        String paragraph = "lorem ipsum, gonad tin lorem!! lorem bosom ? apposum cement flour chor dad mom wife gonad tak dhin go gogo goa gone   ipsum lorem lorem,,,gonad tak dhin";
        System.out.println(mostCommonWord_Optimized(paragraph,new String[]{"chor", "tin", "dhin","ipsum"}));

//        Pattern pattern = Pattern.compile("[a-z]+");
//        Matcher matcher = pattern.matcher(paragraph.toLowerCase());
//        while (matcher.find()) {
//            System.out.println(matcher.group());
//        }
    }

    //clarifying questions
    //can words contain symbols in between characters ex. h?it, b.all? Or will it always be at the beginning or end of a word? assuming YES
    //are words separated by single space?

    //split by space, iterate resulting string array & create map with key=word, value = frequency after lowercasing & removing all symbols from the word,
    //sort above map in descending order of values
    //!?',;.
    //maybe store banned words in a hashset
    //iterate map, return first word not in the banned set as answer
    //Inefficient solution
    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Long> freq = Arrays.stream(paragraph.replaceAll("\\p{Punct}"," ").split("\\s+")).map(String::toLowerCase)
                //.map(word->word.replaceAll("\\p{Punct}",""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(v1,v2)->v1,LinkedHashMap::new));
        Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());
        System.out.println(freq);
        for(String word:freq.keySet()) {
            if(!bannedSet.contains(word)) {
                return word;
            }
        }
        return "NOT_FOUND";
    }

    //github solution
    public static String mostCommonWord_Optimized(String paragraph, String[] banned) {
        Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(paragraph.toLowerCase());
        Map<String,Integer> freq = new HashMap<>();
        while(matcher.find()) {
            String text = matcher.group();
            if(!bannedSet.contains(text)) {
                freq.put(text,freq.getOrDefault(text,0)+1);
            }
        }
        int max = Integer.MIN_VALUE;
        String maxWord = null;
        for(String word:freq.keySet()) {
            if(freq.get(word) > max) {
                max = freq.get(word);
                maxWord = word;
            }
        }
        return maxWord;
    }
}
