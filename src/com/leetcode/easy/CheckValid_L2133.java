package com.leetcode.easy;

import java.util.Arrays;

//problem # 2133 - check if every row & column contains all numbers
//check https://github.com/doocs/leetcode/tree/main/solution/2100-2199/2133.Check%20if%20Every%20Row%20and%20Column%20Contains%20All%20Numbers for github solution
public class CheckValid_L2133 {
    public static void main(String[] args) {
        //{1,2,3},{3,1,2},{2,3,1}
        //{1,1,1},{1,2,3},{1,2,3}
        //{2,2,2},{2,2,2},{2,2,2} - failing test case
        System.out.println(checkValidII(new int[][]{{2,2,2},{2,2,2},{2,2,2}}));
    }

    //[1,2,3],[3,1,2],[2,3,1], n=3 = matrix.length should contain 1:matrix.length valued elements
    //sum = n*(n+1)/2 = 6 //each row & column iteration,
    //trk = new int[n] {0,0,0} after 1st row iteration, E(trk) = 3, after 2nd row iteration, E(trk) = 6, after 3rd row iteration, E(trk) = 9
    //iterate i in (0,n-1) :: iterate j in (0,n-1) : E[i,j] != sum return false
    //attempt #1
    public static boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        int sum = (n*(n+1))/2;
        int[] trk = new int[matrix.length];
        int currSum;
        //row sum
        for (int[] ints : matrix) {
            currSum = 0;
            for (int j = 0; j < n; j++) {
                currSum += ints[j];
            }
            if (currSum != sum) return false;
        }

        //column sum
        for(int i=0;i<n;i++) {
            currSum = 0;
            for (int[] ints : matrix) {
                currSum += ints[i];
            }
            if(currSum != sum)return false;
        }
        return true;
    }

    //attempt #2
    public static boolean checkValidII(int[][] matrix) {
        int n = matrix.length;
        int[] trk = new int[matrix.length];

        //row comp.
        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                trk[matrix[i][j]-1]++;
            }
            if(!isValid(trk,i+1))return false;
        }

        Arrays.fill(trk,0);
        //column comp.
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                trk[matrix[j][i]-1]++;
            }
            if(!isValid(trk,i+1))return false;
        }
        return true;
    }

    public static boolean isValid(int[] trk,int val) {
        for (int i : trk) {
            if (i != val) return false;
        }
        return true;
    }
}
