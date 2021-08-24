package com.leetcode.array;

//{1,2,3,4},
//{5,1,2,3},
//{9,5,1,2}
public class ToeplitzMatrix {
    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{
                {1,2},
                {2,1},
                {3,2}}));
    }

    //(row==0 && column == matrix.length-1)
    /*if((row == matrix.length -1 && column==0)) {
                continue;
            }*/
    static boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        //If there is only one element in the matrix
        if(rows <= 1 || columns <= 1) {
            return true;
        }
        for(int row = 0;row < rows;row++) {
            for(int column=0;column<columns;column++) {
                int value = matrix[row][column];
                int i=row+1;
                int j=column+1;
                while(i<rows && j<columns) {
                    if(matrix[i][j] != value) {
                        return false;
                    }
                    i++;
                    j++;
                }
            }
        }
        return true;
    }
}
