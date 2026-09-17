package com.leetcode.medium.greedy_scheduling_and_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//#406
public class QueueReconstructionByHeight {
    public static void main(String[] args) {
        //{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
        int[][] result = reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
        for(int[] res : result) {
            System.out.println(res[0] + ","+res[1]);
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(p1,p2)->p1[0]==p2[0]?p1[1]-p2[1]:p2[0]-p1[0]);
        List<int[]> result = new ArrayList<>();
        for(int[] ppl : people) {
            result.add(ppl[1],ppl);
        }
        return result.toArray(new int[people.length][]);
    }
}
