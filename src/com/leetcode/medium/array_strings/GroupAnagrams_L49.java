package com.leetcode.medium.array_strings;

import java.util.*;

//TODO: refer https://algo.monster/liteproblems/49 for intuitive & detailed solution
//prob #49 - group anagrams
public class GroupAnagrams_L49 {
    public static void main(String[] args) {
        //"eat","tea","tan","ate","nat","bat"
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    //"eat","tea","tan","ate","nat","bat" => sorting => aet,aet,ant,aet,ant,abt
    //Word word = new Word(String str,String sortedStr,int idx), List<Word> list
    //word1 = (eat,ate,0), word2 = (tea,aet,1)...wordN = (bat,abt,5)
    //HashSet<Word> set = {}
    //for word in list, if set contains word ? HashSet<String> subset = {word.str}
    //Map<String,List<String>>
    ////took reference from google
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(String str : strs) {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String sortedStr = String.valueOf(chArr);
            if(mp.containsKey(sortedStr)) {
                mp.get(sortedStr).add(str);
            } else {
                List<String> subList = new ArrayList<>();
                subList.add(str);
                mp.put(sortedStr,subList);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(String key : mp.keySet()) {
            res.add(mp.get(key));
        }
        return res;
    }
}
