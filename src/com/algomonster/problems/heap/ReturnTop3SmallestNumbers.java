package com.algomonster.problems.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ReturnTop3SmallestNumbers {
    public static void main(String[] args) {
        //19,7,14,-5,22,41,8,20
        //[-1, -2, -3, -4]
        //[4, 1, 8, 6]
        System.out.println(heapTop3(Arrays.asList(4, 1, 8, 6)));
    }

    //add list into a priority queue with natural ascending order
    //return first 3 elements of priority queue as answer.
    public static List<Integer> heapTop3(List<Integer> list) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Integer elem : list) {
            pq.offer(elem);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=2;i>=0;i--) {
            ans.add(pq.poll());
        }
        return ans;
    }
}
