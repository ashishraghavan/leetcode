package com.leetcode.medium.binarysearch_on_sorted_data;

public class BinarySearch {
    public static void main(String[] args) {
        //-1,0,3,5,9,12|9
        //0,1|0
        //10, 20, 30, 40|50
        //1, 3, 5, 7, 9|9
        //2, 5, 8, 12, 16, 23, 38|12
        //-1, 0, 3, 5, 9, 12|-2
        //5|5
        //5|-5
        //1,3|3
        System.out.println(search(new int[]{1,3},3));
    }

    //-1,0,3,5,9,12
    public static int search(int[] A, int t) {
        int left=0,right=A.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(A[mid]==t)return mid;
            else if(A[mid] < t) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
