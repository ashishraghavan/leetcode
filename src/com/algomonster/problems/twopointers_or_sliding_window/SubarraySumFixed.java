package com.algomonster.problems.twopointers_or_sliding_window;

import java.util.Arrays;
import java.util.List;

public class SubarraySumFixed {
    public static void main(String[] args) {
        //0,0,0,0
        //0,1,0,1
        //2,2,2,2,2
        //100,200,300,400,500
        //100,200,300,400,500
        //1,2,3,4,5
        //5,4,3,2,1
        System.out.println(subarraySumFixed(Arrays.asList(100,200,300,400,500),3));
    }

    //1, 2, 3, 7, 4, 1
    public static int subarraySumFixed(List<Integer> nums, int k) {
        if(nums.isEmpty() || nums.size() < k)return -1;
        int l=0,r=k-1,sum=0,maxSum;
        for(int i=0;i<k;i++) {
            sum += nums.get(i);
        }
        maxSum = sum;
        while(++r < nums.size()) {
            sum = sum + nums.get(r) - nums.get(l);
            maxSum = Math.max(maxSum,sum);
            l++;
        }
        return maxSum;
    }
}
