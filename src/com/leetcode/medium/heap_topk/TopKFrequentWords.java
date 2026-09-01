package com.leetcode.medium.heap_topk;

import java.util.*;

//#692
public class TopKFrequentWords {
    public static void main(String[] args) {
        //"the","day","is","sunny","the","the","the","sunny","is","is"|4
        //"i","love","leetcode","i","love","coding"|2
        //"zebra", "apple", "apple", "zebra", "banana", "banana"|2
        //"app", "apple", "app", "apple", "ap", "ap"|2
        //"c", "c", "c", "b", "b", "a"|3
        System.out.println(topKFrequent(new String[]{"c", "c", "c", "b", "b", "a"},3));
    }

    //"the","day","is","sunny","the","the","the","sunny","is","is"|4
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>((w1,w2)->
                map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1):map.get(w1).compareTo(map.get(w2)));
        for(String word : words) {
            map.merge(word,1,Integer::sum);
        }
        for(String key : map.keySet()) {
            pq.offer(key);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
