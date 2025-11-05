package com.leetcode.medium.array_strings;

import java.util.Arrays;

//see rearrangeArrayII for optimized solution
//prob #2149 - rearrange array elements by sign
public class RearrangeArrayElementsBySign_L2149 {
    public static void main(String[] args) {
        //3,1,-2,-5,2,-4
        //-1.0
        rearrangeArrayII(new int[]{-1,-4,-10,2,1,8});
        //System.out.println(Arrays.toString());
    }

    //3,1,-2,-5,2,-4 -> 3,-2,1,-5,2,-4
    //AA[] = 3,-2,1,-5,2,-4
    //if A[0] < 0 start from 0 else start from 1
    //-1,-4,-10,2,1,8
    //AA[] = 2,-1,1,-4,0,-10
    public static int[] rearrangeArray(int[] A) {
        if(A.length == 2){
            if(A[0] < 0)swap(A,0,1);
            return A;
        }
        boolean pos = A[0] > 0;
        int[] res = new int[A.length];
        int i=0,j=0;
        if(pos){
            res[0] = A[0];
            i++;
            j+=2;
        }
        for(;i<A.length;i++) {
            if(A[i] > 0) {
                res[j] = A[i];
                j+=2;
            }
        }
        int k = 1;
        for (int value : A) {
            if (value < 0) {
                res[k] = value;
                k += 2;
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void swap(int[] A,int a,int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    ////my optimized solution
    public static int[] rearrangeArrayII(int[] A) {
        int posCnt = 0,negCnt=1;
        int[] B = new int[A.length];
        for (int j : A) {
            if (j > 0) {
                B[posCnt] = j;
                posCnt += 2;
            } else {
                B[negCnt] = j;
                negCnt += 2;
            }
        }
        System.out.println(Arrays.toString(B));
        return B;
    }
}
