package com.leetcode.premium;

//problem # 1099
//check https://github.com/doocs/leetcode/tree/main/solution/1000-1099/1099.Two%20Sum%20Less%20Than%20K
//for
//more
//details
//TODO: review
public class TwoSumLessThanTarget_L1099 {
    public static void main(String[] args) {
        //34,23,1,24,75,33,54,8 | 60
        //10,20,30 | 15
        //35,6,20,25,33,9,54,29,65 | 90
        System.out.println(twoSumLessThanK(new int[]{35,6,20,25,33,9,54,29,65},90));
    }

    //solution with runtime O(n^2) where n = A.length
    public static int twoSumLessThanK(int[] A,int K) {
        int diff = Integer.MAX_VALUE;
        int idx1 = -1, idx2 = -1;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > K)continue;
            int reqSum = K - A[i];
            for(int j = i+1; j < A.length; j++) {
                if (A[j] < reqSum && reqSum - A[j] < diff) {
                    diff = reqSum - A[j];
                    idx1 = i;
                    idx2 = j;
                }
            }
        }
        if(diff == Integer.MAX_VALUE) {
            return -1;
        }
        return A[idx1]+A[idx2];
    }
}
