package com.leetcode.medium.binary_search_on_answer;

//1283
public class SmallestDivisorGivenAThreshold {
    public static void main(String[] args) {
        //44,22,33,11,1
        //1,2,5,9
        //2, 3, 5, 7|17
        //8|3
        //10, 10, 10, 10|8
        //1, 1, 1, 100|6
        //1, 2, 3|100
        //7, 9|4
        //19|5
        //1000000, 1000000|3
        int[] A = new int[]{1000000, 1000000};
        int t = 3;
        System.out.println(smallestDivisor(A,t));
    }

    public static int smallestDivisor(int[] A, int t) {
        int left = 1,right=1;
        for(int val : A) {
            right = Math.max(right,val);
        }
        while(left < right) {
            int mid = left + (right - left)/2;
            int sum = sum(A,mid);
            if(sum <= t) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //Use Use integer ceiling division: (val + divisor - 1) / divisor for rounding!!!
    public static int sum(int[] A,int divisor) {
        int sum = 0;
        for(int val : A) {
            //sum += (int) Math.ceil((double)val/divisor);
            sum += (val + divisor - 1)/divisor;
        }
        return sum;
    }
}
