package com.algomonster.problems.twopointers_or_sliding_window;

import java.util.Arrays;
import java.util.List;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        //1,8,6,2,5,4,8,3,7
        //[10,9,8,7,6,5,4,3,2,1]
        //[1,2,3,4,3,2,1]
        System.out.println(containerWithMostWater(Arrays.asList(1,2,3,4,3,2,1)));
    }

    //1,8,6,2,5,4,8,3,7
    //[10,9,8,7,6,5,4,3,2,1]
    //area = min(arr.get(f),arr.get(l)) * Math.abs(f-l)
    //1,2,3,4,3,2,1
    public static int containerWithMostWater(List<Integer> arr) {
        int f = 0, l = arr.size() - 1;
        int area = Integer.MIN_VALUE;
        while(f < l) {
            area = Math.max(area,Math.min(arr.get(f),arr.get(l)) * (l-f));
            if(arr.get(f) <= arr.get(l)) {
                f++;
            } else {
                l--;
            }
        }
        return area;
    }
}
