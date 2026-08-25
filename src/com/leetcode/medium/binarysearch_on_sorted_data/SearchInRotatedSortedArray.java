package com.leetcode.medium.binarysearch_on_sorted_data;

//#33
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        //4,5,6,7,0,1,2|0
        //2,3,4,5,6,0,1
        System.out.println(searchCorrected(new int[]{2,3,4,5,6,0,1},3));
    }

    //4,5,6,7,0,1,2     t=0
    public static int search(int[] A, int t) {
        int left = 0,right=A.length-1;
        while(left < right) {
            int mid = left + (right-left)/2;
            if(A[mid] == t) {
                return mid;
            }
            else if(A[mid] > A[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return A[left] == t ? left : -1;
    }

    public static int searchCorrected(int[] A, int t) {
        int left=0,right=A.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(A[mid]==t) {
                return mid;
            }
            //check if values in left half are less than value at mid
            else if(A[left] < A[mid]) {
                //check if our target lies in the left half
                if(A[left] <= t && t < A[mid]) {
                    right = mid-1;
                }
                //does our target lie in the right half
                else {
                    left = mid+1;
                }
            }
            //check if values in right half are greater than value at mid
            else {
                //check if our target lies in the right half
                if(A[mid] < t  && t <= A[right]) {
                    left = mid + 1;
                }
                //does our target lie in the left half
                else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
