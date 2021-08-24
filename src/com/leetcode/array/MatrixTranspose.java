package com.leetcode.array;

/**
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 */
public class MatrixTranspose {
    public static void main(String[] args) {
        int[][] transposedmatrix = transpose(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}});
        for (int[] ints : transposedmatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static int[][] transpose(int[][] arr) {
        int rowCount = 0;
        for(int i=0;i<arr.length;i++) {
            rowCount++;
        }
        int rows = rowCount;
        int columns = arr[0].length;
        int[][] transposedMatrix = new int[columns][rows];
        for(int i=0;i<columns;i++) {
            for(int j=0;j<rows;j++) {
                 transposedMatrix[i][j] = arr[j][i];
            }
        }
        return transposedMatrix;
    }

    @SuppressWarnings("unused")
    static void swap(int indexA,int indexB,int[][] matrix) {
        int temp = matrix[indexA][indexB];
        matrix[indexA][indexB] = matrix[indexB][indexA];
        matrix[indexB][indexA] = temp;
    }
}
