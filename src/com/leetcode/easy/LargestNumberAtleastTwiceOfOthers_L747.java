package com.leetcode.easy;

//problem # 747 - largest number at least twice of others
public class LargestNumberAtleastTwiceOfOthers_L747 {
    public static void main(String[] args) {
        //[3,6,1,0]
        //[1,2,3,4]
        //{74, 64, 67, 63, 3}
        //100,25,0,10,20,49
        //25,0,10,100,20,49
        //0,0,0,1,0,0,0
        //10,5
        System.out.println(dominantIndex(new int[]{3,6,1,0}));
    }

    //100,25,0,10,20,49 -sort-> 0,10,20,25,49,100
    //find second largest number - if this no*2 <= largest return idx_of_largest
    public static int dominantIndex(int[] nums) {
        int largestIdx = largestIndex(nums);
        int secLargestIdx = secondLargestIndex(nums,largestIdx);
        return nums[secLargestIdx]*2 <= nums[largestIdx] ? largestIdx : -1;
    }

    public static int largestIndex(int[] nums) {
        int lVal = Integer.MIN_VALUE;
        int lIdx = -1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > lVal) {
                lIdx = i;
                lVal = nums[i];
            }
        }
        return lIdx;
    }

    public static int secondLargestIndex(int[] nums, int idx) {
        int slIdx = -1;
        int tLargest = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(idx == i)continue;
            if(nums[i]>=tLargest) {
                tLargest = nums[i];
                slIdx = i;
            }
        }
        return slIdx;
    }
}
