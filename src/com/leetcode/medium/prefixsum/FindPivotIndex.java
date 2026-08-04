package com.leetcode.medium.prefixsum;

import java.util.Arrays;

//#724
public class FindPivotIndex {
    public static void main(String[] args) {
        //1,7,3,6,5,6
        //1,2,3
        //2,1,-1
        //-1, 1, 2
        //0
        //0, 0, 0, 0, 0
        //1, -1, 2, -1, 1
        //-1, -2, -3, -3
        //1, 1, 1, 1, 1, 1
        //-5, -3, 2, -4, -4
        System.out.println(pivotIndexUpdated(new int[]{1, -1, 2, -1, 1}));
    }

    //1,7,3,6,5,6
    //left=[0,1,8,11,17,22]
    //right=[27,20,17,11,6,0] return first index where left[i]==right[i]
    public static int pivotIndex(int[] A) {
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        for(int i=1;i<A.length;i++) {
            left[i] = left[i-1] + A[i-1];
        }
        for(int j=A.length-2;j>=0;j--) {
            right[j] = right[j+1] + A[j+1];
        }
        for(int k=0;k<left.length;k++) {
            if(left[k]==right[k]) return k;
        }
        return -1;
    }

    //1,7,3,6,5,6
    //leftSum=[0,1,8,11,17,22]
    public static int pivotIndexUpdated(int[] A) {
        int sum=0,leftSum=0,rightSum;
        for (int j : A) {
            sum += j;
        }
        //beginning of each run, leftSum should be equal to sum of A[i...i-1](inclusive)
        for(int i=0;i<A.length;i++) {
            rightSum = sum - leftSum - A[i];
            if(leftSum == rightSum)return i;
            leftSum+=A[i];
        }
        return -1;
    }
}
