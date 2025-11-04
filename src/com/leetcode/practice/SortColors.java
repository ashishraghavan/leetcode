package com.leetcode.practice;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        //2,0,2,1,1,0
        //1,0,2,2,2,1,0,0,0,0,1,0,1,0,2,0,2,1,1,0
        //2,2,1
        sortColors(new int[]{2,2,1});
        //System.out.println(Arrays.toString());
    }

    //2,0,2,1,1,0 -> 0,0,2,1,1,2 -> 0,0,1,1,2,2
    //(left,right) = (2,0|1), (2,2), (0|1,2),(0|1,0|1)
    public static int[] sortColors(int[] A) {
        int left = 0, right = A.length-1;
        while(left < right) {
            if(A[left] == 2) {
                if(A[right] == 2)right--;
                else {
                    swap(A,left,right);
                    left++;
                    right--;
                }
            } else {
                if(A[right] == 2)right--;
                else left++;
            }
        }
        System.out.println("right = "+right);
        System.out.println("Before swapping 0,1 from start : "+Arrays.toString(A));
        left = 0;
        if(A[right]==2)right--;
        //(0,1),(0,0),(1,0),(1,1)
        while(left < right) {
            if(A[right]==1)right--;
            else {
                if(A[left]==1) {
                    swap(A,left,right);
                    left++;
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(Arrays.toString(A));
        return A;
    }

    public static void swap(int[] A,int a,int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
