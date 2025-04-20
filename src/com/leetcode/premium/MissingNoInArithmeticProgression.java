package com.leetcode.premium;

//problem # 1228
public class MissingNoInArithmeticProgression {
    public static void main(String[] args) {
        //5,7,9,11,13 -> 5,7,11,13
        //15,14,13,12 -> 15,13,12
        //15,14,13,12,11,10 -> 15,14,13,11,10
        //10,12,14,16,18,20 -> 10,14,16,18,20
        //10,6,2 - 6-10 = -4,
        System.out.println(missingNo(new int[]{15,13,12}));
    }

    public static int missingNo(int[] A) {
        //i = 0, j = 1
        //diff of A[j]-A[i] == A[j+1]-A[i+1] == A[j+2]-A[i+2]
//        if(A.length == 3) {
//            int diffL = Math.abs(A[1] - A[0]);
//            int diffR = Math.abs(A[2] - A[1]);
//            if(diffL < diffR) {
//                return A[1] + diffL;
//            } else {
//                return A[1] + diffR;
//            }
//        }
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
//        System.out.println("min diff: "+minD);
//        System.out.println("max diff: "+maxD);
        return -1;
    }
}
