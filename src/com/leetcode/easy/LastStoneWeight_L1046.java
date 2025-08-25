package com.leetcode.easy;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

//TODO: solved but definitely [revise]
//prob # 1046 - last stone weight
public class LastStoneWeight_L1046 {
    public static void main(String[] args) {
        //2,7,4,1,8,1
        //1
        //8, 32, 19, 41, 34, 20, 5, 5, 48, 46, 48, 28, 12, 43, 40, 39, 8, 21, 12, 29, 15, 41, 19, 44, 21
        //System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println(lastStoneWeight(new int[]{8, 32, 19, 41, 34, 20, 5, 5, 48, 46, 48, 28, 12, 43, 40, 39, 8, 21, 12, 29, 15, 41, 19, 44, 21}));
    }

    //2,7,4,1,8,1 -sort-> 1,1,2,4,7,8 -> 1,1,2,4,1,X => 1,1,2,4,1 -sort-> 1,1,1,2,4 -> 1,1,1,2,X => 1,1,1,2 -sort-> 1,1,1,2 -> 1,1,1,X => 1,1,1 -sort-> 1,1,1 -> 1 return 1
    //need a DS which keeps its elements in sorted order - PriorityQueue
    public static int lastStoneWeight(int[] stones) {
        if(stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : stones) {
            queue.offer(num);
        }
        while(queue.size() > 1) {
            Integer y = queue.poll();
            Integer x = queue.poll();
            if(!Objects.equals(x,y)) {
                queue.offer(y-x);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }

    //2,7,4,1,8,1 -> 8,7,4,2,1,1 -> X,1,4,2,1,1 -> 4,2,1,1,1 -> X,2,1,1,1 -> 2,1,1,1 -> X,1,1,1 -> 1,1,1 -> X,X,1
    public static void priorityQueueUsage(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : stones) {
            queue.offer(num);
        }
        while(queue.size() > 1) {
            Integer y = queue.poll();
            Integer x = queue.poll();
            if(!Objects.equals(x,y)) {
                queue.offer(y-x);
            }
        }
        System.out.println(queue.poll());

//        while(!queue.isEmpty()) {
//            System.out.println(queue.poll());
//        }
    }
}
