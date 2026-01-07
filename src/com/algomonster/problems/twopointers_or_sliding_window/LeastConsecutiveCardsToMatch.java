package com.algomonster.problems.twopointers_or_sliding_window;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeastConsecutiveCardsToMatch {
    public static void main(String[] args) {
        //3, 4, 2, 3, 4, 7
        //[1,2,3,4,5,6,7,8,1]
        //[1,2,3,4,5]
        //1,2,3,1
        //[1,2,3,2]
        //[7,7,7]
        //[1,2,1,2,1]
        //[10,20,30,40,20]
        //[1,2,3,4,2,5]
        //[1,1,2,2,3,3]
        //[9,8,7,6,5,9]
        //[9,8,7,6,5,8]
        //[1,2,3,4,5,6,7,8,9,10]
        //[100,200,300,100,200,300,100]
        //[42,42,42,42,42]
        System.out.println(leastConsecutiveCardsToMatch(Arrays.asList(42,42,42,42,42)));
    }

    //1,2,3,2
    public static int leastConsecutiveCardsToMatch(List<Integer> c) {
        int left = 0,minLen = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int right = 0; right<c.size(); right++) {
            if(set.contains(c.get(right))) {
                while(set.contains(c.get(right))) {
                    minLen = Math.min(minLen,right-left+1);
                    set.remove(c.get(left));
                    left++;
                }
            }
            set.add(c.get(right));
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
