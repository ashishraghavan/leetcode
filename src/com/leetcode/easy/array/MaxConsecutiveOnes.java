package com.leetcode.easy.array;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        //1,1,0,1,1,1
        //1,0,0,0,0,1
        //1,0,0,0,0,0
        //1,0,1,0,1,0
        System.out.println(findMaxConsecutiveOnes(new int[]{1,0,0,0,0,1}));
    }

    static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;
        int currentConsecutiveOnes = 0;
        for (int num : nums) {
            if (num != 1) {
                if (currentConsecutiveOnes > maxConsecutiveOnes) {
                    maxConsecutiveOnes = currentConsecutiveOnes;
                }
                currentConsecutiveOnes = 0;
            } else {
                currentConsecutiveOnes++;
            }
        }
        if(currentConsecutiveOnes > maxConsecutiveOnes) {
            maxConsecutiveOnes = currentConsecutiveOnes;
        }
        return maxConsecutiveOnes;
    }
}
