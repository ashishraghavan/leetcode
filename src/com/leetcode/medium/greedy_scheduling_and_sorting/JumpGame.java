package com.leetcode.medium.greedy_scheduling_and_sorting;

//#55
public class JumpGame {
    public static void main(String[] args) {
        //2,3,1,1,4
        //3,2,1,0,4
        //0, 1
        //0
        //2, 0, 0
        //1, 1, 1, 1
        //10, 0, 0, 0, 0
        //1, 0, 2
        //2, 5, 0, 0
        //1, 2, 0, 1, 0, 1
        //3, 2, 1, 0, 4
        System.out.println(canJump(new int[]{1, 2, 0, 1, 0, 1}));
    }

    //2,3,1,1,4
    public static boolean canJump(int[] A) {
        if(A.length == 1)return true;
        int farthest = 0;
        for(int i=0;i<A.length-1;i++) {
            farthest = Math.max(farthest,i+A[i]);
            if(farthest <= i)return false;
            else if(farthest >= A.length-1)return true;
        }
        return false;
    }
}
