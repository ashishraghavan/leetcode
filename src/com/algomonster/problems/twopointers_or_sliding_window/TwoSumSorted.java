package com.algomonster.problems.twopointers_or_sliding_window;

import java.util.Arrays;
import java.util.List;

public class TwoSumSorted {
    public static void main(String[] args) {
        //2, 3, 4, 5, 8, 11, 18
        //[2, 3, 4, 6, 8, 11]
        System.out.println(twoSumSorted(Arrays.asList(2, 3, 4, 6, 8, 11),20));
    }

    public static List<Integer> twoSumSorted(List<Integer> arr, int target) {
        int f = 0,l = arr.size()-1,sum;
        while(f < l) {
            sum = arr.get(f) + arr.get(l);
            if(sum == target)return List.of(f,l);
            else if(sum < target) {
                f++;
            } else {
                l--;
            }
        }
        return List.of();
    }
}
