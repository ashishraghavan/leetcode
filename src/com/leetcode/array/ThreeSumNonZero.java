package com.leetcode.array;

import java.util.Arrays;

public class ThreeSumNonZero {
    public static void main(String[] args) {
        int d = 0;
        int[] A = new int[]{-1,0,1,2,-1,-4};
        Arrays.sort(A);//[-4, -1, -1, 0, 1, 2]
        int a,b,c;
        //required sum of A[b] + A[c] because we are going by A[a] + A[b] + A[c] = d ==> A[b] + A[c] = d - A[a];
        int r;
        for (a = 0; a <= A.length - 3; a++) {
            b = a + 1;
            c = A.length - 1;
            r = d - A[a];
            while (b < c) {
                if (A[b] + A[c] == r) {
                    System.out.println("required values are : ["+A[a]+", "+A[b]+", "+A[c]+"] and indexes - "+a+", "+b+" and "+c);
                    b++;
                } else if (A[b] + A[c] < r) {
                    b++;
                } else {
                    c--;
                }
            }
        }
    }
}
