package com.leetcode.medium.binarysearch_on_sorted_data;

import java.util.Arrays;

//#34 - https://share.gemini.google/8llFmQB8whkL
public class FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        //5,7,7,8,8,10|8
        //5,7,7,8,8,10|6
        //2, 2, 2, 2, 2|2
        //3, 3, 3, 5, 5, 6|3
        //1, 2, 4, 4, 4|4
        //2, 3, 5, 7|1
        //2, 3, 5, 7|9
        System.out.println(Arrays.toString(searchRange(new int[]{2, 3, 5, 7},9)));
    }

    //5,7,7,8,8,10  target=8
    //m=A.len/2=3, A[3]<=t {if(A[3]==t)go right => A[3,A.length-1] else go left => A[0,]
    //compare last element of left & first element of right with target
    public static int[] searchRange(int[] A, int t) {
        int[] result = new int[]{-1,-1};
        if(A.length == 0)return result;
        result[0] = findBoundary(A,t,true);
        result[1] = findBoundary(A,t,false);
        return result;
    }

    //5,7,7,8,8,10  target=8
    public static int findBoundary(int[] A,int t,boolean isLeft) {
        int left = 0,right = A.length-1;
        int mid,bound=-1;
        while(left <= right) {
            mid = left + (right - left)/2;
            if(A[mid] == t) {
                bound = mid;
                if(isLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if(A[mid] < t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }
}
