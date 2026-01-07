package com.algomonster.problems.twopointers_or_sliding_window;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        //1,2,1
        //0,1,2,2
        //1,2,3,2,2
        //1,2,1,2,1,2,1,2,1,2,3
        //[1,2,3,2,2,3,3,3,2,2,1]
        //[1,2,1,2,3,4,5,6,7,8]
        //[1,2,3,4,5,6,7,8,9]
        //[5,5,5,5,5]
        //[1,2,1,2,1,2,3,3,3,3,3] - Y
        //[1,2,3,4,4,4,3,3,2,2,1]
        //[1,2,1,2,3,3,4,4,5,5]
        //[1,2,3,2,2,1,1,1,3]
        //[3,3,3,1,2,1,1,2,3,3,4]
        //[1,2,1,3,4,3,5,1,2]
        //[1,2,3,2,1]
        //[1,1,1,1]
        //[1,2,3,4,5]
        //[1,2,1,2,1,2]
        //[1,2,3,2,2]
        //[1,2,1]
        //[1,2,3]
        //[1,2]
        //[1]
        System.out.println(maxFruits(new int[]{1}));
    }

    //1,2,3,2,2
    //need
    public static int maxFruits(int[] F) {
        int i=0,mx=Integer.MIN_VALUE;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int j=0;j<F.length;j++) {
            mp.put(F[j],mp.getOrDefault(F[j],0)+1);
            while(mp.size() > 2) {
                mp.put(F[i],mp.get(F[i])-1);
                if(mp.get(F[i]) <= 0)mp.remove(F[i]);
                i++;
            }
            mx = Math.max(mx,j-i+1);
        }
        return mx;
    }
}
