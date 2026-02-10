package com.algomonster.problems.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//https://algo.monster/problems/kth_largest_element_in_an_array
//use a size limited priority queue to find kth largest or smallest element in an array
//TODO: [revise] read & properly understand method - findKthLargestII(..) & class - SizeLimitedPriorityQueue to write optimized solution
public class KthLargestElementInArray {
    public static void main(String[] args) {
        //[3,2,3,1,2,4,5,5,6], 4
        //[3,2,1,5,6,4],2
        //[10,20,30,40,50],3
        //[100,200,300,400,500],4
        //[9,-9,0,-1,8],3
        //[5,2,8,2,1,9],3
        System.out.println(findKthLargestII(Arrays.asList(3,2,3,1,2,4,5,5,6),4));
        //findKthLargestII(Arrays.asList(3,2,3,1,2,4,5,5,6),4);
    }

    //[3,2,3,1,2,4,5,5,6], 4
    //1,2,2,3,3,4,5,5,6
    //priorityQueue with Comparator.reverseOrder()
    //set x=k, while(x>1)pq.poll();
    //return pq.poll()
    //using O(logn) time, O(n) space
    public static int findKthLargest(List<Integer> nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.size(), Comparator.reverseOrder());
        for(Integer elem : nums) {
            pq.offer(elem);
        }
        int x = k;
        while(x > 1) {
            pq.poll();
            x--;
        }
        return pq.poll();
    }

    //[3,2,3,1,2,4,5,5,6], 4
    //code using size limited priority queue
    public static int findKthLargestII(List<Integer> nums, int k) {
        SizeLimitedPriorityQueue<Integer> spq = new SizeLimitedPriorityQueue<>(Comparator.naturalOrder(),k);
        for(Integer elem : nums) {
            spq.add(elem);
        }
//        while(!pq.isEmpty()) {
//            System.out.print(pq.poll()+" ");
//        }
        return spq.poll();
    }

    static class LimitPriorityQueue<T> {
        private final PriorityQueue<T> pq;
        private final int limit;

        public LimitPriorityQueue(int limit,Comparator<? super T> comparator) {
            this.limit = limit;
            this.pq = new PriorityQueue<>(comparator);
        }

        public void add(T element) {
            if(pq.size()<limit) {
                pq.add(element);
            } else if(pq.comparator().compare(element,pq.peek()) > 0) {
                pq.poll();
                pq.offer(element);
            }
        }

        public int size() {
            return pq.size();
        }

        public T poll() {
            return pq.poll();
        }

        public boolean isEmpty() {
            return pq.isEmpty();
        }
    }

    static class SizeLimitedPriorityQueue<T> {
        final PriorityQueue<T> pq;
        final int limit;

        public SizeLimitedPriorityQueue(Comparator<? super T> comparator,int limit) {
            this.pq = new PriorityQueue<>(comparator);
            this.limit = limit;
        }

        public void add(T element) {
            //if size < limit, safely add element to queue
            if(pq.size() < limit) {
                pq.offer(element);
            } else if(pq.comparator().compare(element,pq.peek()) > 0) {
                pq.poll();
                pq.offer(element);
            }
        }

        public int size() {
            return pq.size();
        }

        public boolean isEmpty() {
            return pq.isEmpty();
        }

        public T poll() {
            return pq.poll();
        }
    }
}
