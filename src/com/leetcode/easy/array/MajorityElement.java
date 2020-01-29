package com.leetcode.easy.array;


import java.util.Arrays;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears <strong>more than</strong> ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Explanation : since one number among the array is present more than n/2 number of times, we can be sure that after sorting,
 * either the number will be in the first half + 1 or 1 + second half of the array.
 * Therefore, doing a sort and returning arr[arr.length/2] will always yield the correct answer.
 */
public class MajorityElement {
    public static void main(String[] args) {
        //2,2,1,1,1,2,2
        //5,5,2,0,5,7,5
        //9,0,7,9,9,5,9,0,0,9,9
        //3,2,3
        //9,1,0,4,8,0,0,0,0,0
        //4,0,4,7,8,4,4
        System.out.println(majorityElement(new int[]{4,0,4,7,8,4,4}));
        //1,1,1,2,2,2,2
        //1,1,1,1,2,2,2
        //TC : 5,5,2,0,5,7,5 - 0,2,5,5,5,5,7 - 5
        //TC : 9,0,7,9,9,5,9,0,0,9,9 - 0,0,0,5,7,9,9,9,9,9,9 -
        //TC : 3,2,3 - (3/2 = 1) - sort - 2,3,3 - arr[(3/2)] = arr[1] = 3
        //TC : 9,1,0,4,8,0,0,0,0,0 - sort - 0,0,0,0,0,0,1,4,9 - arr[9/2] = arr[4] = 0
        //TC : 4,0,4,7,8,4,4 - sort - 0,4,4,4,4,7,8 - arr[7/2] = arr[3] = 4
        //More than half of the array will be one among the array
    }


    private static int majorityElement(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
}
