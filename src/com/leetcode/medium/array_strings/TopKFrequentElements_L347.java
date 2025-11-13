package com.leetcode.medium.array_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//TODO: used co-pilot for test cases - https://copilot.microsoft.com/shares/HJGxBorjcoNhPk7z6uLt9
//prob #347 - top k frequent elements
public class TopKFrequentElements_L347 {
    public static void main(String[] args) {
        //1,2,1,2,1,2,3,1,3,2 | 2
        //1,2,1,2,1,2,3,1,3,2
        //[5,5,4,4,4,3,3,3,3]
        //[10,9,8,7,6,5,4,3,2,1]
        //[1,2,3,4,4,4,5,5,5,5]
        //[2,2,2,3,3,1]
        //[1,2,3,1,2,3,1,2,3]
        //[5,6,7,8,9,5,6,7,8,9,5,6,7,8,9]
        //[1,2,2,3,3,3,4,4,4,4]
        //[10000,9999,10000,9999,10000,9999]
        System.out.println(Arrays.toString(topKFrequent(new int[]{10000,9999,10000,9999,10000,9999},2)));
    }

    //1,2,1,2,1,2,3,1,3,2 | 2
    //{1=4, 2=4, 3=2}
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }
        //System.out.println(freq);
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((e1, e2)->Integer.compare(e2.getValue(),e1.getValue()));
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()) {
            pq.offer(entry);
        }
        //pq.forEach(e->System.out.println(e.getKey()));
        int[] res = new int[k];
        for(int i=0;i<k;i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
