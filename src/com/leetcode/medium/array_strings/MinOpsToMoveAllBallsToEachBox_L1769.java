package com.leetcode.medium.array_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//TODO: check https://algo.monster/liteproblems/1769 for intuitive solution involving dynamic programming
//prob #1769 - min operations to move all balls to each box
public class MinOpsToMoveAllBallsToEachBox_L1769 {
    public static void main(String[] args) {
        //001011
        //110
        //10101011
        System.out.println(Arrays.toString(minOperationsII("10101011")));
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

    //10101011
    //for each i in (1,7) cost at i = cost at i-1 + total_balls_to_left_of_i
    //i=0 -> 0 + 0 => left[0] = 0,
    //i=1 -> boxes[i-1] == 1 ? balls++,
    //i=3, cost[2] + balls -> cost[2] = cost[1] + balls -> cost[2] = cost[1]+balls ->
    // cost[1] = cost[0] + balls ==> at idx=0,balls to left of idx=0 & cost[0] = 0 as
    // there are no balls to be moved to left of idx
    //i=3,balls=0; cost[7] = cost[8] + balls = 0, cost[6] ->  boxes[7]==1 ? balls++ = 1 => cost[6] = 0+1 = 1

    ////check [...](https://algo.monster/liteproblems/1769) for intuitive solution
    public static int[] minOperationsII(String boxes) {
        int[] left = new int[boxes.length()];
        int[] right = new int[boxes.length()];
        int[] res = new int[boxes.length()];
        int balls = 0;
        for(int i=1;i<left.length;i++) {
            if(boxes.charAt(i-1) == '1')balls++;
            left[i] = left[i-1] + balls;
        }
        System.out.println(Arrays.toString(left));
        balls = 0;
        for(int i=right.length-2;i>=0;i--) {
            if(boxes.charAt(i+1) == '1')balls++;
            right[i] = right[i+1] + balls;
        }
        System.out.println(Arrays.toString(right));
        for(int i=0;i<boxes.length();i++) {
            res[i] = left[i] + right[i];
        }
        return res;
    }
}
