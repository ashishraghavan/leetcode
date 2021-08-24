package com.leetcode.array;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 */
public class MonotonicArray {
    public static void main(String[] args) {
        //1,2,2,3,5,6,7,0
        //6,5,4,4
        //1,2,4,5
        //1,1,0
        System.out.println(isMonotonic(new int[]{1,1}));
    }

    static boolean isMonotonic(int[] arr) {
        if(arr.length < 2) {
            return true;
        }
        int a = arr[0];
        int b = arr[1];
        int i=0;
        if(a==b) {
            //get index where a != b
            while((i+2 < arr.length) && a==b) {
                a=arr[i+1];
                b=arr[i+2];
                i++;
            }
        } else {
            i=2;
        }
        if(a<=b) {
            //increasing monotone
            for(;i<arr.length;i++) {
                if(arr[i-1] > arr[i]) {
                    return false;
                }
            }
        } else {
            //decreasing monotone
            for(;i<arr.length;i++) {
                if(arr[i-1] < arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}
