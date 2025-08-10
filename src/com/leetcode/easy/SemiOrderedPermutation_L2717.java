package com.leetcode.easy;

//prob # 2717 - semi-ordered permutation
public class SemiOrderedPermutation_L2717 {
    public static void main(String[] args) {
        //2,4,1,3
        //1,3,4,2,5
        //3,4,6,8,1,5,9,2,7
        //3,4,6,8,9,5,2,7,1
        //3,4,6,8,9,1,5,2,7
        System.out.println(semiOrderedPermutation(new int[]{3,4,6,8,9,1,5,2,7}));
    }

    //1 <= nums.length <= 50
    //nums will always contain at least 1 & nums.length ?
    //permutation of n numbers means it contains numbers from 1 to n in any order i.e it will contain 1 & n
    //find position of 1,n maxSwaps = (curr_pos(1) - 0) + (n - curr_pos(n));
    //if initial_pos(1) > initial_pos(n) ? return maxSwaps - 1 else maxSwaps
    //test run#2
    //3,4,1,6,8,9,5,2,7
    //1 = [2], 9 = [5], maxSwaps = (2-0) + (9 - 5) = 6
    //initial_pos(1) = 2 < initial_pos(9) = 5 so return 6
    //test run#3
    //3,4,6,8,9,5,2,7,1
    //1 = [8], 9 = [4], maxSwaps = 8-0-1 + 9 - 4 - 1 = 11?
    //
    //2,4,1,3 -> curr_idx_of_1(2)-0 + ((n-1) - curr_idx_of_n(1)) = 2-0 + 3 - 1 = 2 + 2 = 4
    //2,1,4,3 -> 1-0 + 3-2 = 1 + 1 = 2
    //3,4,1,6,8,9,5,2,7 -> 2-0 + 8-5 = 2 + 3 = 5
    //3,4,6,8,9,5,2,7,1 -> 8-0 + 8-4 = 12 - 1 = 11
    //3,4,6,8,9,1,5,2,7 -> 5-0 + 8-4 = 9-1 = 8
    //3,4,6,8,1,5,9,2,7 -> 4-0 + 8-6 = 6

    //2,4,1,3
    public static int semiOrderedPermutation(int[] nums) {
        int idx1 = -1, idxN = -1,res,l=nums.length-1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 1) {
                idx1 = i;
            } else if(nums[i] == nums.length) {
                idxN = i;
            }
        }
        res = idx1 + (l - idxN);
        return idx1 > idxN ? res-1:res;
    }
}
