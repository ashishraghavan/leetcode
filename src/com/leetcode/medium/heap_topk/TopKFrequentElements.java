package com.leetcode.medium.heap_topk;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//#347
public class TopKFrequentElements {
    public static void main(String[] args) {
        //int[] nums = new int[]{7, 7, 7, 7, 7}; int k = 1;
        //int[] nums = new int[]{1, 2, 3, 4, 5}; int k = 5;
        //int[] nums = new int[]{-1, -1, -1, -2, -2, -3}; int k = 2;
        //int[] nums = new int[]{0, 0, 0, 1, 1, 2}; int k = 2;
        //int[] nums = new int[]{5, 3, 1, 1, 1, 3, 5, 7, 3, 1}; int k = 3;
        //int[] nums = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4}; int k = 3;
        int[] nums = new int[]{10000, 10000, -10000, -10000, -10000}; int k = 1;
        //int[] nums = new int[]{4,1,-1,2,-1,2,3}; int k = 2;
        //int[] nums = new int[]{4,1,-1,2,-1,2,3}; int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> m = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
                (e1,e2)->Integer.compare(e1.getValue(),e2.getValue()));
        for(int elem : nums) {
            m.merge(elem,1,Integer::sum);
        }
        for(Map.Entry<Integer,Integer> entry : m.entrySet()) {
            if(pq.size() < k) {
                pq.offer(entry);
            } else if(pq.peek().getValue() < entry.getValue()) {
                pq.poll();
                pq.offer(entry);
            }
        }
        int i=0;
        while(!pq.isEmpty()) {
            result[i++] = pq.poll().getKey();
        }
        return result;
    }
}
