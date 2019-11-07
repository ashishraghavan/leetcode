package com.leetcode.easy.array;

/**
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 *
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
 *
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 *
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 */
//{1,2,3},{4,5,6},{7,8,9}
public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] reshapedMatrix = matrixReshape(new int[][]{{1,2},{3,4}},2,4);
        for(int i=0;i<reshapedMatrix.length;i++) {
            for(int j=0;j<reshapedMatrix[0].length;j++) {
                System.out.print(reshapedMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    static int[][] matrixReshape(int[][] nums, int r, int c) {
        int rows = nums.length;
        int columns = nums[0].length;
        if((rows*columns) != (r*c)) {
            return nums;
        }
        int[] rowTraversalArray = new int[rows*columns];
        int count = 0;
        for (int[] num : nums) {
            for (int i : num) {
                rowTraversalArray[count++] = i;
            }
        }
        int[][] reshapedMatrix = new int[r][c];
        count =0;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                reshapedMatrix[i][j] = rowTraversalArray[count++];
            }
        }
        return reshapedMatrix;
    }
}
