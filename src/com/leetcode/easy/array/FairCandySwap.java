package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 *
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 *
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 *
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 *
 * Check iPad notes for detailed solution attempt.
 */
public class FairCandySwap {
    //new int[]{6,5,8,3},new int[]{7,4,3,6}
    //new int[]{35,17,4,24,10},new int[]{63,21}
    //new int[]{20,35,22,6,13},new int[]{31,57}
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fairCandySwap(new int[]{20,35,22,6,13},new int[]{31,57})));
    }


    static int[] fairCandySwap(int[] alice, int[] bob) {
        int[] answer = new int[2];
        //4,10,17,24,35
        Arrays.sort(alice);
        //21,63
        Arrays.sort(bob);
        int[] aliceCopy = new int[alice.length];
        int[] bobCopy = new int[bob.length];
        System.arraycopy(alice,0,aliceCopy,0,alice.length);
        System.arraycopy(bob,0,bobCopy,0,bob.length);
        int alicePtr = alice.length-1;
        int bobPtr = bob.length-1;
        int aliceTotal = arraySum(alice);
        int bobTotal = arraySum(bob);
        if(aliceTotal > bobTotal) {
            //find an array element i,j where alice[i] > bob[j]
            while(alicePtr >= 0 && bobPtr >= 0) {
                if(alice[alicePtr] > bob[bobPtr]) {
                    //Replace this value in the array copy
                    aliceCopy[alicePtr] = bob[bobPtr];
                    bobCopy[bobPtr] = alice[alicePtr];
                    if(arraySum(aliceCopy) == arraySum(bobCopy)) {
                        answer[0] = alice[alicePtr];
                        answer[1] = bob[bobPtr];
                        break;
                    }
                }
                alicePtr--;
                bobPtr--;
            }
        } else {
            //find an array element i,j where alice[i] < bob[j]
            while(alicePtr >= 0 && bobPtr >= 0) {
                if(alice[alicePtr] < bob[bobPtr]) {
                    //Replace this value in the array copy
                    aliceCopy[alicePtr] = bob[bobPtr];
                    bobCopy[bobPtr] = alice[alicePtr];
                    if(arraySum(aliceCopy) == arraySum(bobCopy)) {
                        answer[0] = alice[alicePtr];
                        answer[1] = bob[bobPtr];
                        break;
                    }
                }
                alicePtr--;
                bobPtr--;
            }
        }
        return answer;
    }

    static int arraySum(int[] arr) {
        int count = 0;
        for (int value : arr) {
            count += value;
        }
        return count;
    }
}
