package com.leetcode.medium.binarysearch_on_sorted_data;

//#153 - https://share.gemini.google/ZjmpEkemDsDg
public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        //3,4,5,1,2
        //4,5,6,7,0,1,2
        //11,13,15,17
        //1
        //2,1
        //1,2
        //5, 1, 2, 3, 4
        //2, 3, 4, 5, 1
        //-2, -1, -5, -4, -3
        //100, 200, 300, 400, 500, 600, 10
        System.out.println(findMin(new int[]{-2, -1, -5, -4, -3}));
    }

    //3,4,5,1,2 <= 1,2,3,4,5
    //11,13,15,17
    //mid=left+(right-left)/2, if A[mid] > A[A.length-1] go right else go left
    //-2, -1, -5, -4, -3
    public static int findMin(int[] A) {
        int left = 0,right = A.length-1;
        int mid;
        while(left < right) {
            mid = left + (right - left)/2;
            if(A[mid] > A[right]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return A[left];
    }
}
