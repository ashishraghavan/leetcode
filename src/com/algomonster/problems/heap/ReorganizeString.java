package com.algomonster.problems.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//TODO: https://algo.monster/problems/reorganize_string, leetcode problem #767
public class ReorganizeString {
    public static void main(String[] args) {
        //aab
        //aaab
        //zdayymzbqzjmmiizvv
        System.out.println(reorganizeStringII("zdayymzbqzjmmiizvv"));
    }

    //#1. create frequency map(mp)
    //#2. use priority queue(pq) of type Map.Entry used in #1 to store all entries of mp with reverse comparator for value i.e.
    // (e1,e2)->Integer.compare(e2.getValue(),e1.getValue()) -> given two map entries e1,e2 check if entry #2.value > entry #1.value
    //#3. if pq.peek().value() > (n+1)/2 i.e if frequency of most frequent character is greater than half the # of characters in the string,return empty string
    //#4. Initialize empty character array as result with size = original string
    //#5. run while loop with condition !pq.isEmpty(), loop over pq.getValue(), populate indexes 0,2,4...n+2. Once done, reset to 1 & continue for indexes 1,3,5...n+2
    //#6. return new string created using character array initialized in #4
    public static String reorganizeString(String s) {
        int n = s.length();
        Map<Character,Integer> fq = new HashMap<>();
        for(int i=0;i<n;i++) {
            fq.merge(s.charAt(i),1,Integer::sum);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq =
                new PriorityQueue<>((e1,e2)->Integer.compare(e2.getValue(),e1.getValue()));
        for(Map.Entry<Character,Integer> entry : fq.entrySet()) {
            pq.offer(entry);
        }
        if(pq.peek().getValue() > (n+1)/2) {
            return "";
        }
        char[] res = new char[n];
        int ptr = 0;
        while(!pq.isEmpty()) {
            Map.Entry<Character,Integer> entry = pq.poll();
            for(int i=0;i<entry.getValue();i++) {
                res[ptr] = entry.getKey();
                ptr += 2;
                if(ptr >= n) {
                    ptr = 1;
                }
            }
        }
        return new String(res);
    }

    //practice run
    public static String reorganizeStringII(String s) {
        int n = s.length();
        //create frequency map
        Map<Character,Integer> freq = new HashMap<>();
        for(int i=0;i<n;i++) {
            freq.merge(s.charAt(i),1,Integer::sum);
        }
        //initialize priority queue of Map.Entry<Character,Integer>
        PriorityQueue<Map.Entry<Character,Integer>> pq =
                new PriorityQueue<>((e1,e2)->Integer.compare(e2.getValue(),e1.getValue()));
        for(Map.Entry<Character,Integer> entry : freq.entrySet()) {
            pq.offer(entry);
        }
        //if frequency of char with highest count is more than half the no of total characters,
        // return empty as required string cannot be formed
        if(pq.peek().getValue() > (n+1)/2) {
            return "";
        }
        char[] res = new char[n];
        int ptr = 0;
        while(!pq.isEmpty()) {
            Map.Entry<Character,Integer> entry = pq.poll();
            for(int i=0;i<entry.getValue();i++) {
                res[ptr] = entry.getKey();
                ptr += 2;
                if(ptr >= n) {
                    ptr = 1;
                }
            }
        }
        return new String(res);
    }
}
