package com.leetcode.medium.array_strings;

import java.util.*;

//TODO: go through optimized solution
//problem #451 - sort characters by frequency
public class SortCharactersByFrequency_L451 {
    public static void main(String[] args) {
        //tree
        //cccaaa
        //Aabb
        System.out.println(frequencySort("Aabb"));
    }

    //cccaaa
    public static String frequencySort(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            mp.merge(s.charAt(i),1,Integer::sum);
        }
        //{a=1, A=1, b=2}
        System.out.println(mp);
//        TreeSet<Character> sortedKeys = new TreeSet<>((c1,c2)->mp.get(c2).compareTo(mp.get(c1)));
//        sortedKeys.addAll(mp.keySet());
//        System.out.println(sortedKeys);
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((e1,e2)
                ->e2.getValue().compareTo(e1.getValue()));
        for(Map.Entry<Character,Integer> entry : mp.entrySet()) {
            pq.offer(entry);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Map.Entry<Character,Integer> entry = pq.poll();
            //int times = entry.getValue();
            sb.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }
        System.out.println(sb);
        return sb.toString();
        //return "";
    }
}
