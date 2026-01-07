package com.algomonster.problems.twopointers;

import java.util.Arrays;

//leetcode problem #2161 - partition array according to given pivot
public class PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {
        //9,12,5,10,14,3,10
        //[2,10,2,10,2],10
        //[1,2,3,4,5,6,7,8,9],1
        //[1,2,3,4,5,6,7,8,9],9
        //[7,5,7,5,7,5],5
        //[0,-1,-2,3,2,1],0
        //[5,5,5,5,5,5,5],5
        //[5,4,3,2,1],3
        //
        System.out.println(Arrays.toString(pivotArrayII(new int[]{9,12,5,10,14,3,10},10)));
    }

    //[9,12,5,10,14,3,10] -> [9,5,3,10,10,12,14]
    //B=[9,5,3],cnt=3,lastIdx=6,
    public static int[] pivotArray(int[] A, int p) {
        int[] B = new int[A.length];
        int cnt = 0;
        for(int i=0;i<A.length;i++) {
            if(A[i] < p) {
                B[cnt++] = A[i];
                A[i]=Integer.MIN_VALUE;
            }
        }

        int lastIdx=B.length-1;
        for(int i=A.length-1;i>=0;i--) {
            if(A[i]==Integer.MIN_VALUE)continue;
            else if(A[i] == p) {
                B[cnt++] = p;
            } else {
                B[lastIdx--] = A[i];
            }
        }
        return B;
    }

    //[9,12,5,10,14,3,10] -> [9,5,3,10,10,12,14]
    //9,5,12,10,14,3,10
    //9,5,3,10,14,12,10
    //9,5,3,10,10,12,14

    //[9,12,5,10,14,3,10]
    //[9,3,5,10,14,12,10]
    public static int[] pivotArrayII(int[] A, int p) {
        int pIdx=-1;
        for(int first=0,last=0;last<A.length;last++) {
            if(A[first] == p || A[last] == p){
//                pIdx=first;
//                first++;
                if(A[first]==p)first++;
                else continue;
            }
            if(A[first] < p) {
                first++;
            } else {
                if(A[last] < p) {
                    swap(A,first,last);
                    first++;
                }
            }
        }
        return A;
    }

    public static void swap(int[] A,int i,int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
