package com.leetcode.medium.greedy_scheduling_and_sorting;

//#134
public class GasStation {
    public static void main(String[] args) {
        //[1,2,3,4,5], [3,4,5,1,2]
        //[2,3,4], [3,4,3]
        //2
        //5, 1, 2, 3, 4 | 4, 4, 1, 5, 1
        //1, 1, 1, 10 | 2,2,2,1
        //3, 3, 4 | 3,4,3
        //0, 0, 0, 5 | 0, 0, 1, 4
        //5, 8, 2, 8 | 6,5,6,6
        //10000, 10000, 0 | 5000, 5000, 10000
        System.out.println(canCompleteCircuit(new int[]{3, 3, 4},new int[]{3,4,3}));    }

    //[1,2,3,4,5], [3,4,5,1,2]
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int currGas = 0;
        int idx = 0;
        for(int i=0;i<gas.length;i++) {
            gasSum += gas[i];
            costSum += cost[i];
            currGas += (gas[i]-cost[i]);
            if(currGas < 0) {
                idx = i + 1;
                currGas = 0;
            }
        }
        if(gasSum <  costSum) return -1;
        return idx;
    }
}
