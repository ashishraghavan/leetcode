package com.leetcode.medium.twopointers;

import java.util.Arrays;

//167
public class TwoSumII {
    public static void main(String[] args) {
        //2,7,11,15|9
        //2,3,4|6
        //-1,0|-1
        //2, 2, 3|4
        //0, 0, 1, 2|0
        //-10, -5, 1, 5, 12|0
        //1, 2, 3, 4, 4, 9, 56, 90|8
        //-1000, -500, -100, -50, -10|-1100
        //1, 5, 8, 13, 20|21
        //5, 20, 30, 70, 85|100
        //1, 2, 3, 4, 5, 100, 200|300
        System.out.println(Arrays.toString(twoSumUpdated(new int[]{2, 2, 3},4)));
    }

    //
    public static int[] twoSum(int[] numbers, int target) {
        //array,fromIdx,toIdx,key
        int reqSum;
        for(int i=0;i<numbers.length;i++) {
            reqSum = target - numbers[i];
            int idx = Arrays.binarySearch(numbers,i+1,numbers.length,reqSum);
            if(idx >= 0) {
                return new int[]{i+1,idx+1};
            }
        }
        return new int[]{};
    }

    public static int[] twoSumUpdated(int[] numbers, int target) {
        int left=0,right=numbers.length-1,sum;
        while(left < right) {
            sum = numbers[left]+numbers[right];
            if(sum==target) {
                return new int[]{left+1,right+1};
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{};
    }
}
