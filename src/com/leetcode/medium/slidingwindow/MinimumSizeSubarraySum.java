package com.leetcode.medium.slidingwindow;

//#209
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLenCorrected(7,new int[]{2,3,1,2,4,3}));
    }

    //all +ve integers
    //2,3,1,2,4,3 [7]
    //f=0,l=0,
    public static int minSubArrayLen(int target, int[] A) {
        //A.length < 2 ?
        int f=0,l=0,sum=A[f];
        int min = Integer.MAX_VALUE;
        while(f <= l && l < A.length) {
            if(sum >= target) {
                min = Math.min(min,l-f+1);
                sum -= A[f];
                f++;
            } else {
                l++;
                sum+=A[l];
            }
        }
        return min;
    }

    //TODO: using https://share.gemini.google/6SLFkYMZAeq2
    public static int minSubArrayLenCorrected(int target, int[] A){
        int f=0,l=0,sum=0,min=Integer.MAX_VALUE;
        for(;l<A.length;l++) {
            sum += A[l];
            while(sum >= target) {
                min = Math.min(min,l-f+1);
                sum-=A[f];
                f++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
