package com.leetcode.medium.heap_topk;

import java.util.PriorityQueue;

//#215
public class KthLargestElementInArray {
    public static void main(String[] args) {
        //3,2,1,5,6,4|2
        //3,2,3,1,2,4,5,5,6|4
        //2, 2, 2, 2, 2, 2|3
        //1, 2, 3, 4, 5, 6|2
        //6, 5, 4, 3, 2, 1|6
        //7, 10, 4, 3, 20, 15|1
        //7, 10, 4, 3, 20, 15|6
        //-1, -5, -3, 0, 2, 5|2
        //1|1
        //10000, -10000, 0, 5000, -5000|3
        System.out.println(findKthLargest(new int[]{10000, -10000, 0, 5000, -5000},3));
    }

    //3,2,1,5,6,4   k=2
    public static int findKthLargest(int[] A, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compareTo);
        for(int element : A) {
            pq.offer(element);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
