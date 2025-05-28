package com.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

//problem # 2099 largest sum subsequence of length k
//check https://github.com/doocs/leetcode/tree/main/solution/2000-2099/2099.Find%20Subsequence%20of%20Length%20K%20With%20the%20Largest%20Sum for github solution
public class LargestSumSubsequenceOfLengthK_L2099 {
    public static void main(String[] args) {
        //-1,-2,3,4 | 3
        //10, -11, 8, 5, -7, -8, -1, 8 | 3
        System.out.println(Arrays.toString(maxSubsequence(new int[]{10, -11, 8, 5, -7, -8, -1, 8},4)));
    }

    //-1,-2,3,4 | 3
    //all possible 3 element subsequences - (-1,-2,3), (-1,-2,4), (-1,3,4), (-2,3,4)
    //mx = nums[0],
    // i=1;i<nums.length;i++
    //      mx = math.max(mx,mx+)
    //can't change order therefore can't sort, sliding window

    //10, -11, 8, 5, -7, -8, -1, 8 | 3 -> ...10,8,5,8 -> ...5,8,8,10 (...3,2,7,0)

    //github solution steps
    //1. create idx integer array to store indexes of nums
    //2. sort idx in ascending order of nums[i]
    //3. sort last n-k elements of idx in ascending order -> these are the indexes with the maximum values
    //4. return values corresponding to indexes n-k -> n-1 as answer
    //GITHUB SOLUTION:
    public static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Integer[] idx = new Integer[nums.length];
        for(int i=0;i<n;i++) {
            idx[i] = i;
        }
        Arrays.sort(idx,Comparator.comparingInt(i->nums[i]));
        Arrays.sort(idx,n-k,n);
        int[] res = new int[k];
        for(int i=n-k;i<n;i++) {
            res[i-(n-k)] = nums[idx[i]];
        }
        return res;
    }
}
