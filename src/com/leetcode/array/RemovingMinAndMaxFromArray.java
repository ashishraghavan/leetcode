package com.leetcode.array;

/**
 * You are given a 0-indexed array of distinct integers nums.
 *
 * There is an element in nums that has the lowest value and an element that has the highest value.
 * We call them the minimum and maximum respectively. Your goal is to remove both these elements from the array.
 *
 * A deletion is defined as either removing an element from the front of the array or removing an element
 * from the back of the array.
 *
 * Return the minimum number of deletions it would take to remove both the minimum and maximum element from the array.
 *
 * [2,10,7,5,4,1,8,6] min = 1, max = 10. To remove 1, we can either remove 7 elements from the front or 3 elements from the back. The
 * min of this is 3. To remove 10, we can remove 2 elements from the front or 7 elements from the back. Min is 2. So, total operations
 * is 3 + 2 = 5.
 *
 * [0,-4,19,1,8,-2,-3,5] -- min = -4, max = 19 ==> 3 ops
 *
 * If removing min & max element from the front or back, minimum will be equal to
 * min(max(idx of min, idx of max)+1,nums.length - max(idx of min, idx of max)+1) ==> only if min, max are to be removed from
 * either the front or back. If opposite ends of the array,
 *
 * [2,10,7,5,4,1,8,6] -- min = 1, max = 10
 * equal to
 *
 * TODO : WIP
 */
public class RemovingMinAndMaxFromArray {
    public static void main(String[] args) {
        minimumDeletions(new int[]{0,-4,19,1,8,-2,-3,5});
        //System.out.println();
    }

    static int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIdx = -1;
        int maxIdx = -1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            if(nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }

        return -1;
    }
}
