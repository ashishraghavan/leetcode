package com.leetcode.medium.monotonic_queue;

import java.util.ArrayDeque;
import java.util.Deque;

//#1438
public class LongestSubarrayWithAbsDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        //8,2,4,7|4
        //new int[]{1, 5, 10, 20}|0
        //new int[]{1, 2, 3, 4, 5}|10
        //new int[]{1, 2, 3, 4, 5}
        //new int[]{5, 4, 3, 2, 1}
        //new int[]{1, 100, 2, 3, 4}|3
        //new int[]{1, 10, 1, 10, 1}|2
        //new int[]{5, 4, 3, 2, 1}|1
        //new int[]{1, 2, 3, 4, 5}|1
        int[] A = new int[]{5, 4, 3, 2, 1};
        int l = 1;
        System.out.println(longestSubarray(A,l));
    }

    //8,2,4,7   l=4
    public static int longestSubarray(int[] A, int l) {
        Deque<Integer> minDQ = new ArrayDeque<>();
        Deque<Integer> maxDQ = new ArrayDeque<>();
        int left=0;
        int max = 0;
        for(int right = 0;right < A.length;right++) {
            //add to minDQ
            while(!minDQ.isEmpty() && minDQ.peekLast() > A[right]) {
                minDQ.removeLast();
            }
            minDQ.offer(A[right]);
            //add to maxDQ
            while(!maxDQ.isEmpty() && maxDQ.peekLast() < A[right]) {
                maxDQ.removeLast();
            }
            maxDQ.offer(A[right]);
            while(maxDQ.peekFirst() - minDQ.peekFirst() > l) {
                if(!minDQ.isEmpty() && minDQ.peekFirst()==A[left]) {
                    minDQ.removeFirst();
                }
                if(!maxDQ.isEmpty() && maxDQ.peekFirst()==A[left]) {
                    maxDQ.removeFirst();
                }
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
