package com.leetcode.easy;

import java.util.Arrays;

//prob. # 1984 - minimum difference between highest & lowest of k scores
public class MinimumDifferenceBetweenHighestAndLowestOfKScores_L1984 {
    public static void main(String[] args) {
        //9,4,1,7   2
        //6, 10, 8, 8, 10, 9, 10, 6     4
        //9, 7, 5, 3, 1, 7, 3, 6    3
        //13, 7, 5, 3, 7, 2, 14, 9, 0, 8    2,3,4
        //0, 14, 0, 1, 2, 12, 4, 11, 10, 11     2,3,4
        System.out.println(minimumDifference(new int[]{90,70,20},1));
    }

    //20,4,0,12,7,2,15,10   k=4,3,2
    //max = 20, maxII = 15 - {}
    //find closest numbers, min diff is 1
    //k=4 minDiff = min(abs(nums[i]-nums[j]))
    //select k elements such that
    //sort -> 0,2,4,7,10,12,15,20 -> (0,2,4,7), (2,4,7,10), (4,7,10,12), (7,10,12,15), (10,12,15,20)
    //  (0,2,4), (2,4,7), (4,7,10), (7,10,12), (10,12,15), (12,15,20)
    //sliding window with window size = k
    //i=0,j=k-1
    //while j < nums.length
    //sort -> 1,4,7,9 -> (1,4), (4,7), (7,9)
    //[0, 0, 1, 2, 4, 10, 11, 11, 12, 14]   k=3 -> ()
    public static int minimumDifference(int[] nums, int k) {
        if(nums.length < k)return 0;
        int n = nums.length;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        //if(k == 1 && n > 1)return nums[0];
        int i=0,j=k-1;
        int minDiff = Integer.MAX_VALUE;
        while(j-i+1 == k && j < n) {
            if(nums[j]-nums[i] <= minDiff)minDiff = nums[j]-nums[i];
            j++;
            i++;
        }
        return minDiff;
    }
}
