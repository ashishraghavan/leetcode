package com.leetcode.easy;

@SuppressWarnings("ForLoopReplaceableByForEach")
public class FlippingAnImage {

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void flipAndInvertImage(int[][] array) {
        //Flip the matrix first
        reverse(flip(array));
    }

    private static int[][] flip(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            //1,1,0
            int[] row = matrix[i];
            int start = 0;
            int end = row.length - 1;
            while (end >= start) {
                swap(start++, end--, row);
            }
            matrix[i] = row;
        }
        return matrix;
    }

    private static void swap(int indexA, int indexB, int[] matrix) {
        int temp = matrix[indexA];
        matrix[indexA] = matrix[indexB];
        matrix[indexB] = temp;
    }

    private static void reverse(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 1;
                } else if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
