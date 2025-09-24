package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

//prob # 2248 - intersection of multiple arrays
public class IntersectionOfMultipleArrays_L2248 {
    public static void main(String[] args) {
        //{3,1,2,4,5},{1,2,3,4},{3,4,5,6}
        //[1,2,3],[4,5,6]
        System.out.println(intersection(new int[][]{{1,2,3},{4,5,6}}));
    }

    public static List<Integer> intersection(int[][] nums) {
        List<Integer> res = new ArrayList<>();
        int[] freq = new int[1001];
        for (int[] num : nums) {
            for (int i : num) {
                freq[i]++;
            }
        }
        //System.out.println(Arrays.toString(freq));
        for(int i=0;i<freq.length;i++) {
            if(freq[i] == nums.length) {
                res.add(i);
            }
        }
        return res;
    }
}
