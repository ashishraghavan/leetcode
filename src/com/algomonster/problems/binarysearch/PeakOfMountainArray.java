package com.algomonster.problems.binarysearch;

import java.util.List;

public class PeakOfMountainArray {
    public static void main(String[] args) {
        //[1, 2, 3, 4, 5, 6, 5, 4, 3]
        //[1, 2, 3, 4, 5, 4]
        //[1, 2, 3, 10, 9, 8, 7]
        //[5, 10, 15, 20, 25, 20, 15]
        //[1, 3, 5, 7, 9, 11, 10, 8, 6]
        //[1, 2, 3, 50, 40, 30, 20, 10]
        System.out.println(peakOfMountainArray(List.of(1, 2, 3, 50, 40, 30, 20, 10)));
    }

    //1, 2, 3, 4, 5, 6, 5, 4, 3
    //if start = 1, end = arr.size()-2, then problem is about finding maximum index (maxIdx) in arr[start,end]
    // & checking if arr[start,maxIdx] < arr[maxIdx] > arr[maxIdx+1,end]

    //1, 2, 3, 4, 5, 6, 5, 4, 3 -> [2, 3, 4, 5, 6, 5, 4]
    //TODO: this comes under binary search but using BS is very non-intuitive. So used below solution
    public static int peakOfMountainArray(List<Integer> arr) {
        int start = 1,end = arr.size()-2;
        int idx = -1,max=Integer.MIN_VALUE;
        for(;start <= end;start++) {
            if(arr.get(start) > max) {
                max = arr.get(start);
                idx = start;
            }
        }
        return idx;
    }
}
