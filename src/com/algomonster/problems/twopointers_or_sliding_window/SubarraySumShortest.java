package com.algomonster.problems.twopointers;

import java.util.Arrays;
import java.util.List;

//TODO: good problem, [revise],
// refer C:\Users\ashish\OneDrive\Documents\dev-notes\java-class-template - flexible size sliding window template - shortest
// for template used to solve this problem
public class SubarraySumShortest {
    public static void main(String[] args) {
        //[1, 4, 1, 7, 3, 0, 2, 5], 10
        //[10,2,3], 6
        //[4,2,1,7,8,1,2,8,10], 8
        //[1,1,1,1,1,1,1], 3
        //[100,200,300], 250
        //[100,200,300], 600
        //[1,2,3,4,5,6,7,8,9,10], 19
        System.out.println(subarraySumShortest(Arrays.asList(100,200,300),600));
    }

    //1, 4, 1, 7, 3, 0, 2, 5 | 10
    public static int subarraySumShortest(List<Integer> l, int t) {
        int left=0,right=0,sum=0,minLen = Integer.MAX_VALUE;
        for(;right < l.size();right++) {
            sum += l.get(right);
            if(sum >= t) {
                //minLen = Math.min(minLen,right-left+1);
                while(sum - l.get(left) >= t) {
                    sum -= l.get(left);
                    left++;
                }
                minLen = Math.min(minLen,right-left+1);
            }
        }
        return minLen;
    }
}
