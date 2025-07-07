package com.leetcode.easy;

//prob # 1437 - check if all 1's are k places away
public class CheckIfAllOnesAreKPlacesAway_L1437 {
    public static void main(String[] args) {
        //1,0,0,0,1,0,0,1   2
        //1,0,0,1,0,1   2
        System.out.println(kLengthApart(new int[]{1,0,0,1,0,1},2));
    }

    //1,0,0,0,1,0,0,1   2
    //at every 2nd step, if sum > 1 return false else set sum, return true at end of loop
    //last = -1, i in (0,nums.length) if nums[i]==1 ? last == -1 ? last = i, continue; else if(i-last < k)return false;
    public static boolean kLengthApart(int[] nums, int k) {
        int last = -1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0)continue;
            if(last != -1 && i-last <= k)return false;
            last=i;
        }
        return true;
    }
}
