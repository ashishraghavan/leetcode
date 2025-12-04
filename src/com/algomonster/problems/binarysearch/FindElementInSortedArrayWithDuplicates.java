package com.algomonster.problems.binarysearch;

import java.util.Arrays;
import java.util.List;

public class FindElementInSortedArrayWithDuplicates {
    public static void main(String[] args) {
        //1, 3, 3, 3, 3, 6, 10, 10, 10, 100 | 3
        //2, 3, 5, 7, 11, 13, 17, 19 | 6

        //[1, 2, 2, 2, 2, 2, 2, 3] 2
        //[1, 2, 3, 4, 5, 6, 7, 8, 9] 9
        //[1, 2, 4, 4, 4, 5, 6] 7
        System.out.println(findFirstOccurrence(Arrays.asList(1, 2, 4, 4, 4, 5, 6),4));
    }

    //1, 3, 3, 3, 3, 6, 10, 10, 10, 100 | 3
    //2, 3, 5, 7, 11, 13, 17, 19 | 6
    public static int findFirstOccurrence(List<Integer> arr, int target) {
        int start =0, end = arr.size()-1,boundaryIdx = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr.get(mid)==target) {
                boundaryIdx = mid;
                end = mid-1;
            } else if(arr.get(mid) > target) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return boundaryIdx;
    }
}
