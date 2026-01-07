package com.algomonster.problems.twopointers_or_sliding_window;

import java.util.Arrays;
import java.util.List;

public class RemoveDuplicates {
    //0, 0, 1, 1, 1, 2, 2
    public static void main(String[] args) {
        //[1, 1, 2, 3, 3, 4, 4, 5]
        //[1, 2, 2, 3, 4, 4, 5, 6, 6]
        System.out.println(removeDuplicates(Arrays.asList(1, 2, 2, 3, 4, 4, 5, 6, 6)));
    }

    //0, 0, 1, 1, 1, 2, 2
    //f=0,s=1 -> f=1,s=2 -> 0,1,1,1,1,2,2 -> f=2,s=3,4,5
    public static int removeDuplicates(List<Integer> arr) {
        int f = 0,s = 0;
        while(s < arr.size()) {
            if(!arr.get(s).equals(arr.get(f))) {
                f++;
                arr.set(f,arr.get(s));
            }
            s++;
        }
        return f+1;
    }
}
