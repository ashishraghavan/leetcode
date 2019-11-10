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
 *
 * UPDATE : Java two pointer solution found from link https://leetcode.com/problems/fair-candy-swap/discuss/390151/Two-pointers-Java-solution
 */
public class FairCandySwap {
    //new int[]{6,5,8,3},new int[]{7,4,3,6}
    //new int[]{35,17,4,24,10},new int[]{63,21}
    //new int[]{20,35,22,6,13},new int[]{31,57}
    //new int[]{32,38,8,1,9},new int[]{68,92}
    public static void main(String[] args) {
        System.out.println(Arrays.toString(fairCandySwap(new int[]{32,38,8,1,9},new int[]{68,92})));
    }


    static int[] fairCandySwap(int[] alice, int[] bob) {
        int[] answer = new int[2];
        //4,10,17,24,35
        Arrays.sort(alice);
        //21,63
        Arrays.sort(bob);
        int alicePtr = 0;
        int bobPtr = 0;
        int aliceTotal = arraySum(alice);
        int bobTotal = arraySum(bob);
        int average = (aliceTotal + bobTotal)/2;
        while(alicePtr < alice.length && bobPtr < bob.length) {
            int newAvg = aliceTotal - alice[alicePtr] + bob[bobPtr];
            if(newAvg == average) {
                answer[0] = alice[alicePtr];
                answer[1] = bob[bobPtr];
                break;
                } else if(newAvg > average) {
                alicePtr++;
            } else {
                bobPtr++;
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
