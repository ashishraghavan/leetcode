package com.leetcode.medium.array_strings;

import java.util.*;

//TODO: can also be done by bucket sort (see https://copilot.microsoft.com/shares/tDFGg4R4Jch752HnZtQK9),
// see method frequencySortII(..) on line #45 - demonstrates bucket sort!!
//problem #451 - sort characters by frequency
public class SortCharactersByFrequency_L451 {
    public static void main(String[] args) {
        //tree
        //cccaaa
        //Aabb
        System.out.println(frequencySortII("Aabb"));
    }

    //cccaaa
    public static String frequencySort(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            //mp.merge(s.charAt(i),1,Integer::sum);
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
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

    //running time still the same/even worse than earlier, maybe check co-pilot link above for differences
    public static String frequencySortII(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            //mp.merge(s.charAt(i),1,Integer::sum);
            mp.put(s.charAt(i),mp.getOrDefault(s.charAt(i),0)+1);
        }
        System.out.println(mp);
        //{a=1, A=1, b=2}
        List<Character>[] buckets = new List[s.length()+1];
        for(int i=0;i<=s.length();i++) {
            buckets[i] = new ArrayList<>();
        }
        //output of below: [[], [A, a], [b], [], []]
        for(Map.Entry<Character,Integer> entry : mp.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }
        //System.out.println(Arrays.toString(buckets));
        StringBuilder sb = new StringBuilder();
        for(int i=buckets.length-1;i>=0;i--) {
            if(!buckets[i].isEmpty()) {
                List<Character> chList = buckets[i];
                for(Character ch : chList) {
                    sb.append(String.valueOf(ch).repeat(i));
                }
            }
        }
        System.out.println(sb);
        return sb.toString();
        //return "";
    }
}
