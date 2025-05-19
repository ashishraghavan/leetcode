package com.leetcode.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//problem # 290 - word pattern
//TODO: wrong understanding, revise!!!
//check https://github.com/doocs/leetcode/tree/main/solution/0200-0299/0290.Word%20Pattern
//for github solution
public class WordPattern_L290 {
    public static void main(String[] args) {
        //"abbac","dog cat cat dog"
        //"booo","dora tora tora dora"
        System.out.println(wordPattern("aba","dog cat cat"));
        //wordPattern("abba","dog cat cat dog");
    }

    //pattern = "abba", s = "dog cat cat dog"
    //pattern = "aba", s = "dog cat cat"
    //baba, dog cat cat dog -> b =2, a = 2 | dog = 2, cat = 2
    //dora, dog cat mouse house -> unique chars in pattern = 4, unique words in s = 4
    //booo, dora tora dora dora -> ct(b,o) = ct(dora, tora)

    //{a=2, b=2}
    //{cat=2, dog=2}

    //booo, dora tora tora dora -> b = 1, o = 3 | dora = 2, tora = 3, ct. of characters in pattern = ct. of words in s but freq. of chars in pattern != freq. of words in s
    //"abba", s = "dog cat cat fish" -> a = 2, b = 2 | dog = 1, cat = 2, fish = 1, freq. of chars in pattern = (2,2) != freq. of words in s = (1,2,1)
    //"aaaa", s = "dog cat cat dog" -> a=4 | dog = 2, cat = 2, freq of chars in pattern = (4) != freq. of words in s = (2,2)
    //pattern = "aba", s = "dog cat cat" -> a=2,b=1 | cat=2,dog=1
    public static boolean wordPattern(String pattern, String s) {
        Map<Character,Long> charFreq = pattern.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(charFreq);
        Map<String,Long> wordFreq = Arrays.stream(s.split("\\s")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1));
        //wordFreq
        System.out.println(wordFreq);
        //System.out.println("charfreq values: "+charFreq.values());
        //System.out.println("wordFreq values: "+wordFreq.values());
        //charFreq.values().equals(wordFreq.values())
        return (charFreq.size() == wordFreq.size()) && (charFreq.values().containsAll(wordFreq.values()));
    }
}
