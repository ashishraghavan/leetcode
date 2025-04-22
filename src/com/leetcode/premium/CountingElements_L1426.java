package com.leetcode.premium;

import java.util.Arrays;

//problem # 1426
//check https://github.com/doocs/leetcode/blob/main/solution/1400-1499/1426.Counting%20Elements/README_EN.md
//for
//more
//details
//TODO: review
public class CountingElements_L1426 {
    public static void main(String[] args) {
        //1,1,3,3,5,5,7,7
        //1,2,3
        //2,0,7,9,8,3,10,5,4,2,1,3 = 10
        System.out.println(countElements(new int[]{2,0,7,9,8,3,10,5,4,2,1,3}));
    }

    public static int countElements(int[] A) {
        //sort
        Arrays.sort(A);
        int[] aCt = new int[A[A.length-1]+1]; //initialized with 0
        for (int j : A) {
            ++aCt[j];
        }
        int res = 0;
        for(int k : A) {
            if(k+1 < aCt.length && aCt[k+1] > 0) {
                res++;
            }
        }
        return res;
//        System.out.println(Arrays.toString(aCt));
//        return -1;
    }
}
