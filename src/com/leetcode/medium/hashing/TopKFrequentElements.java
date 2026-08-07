package com.leetcode.medium.hashing;

import java.util.*;

//#347
public class TopKFrequentElements {
    public static void main(String[] args) {
        //1,1,1,2,2,3|2
        //1,2,1,2,1,2,3,1,3,2|2
        //-1, -1, -2, -2, -2, 3|2
        //4, 4, 4, 4, 4|1
        //1, 2, 3, 4, 5|5
        //1, 2, 1, 3, 2, 1|2
        //0, 0, 0, 1, 1|1
        //5, 4, 4, 3, 3, 3, 2, 2, 2, 2|2
        //1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3|3
        //2147483647, 2147483647, -2147483648|1
        //1|1
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 3, 4, 5},5)));
    }

    //1,1,1,2,2,3, k=2
    public static int[] topKFrequent(int[] A, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> m = new HashMap<>();
        for(int val : A) {
            m.merge(val,1,Integer::sum);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((e1,e2)->e1.getValue().compareTo(e2.getValue()));
        for(Map.Entry<Integer,Integer> entry : m.entrySet()) {
            pq.offer(entry);
            //we are concerned only with the top k elements with highest frequency. Ex. for A=[1,1,1,2,2,3],k=2
            //and when the priority queue becomes pq={3:1,2:2,1:3}, we are not bothered with the anything below k-2.
            //Therefore, we can drop the entry {3:1}. On the other hand, if k=3, then we don't!
            if(pq.size() > k) {
                pq.poll();
            }
        }
        for(int i=0;i<k;i++) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
