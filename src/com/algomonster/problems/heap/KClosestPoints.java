package com.algomonster.problems.heap;

import java.util.*;

public class KClosestPoints {
    public static void main(String[] args) {
        //[(1, 1), (2, 2), (3, 3)], 1
        System.out.println(kClosestPoints(Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,3),Arrays.asList(2,2)
                ,Arrays.asList(-4,0),Arrays.asList(-2,-4),Arrays.asList(3,1),Arrays.asList(0,4),Arrays.asList(5,7),Arrays.asList(-1,-1)
                ,Arrays.asList(10,-1),Arrays.asList(-9,-1),Arrays.asList(-3,0),Arrays.asList(0,1),Arrays.asList(-6,12),Arrays.asList(6,-12)),3));
    }

    //create class Point with fields x,y, implement compare(Point p1,Point p2) to resolve sorting when used with priority queue
    public static List<List<Integer>> kClosestPoints(List<List<Integer>> points, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(comp);
        for(List<Integer> pt : points) {
            pq.offer(pt);
        }
        //assuming k <= pq.size()
        for(int i=k;i>0;i--) {
            res.add(pq.poll());
        }
        return res;
    }

    static Comparator<List<Integer>> comp = (p1, p2) -> {
        Integer d1 = p1.get(0)*p1.get(0) + p1.get(1) * p1.get(1);
        Integer d2 = p2.get(0)*p2.get(0) + p2.get(1) * p2.get(1);
        return d1.compareTo(d2);
    };
}
