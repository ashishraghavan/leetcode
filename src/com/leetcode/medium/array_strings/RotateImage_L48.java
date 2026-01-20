package com.leetcode.medium.array_strings;

//TODO: refer https://www.youtube.com/watch?v=Z0R2u6gd3GU
public class RotateImage_L48 {

    //4.
    //[]->[]
    //[]->[]
    //[]->[]
    public static void main(String[] args) {
        //{1,2,3},{4,5,6},{7,8,9}
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int n = matrix.length;
        rotate(matrix);
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    //[[1,2,3],[4,5,6],[7,8,9]] -> [[7,4,1],[8,5,2],[9,6,3]]
    //1.
    //[0,0]->[0,2]
    //[0,1]->[1,2]
    //[0,2]->[2,2]

    //2.
    //[1,0]->[0,1]
    //[1,1]->[1,1]
    //[1,2]->[2,1]

    //3.
    //[2,0]->[0,0]
    //[2,1]->[1,0]
    //[2,2]->[2,0]

    //approach #2
    //[0,1]->[1,0]
    //[0,2]->[2,0]

    //[1,0]->[0,1]
    //[1,2]->[2,1]

    //[2,0]->[0,2]
    //[2,1]->[1,2]
    public static void rotate(int[][] m) {
        int n = m.length;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                if(i==j)continue;
                swap(m,i,j,j,i);
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0,k=n-1;j<k;j++,k--) {
                swap(m,i,j,i,k);
            }
        }
    }

    public static void swap(int[][] m,int a,int b,int c,int d) {
        int temp = m[a][b];
        m[a][b] = m[c][d];
        m[c][d] = temp;
    }
}
