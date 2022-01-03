package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is
 * secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * 1) The town judge trusts nobody.
 * 2) Everybody (except for the town judge) trusts the town judge.
 * 3) There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts
 * the person labeled bi.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 *
 * Pot ans:
 * if n = 3, there should exist at least n-2 pairs where bi = x and none of these should contain ai = x.
 * If this holds true, then x is the judge. There cannot be a pair where (ai,bi) = (x,x) coz the judge
 * doesn't trust him/her self. There cannot be > (n-1) pairs.
 * n = 4, [2,1],[3,1],[4,1],[3,4]. map to track frequency of person represented by bi.
 * n = 3, [1,3],[2,3]. freq(3 as bi) = 2 (3 - 1). && freq(3 as ai) = 0
 *
 */
public class FindTheTownJudge {
    public static void main(String[] args) {
        //int n = 3;
        //int[][] trust = new int[][]{{1,3},{2,3},{3,1}};
        //int n = 3;
        //int[][] trust = new int[][]{{1,3},{2,3}};
        //int n = 10;
        //int[][] trust = new int[][]{{8,7},{1,7},{1,8},{6,10},{3,7},{10,5},{9,6},{2,7},{4,7},{6,7},{2,1},{3,1},{5,7},{10,7},{9,7}};
        int n = 2;
        int[][] trust = new int[][]{{1,2}};
        System.out.println(findJudge(n,trust));
    }

    static int findJudge(int n, int[][] trust) {
        Map<Integer,Integer> biMap = new HashMap<>();
        Map<Integer,Integer> aiMap = new HashMap<>();
        if(n == 1)return 1;
        for (int[] ints : trust) {
            int ai = ints[0];
            int bi = ints[1];
            if (aiMap.containsKey(ai)) {
                aiMap.put(ai, aiMap.get(ai) + 1);
            } else {
                aiMap.put(ai, 1);
            }
            if (biMap.containsKey(bi)) {
                biMap.put(bi, biMap.get(bi) + 1);
            } else {
                biMap.put(bi, 1);
            }
        }
        //1. check if biMap contains a key with value = n - 1.
        //2. if 1. is true, check if this key is present in aiMap.
        for(Integer person : biMap.keySet()) {
            if(biMap.get(person).equals(n-1) && !aiMap.containsKey(person)) {
                return person;
            }
        }
        return -1;
    }
}
