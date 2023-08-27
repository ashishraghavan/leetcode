package com.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * #646
 * You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
 *
 * A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
 *
 * Return the length longest chain which can be formed.
 *
 * You do not need to use up all the given intervals. You can select pairs in any order.
 *
 * 1. pairs = [[1,2],[2,3],[3,4]] === O/P ===> 2 for longest chain [1,2] -> [3,4]
 * 2. pairs = [[1,2],[7,8],[4,5]] === O/P ===> 3 for longest chain [1,2] -> [4,5] -> [7,8]
 */
public class MaxLengthOfPairChain {
    public static void main(String[] args) {
        int[][] pairs = new int[][]{{1,2}, {2,3}, {3,4}};//exp. O/P = 2
        //int[][] pairs = new int[][]{{1,2}, {7,8}, {4,5}};//exp. O/P = 3
        //int[][] pairs = new int[][]{{250,280}, {-995,-994}, {4,5}, {1,2}, {-950,200}, {300, 310}};//exp. O/P = 5
        //int[][] pairs = new int[][]{{-6,9}, {1,6}, {8,10}, {-1,4}, {-6,-2}, {-9, 8}, {-5,3}, {0,3}};//exp. O/P = 3
        System.out.println("maxLength of chain pair = "+leetcodeSolution(pairs));
    }

    /**
     * Notes : from github/leetcode repo
     * -- sort by righti of each pair
     * -- if pair_i = (a,b), pair_j = (c,d), we need to find longest chain where b < c for all pairs
     * -- it is given that for each pair (i,j) -> i < j
     * -- on sorting a pair (Ai,Aj) using value Aj, all pairs will be arranged in their desired final order.
     * -- we just need to eliminate/skip pairs which are not a part of the sequence.
     * ** why does chain have to start with lowest pair?? --> because for THE FIRST PAIR && ONLY THE FIRST PAIR (i,j), the value of j is
     *    the smallest amongst all pairs. If there exists a chain with length > 1, this first pair WILL ALWAYS BE A PART OF THIS LENGTH.
     */
    static int leetcodeSolution(int[][] pairs) {
        if (pairs.length == 1) {
            return 1;
        }
        Arrays.sort(pairs, Comparator.comparingInt(subpair -> subpair[1]));
        Arrays.stream(pairs).forEach(pair -> System.out.print(Arrays.toString(pair)));
        int curLength = 1;
        int b = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (b < pairs[i][0]) {
                ++curLength;
                b = pairs[i][1];
            }
        }
        return curLength;
    }

    static int mySolution(int[][] pairs) {
        if (pairs.length == 1) {
            return 1;
        }
        //first I sorted pairs by subpair[0] then subpair[0] + subpair[1]
        Arrays.sort(pairs, Comparator.comparingInt(subpair -> subpair[0]+subpair[1]));
        //Arrays.stream(pairs).forEach(pair -> System.out.print(Arrays.toString(pair)));
        //System.out.println();
        int b = pairs[0][1];
        int curLength = 1;
        int maxLength = Integer.MIN_VALUE;
        for(int i = 1;i<pairs.length;i++) {
            if (b < pairs[i][0]) {
                ++curLength;
            } else {
                maxLength = Math.max(maxLength, curLength);
                curLength = 1;
            }
            //update b
            b = pairs[i][1];
        }
        return Math.max(maxLength, curLength);
    }
}
