package com.leetcode.medium.heap_topk;

import java.util.Comparator;
import java.util.PriorityQueue;

//#1046
public class LastStoneWeight {
    public static void main(String[] args) {
        //2,7,4,1,8,1
        //2, 2
        //7,2
        //4, 4, 4, 4
        //4, 4, 4, 4,4
        //1000, 1, 1, 1
        //2, 2, 3, 3
        //10, 4, 2, 1
        //3, 1, 1, 1
        System.out.println(lastStoneWeight(new int[]{3, 1, 1, 1}));
    }

    //2,7,4,1,8,1
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones) {
            pq.offer(stone);
        }
        while(!pq.isEmpty()) {
            int first = pq.poll();
            if(pq.isEmpty())return first;
            int second = pq.poll();
            if(first != second) {
                pq.offer(first-second);
            }
        }
        return 0;
    }
}
