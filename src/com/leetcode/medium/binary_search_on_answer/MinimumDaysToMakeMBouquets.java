package com.leetcode.medium.binary_search_on_answer;

//#1482
public class MinimumDaysToMakeMBouquets {
    public static void main(String[] args) {
        //7,7,7,7,12,7,7|2|3
        //1,10,3,10,2|3|1
        //1,10,3,10,2|3|2
        //1000000000, 1000000000|1|1
        //5|1|1
        //1, 2, 3, 4, 5, 6|1|6
        //1, 2, 3, 4, 5, 6
        //5, 5, 5, 5, 5|2|2
        //1, 10, 2, 9, 3, 8, 4, 7|2|3
        //1, 2, 3|100000|100000
        int[] bloomDays = new int[]{1, 2, 3};
        int m = 100000;
        int k = 100000;
        System.out.println(minDays(bloomDays,m,k));
    }

    //7,7,7,7,12,7,7    m=2     k=3
    public static int minDays(int[] A, int m, int k) {
        long boqueFlowers = (long) m * k;
        if(A.length < boqueFlowers)return -1;
        int left=Integer.MAX_VALUE,right=0;
        for(int val : A) {
            left = Math.min(left,val);
            right = Math.max(right,val);
        }
        while(left < right) {
            int mid = left + (right - left)/2;
            if(isValid(A,mid,m,k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    //7,7,7,7,12,7,7    bloomDay=9  m=2     k=3
    public static boolean isValid(int[] A,int bloomDay,int targetBoquet,int targetFlowers) {
        int totalBoquet = 0;
        int cnt = 0;
        for (int flower : A) {
            if (flower <= bloomDay) {
                cnt++;
                if (cnt == targetFlowers) {
                    totalBoquet++;
                    cnt = 0;
                    if (totalBoquet == targetBoquet) {
                        return true;
                    }
                }
            } else {
                cnt = 0;
            }
        }
        return false;
    }
}
