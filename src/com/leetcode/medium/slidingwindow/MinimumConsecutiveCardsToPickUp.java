package com.leetcode.medium.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCardsToPickUp {
    public static void main(String[] args) {
        //3,4,2,3,4,7
        //1,0,5,3
        //10, 20, 10, 20, 10
        //7, 7, 7, 7, 7
        System.out.println(minimumCardPickup(new int[]{7, 7, 7, 7, 7}));
    }

    //3,4,2,3,4,7
    public static int minimumCardPickup(int[] cards) {
        Map<Integer,Integer> mp = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i=0;i<cards.length;i++) {
            if(mp.containsKey(cards[i])) {
                int currMin = i - mp.get(cards[i]) + 1;
                min = Math.min(currMin,min);
            }
            mp.put(cards[i],i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
