package com.leetcode.easy;

import java.util.Arrays;

//problem # 643 max avg subarray
//check https://github.com/doocs/leetcode/tree/main/solution/0600-0699/0643.Maximum%20Average%20Subarray%20I
//for github solution
public class MaxAvgSubarray_L643 {
    public static void main(String[] args) {
        //1,12,-5,-6,50,3 | 4
        //5 | 1
        //-39, -50, 36, 10, -50, 36, 40, 37, -37, 26 | 3 exp. 71
        System.out.println(findMaxAverage(new int[]{-39, -50, 36, 10, -50, 36, 40, 37, -37, 26},3));
    }

    //1,12,-5,-6,50,3 | 4
    //i=0, j=k-1, 1+12-5-6 = 2/4
    //i++, j++, 2+50-1 = (62-11) = 51/4 = 10.xxxx
    //i++, j++, 51+3-12 = 42/4

    //-39, -50, 36, 10, -50, 36, 40, 37, -37, 26 | 3
    //50, -36 | 2 -> 14/2 = 7
    //my solution
    public static double findMaxAverage(int[] nums, int k) {
        if(k == 1) {
            //IntStream.rangeClosed(0,nums.length-1).mapToObj(i->nums[i])
            return Arrays.stream(nums).boxed().max(Integer::compareTo).orElse(-1);
        }
        int i=0,j=k-1,sum = 0;
        double mxAvg;
        //calculate sum of first k numbers
        for(int m=0;m<=j;m++) {
            sum += nums[m];
        }
        mxAvg = (double) sum /k;
        i++;
        j++;
        while(j < nums.length) {
            sum += nums[j] - nums[i-1];
            mxAvg = Math.max((double)sum/k,mxAvg);
            i++;
            j++;
        }
        return mxAvg;
    }
}
