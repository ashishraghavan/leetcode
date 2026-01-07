package com.algomonster.problems.twopointers_or_sliding_window;

import java.util.Arrays;
import java.util.List;

public class RangeSumQuery {
    public static void main(String[] args) {
        //1, 2, 3, 4 |1,3
        //[3,4,7,2,-3,1,4,2], 2,5
        //[3,4,7,2,-3,1,4,2], 0,7
        //[100,200,300,400], 1,2
        //[10,-5,7,-2], 1,2
        //[0,0,0,0], 1,3
        System.out.println(rangeSumQueryImmutable(Arrays.asList(0,0,0,0),1,3));
    }

    //1, 2, 3, 4 |1,3
    //pf[] = [0,1,3,6,10], sum[1,3] = sum[0,3]-sum[0,0] = 10 - 1 = 9 == pf[4] - pf[1]

    //3,4,7,2,-3,1,4,2 |2,5
    //pf[] = [0,3,7,14,16,13,14,18,20], sum[2,5] = sum[0,5]-sum[0,1] = 14-7 = 7 == pf[6] - pf[2] = 7
    public static int rangeSumQueryImmutable(List<Integer> nums, int left, int right) {
        int[] pfSum = new int[nums.size()+1];
        pfSum[0] = 0;
        int sum = 0;
        for(int i=1;i<pfSum.length;i++) {
            sum += nums.get(i-1);
            pfSum[i] = sum;
        }
        //System.out.println(Arrays.toString(pfSum));
        return pfSum[right+1] - pfSum[left];
    }
}
