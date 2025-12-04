package com.algomonster.problems.binarysearch;

import java.util.Arrays;
import java.util.List;

public class FirstTrueInSortedBooleanArray {
    public static void main(String[] args) {
        List<Boolean> list = Arrays.asList(false,false,true,true,true);
        System.out.println(boundaryII(list,0,list.size()-1));
    }

    public static int boundary(List<Boolean> A, int start, int end) {
        while(start <= end) {
            if(start==end)return A.get(start) ? start : -1;
            int mid = start + (end - start)/2;
            if(A.get(mid)) {
                //if A[mid]=true, this might be the first occurrence or
                //there can be an earlier occurrence than this
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return -1;
    }

    public static int boundaryII(List<Boolean> A, int start, int end) {
        int boundaryIdx = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(A.get(mid)) {
                boundaryIdx = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return boundaryIdx;
    }
}
