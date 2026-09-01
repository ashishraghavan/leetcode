package com.leetcode.medium.heap_topk;

import java.util.Comparator;
import java.util.PriorityQueue;

//#703
public class KthLargestInAStream {
    public static void main(String[] args) {
//        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
//        // return 4
//        System.out.println(kthLargest.add(3));
//        // return 5
//        System.out.println(kthLargest.add(5));
//        // return 5
//        System.out.println(kthLargest.add(10));
//        // return 8
//        System.out.println(kthLargest.add(9));
//        // return 8
//        System.out.println(kthLargest.add(4));


        KthLargest kthLargest = new KthLargest(4, new int[]{7, 7, 7, 7, 8, 3});
        // return 7
        System.out.println(kthLargest.add(2));
        // return 7
        System.out.println(kthLargest.add(10));
        // return 7
        System.out.println(kthLargest.add(9));
        // return 8
        System.out.println(kthLargest.add(9));
    }

    static class KthLargest {
        PriorityQueue<Integer> pq;
        int k;
        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            this.k = k;
            for(int element : nums) {
                add(element);
            }
        }

        //IMPORTANT LOGIC
        //if size of queue is less than k, add val to queue
        //else
        //if val > element with lowest priority
        //then
            //1. remove said element
            //2. add val
        public int add(int val) {
            if(pq.size() < k) {
                pq.offer(val);
            } else if(val > pq.peek()) {
                pq.poll();
                pq.offer(val);
            }
            return pq.peek();
        }
    }
}
