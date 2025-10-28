package com.leetcode.medium.array_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//TODO: definitely need to optimize
//prob #1769 - min operations to move all balls to each box
public class MinOpsToMoveAllBallsToEachBox_L1769 {
    public static void main(String[] args) {
        //001011
        //110
        System.out.println(Arrays.toString(minOperations("001011")));
    }

    //001011
    //i=1 :: 3->1 = 2, 5->1 = 4, 6->1 = 5 => 2 + 4 + 5 = 11
    //i=2 :: 3->2 = 1, 5->2 = 3, 6->2 = 4 => 1 + 3 + 4 = 8
    //i=3 :: 5->3 = 2, 6->3 = 3 => 2 + 3 = 5
    //i=4 :: 3->4 = 1, 5->4 = 1, 6->4 = 2 => 1+1+2 = 4
    //i=5 :: 3->5 = 2, 6->5 = 1 => 1+2 = 3
    //i=6 :: 3->6 = 3, 5->6 = 1 => 1+3 = 4
    //return [11,8,5,4,3,4]
    public static int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        Map<Integer,Boolean> mp = new HashMap<>();
        for(int i=0;i<boxes.length();i++) {
            if(boxes.charAt(i) == '1') {
                mp.put(i,true);
            }
        }
        int sum;
        for(int i=0;i<boxes.length();i++) {
            sum = 0;
            for(Integer key : mp.keySet()) {
                sum += (Math.abs(key - i));
            }
            res[i] = sum;
        }
        return res;
    }
}
