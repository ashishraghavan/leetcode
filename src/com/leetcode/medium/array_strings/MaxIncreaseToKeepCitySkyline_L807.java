package com.leetcode.medium.array_strings;

//TODO: working solution but figure out a less complex way
//prob #807 - max increase to keep city skyline
public class MaxIncreaseToKeepCitySkyline_L807 {
    public static void main(String[] args) {
        //[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]
        System.out.println(maxIncreaseKeepingSkyline(new int[][]{
                {3,0,8,4},
                {2,4,5,7},
                {9,2,6,3},
                {0,3,1,0}
        }));
    }

    //max row
    //{3,0,8,4}         {3,3,8,8}
    //{2,4,5,7}     ->  {2,4,5,7}
    //{9,2,6,3}         {9,9,9,9}
    //{0,3,1,0}         {0,3,3,3}

    //max column
    //{3,0,8,4}         {3,0,8,4}
    //{2,4,5,7}     ->  {3,4,8,7}
    //{9,2,6,3}         {9,4,8,7}
    //{0,3,1,0}         {9,4,8,7}

    //{8,4,8,7}
    //{7,4,7,7}
    //{9,4,8,7}
    //{3,3,3,3}
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int sum = 0;
        int[][] pfSumRow = new int[r][c];
        int[][] pfSumCol = new int[r][c];
        for(int i=0;i<r;i++) {
            int max = grid[i][0];
            for(int j=0;j<c;j++) {
                max = Math.max(max,grid[i][j]);
                pfSumRow[i][j] = max;
            }
        }
        for(int i=0;i<r;i++) {
            int max = grid[0][i];
            for(int j=0;j<c;j++) {
                max = Math.max(max,grid[j][i]);
                pfSumCol[j][i] = max;
            }
        }
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                int val = Math.min(pfSumRow[i][c-1],pfSumCol[r-1][j]);
                if(val != grid[i][j]) {
                    sum += Math.abs(val-grid[i][j]);
                }
            }
        }
        return sum;
    }

    public static void print(int[][] A) {
        for (int[] ints : A) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(ints[j] + "\t");
            }
            System.out.println();
        }
    }
}
