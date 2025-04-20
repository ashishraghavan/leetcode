package com.leetcode.premium;

//problem # 1228
// see https://github.com/doocs/leetcode/blob/main/solution/1200-1299/1228.Missing%20Number%20In%20Arithmetic%20Progression/README_EN.md
// for answer to problem
public class MissingNoInArithmeticProgression_L1228 {
    public static void main(String[] args) {
        //5,7,9,11,13 -> 5,7,11,13
        //15,14,13,12 -> 15,13,12
        //15,14,13,12,11,10 -> 15,14,13,11,10
        //10,12,14,16,18,20 -> 10,14,16,18,20
        //10,6,2 - 6-10 = -4,
        System.out.println(missingNo(new int[]{15,13,12}));
    }

    public static int missingNo(int[] A) {
        int minD = Integer.MAX_VALUE, maxD = Integer.MIN_VALUE;
        for (int i = 1; i <= A.length - 1; i++) {
            minD = Math.min(minD, Math.abs(A[i] - A[i-1]));
            maxD = Math.max(maxD, Math.abs(A[i] - A[i-1]));
        }

        boolean isInc = A[1] > A[0];
        for (int i = 1; i <= A.length - 1; i++) {
            if(Math.abs(A[i] - A[i-1]) == maxD) {
                return isInc ? A[i-1] + minD : A[i] + minD;
            }
        }
        return -1;
    }
}
