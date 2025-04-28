package com.leetcode.premium;

import java.util.Arrays;


//problem # 1708
//check https://github.com/doocs/leetcode/tree/main/solution/1700-1799/1708.Largest%20Subarray%20Length%20K
//for
//more
//details
public class LargestSubArrayOfLengthK_L1708 {
    public static void main(String[] args) {
        //{1,4,5,2,3}, k = 3
        //{1,4,5,2,3}, k = 4
        //{1,4,5,2,3}, k = 1
        System.out.println(Arrays.toString(largestSubArray(new int[]{1,4,5,2,3},3)));
    }

    //my first attempt at problem solution
    public static int[] largestSubArray(int[] A,int k) {
        //1,4,5,2,3 | k=3, find subarray where first non-equal element is greatest
        //subarrays = {1,4,5} {4,5,2} {5,2,3} -> max(1,4,5) = 5 so subarray is {5,2,3}

        //1,4,5,2,3 | k=2
        //{1,4}{4,5}{5,2}{2,3} ->

        //1,4,5,2,3 | k=4
        //{1,4,5,2} {4,5,2,3} -> max(1,4,5,2) = 5 but {5,2,3,X} is not valid subarray

        //1,4,5,2,3,7,6,10,8,9 | k=3
        //{1,4,5} {4,5,2} {5,2,3} {2,3,7} {3,7,6} {7,6,10} {6,10,8} {10,8,9},
        // count no of subarrays given array.length & elements in each subarray
        // A[0], A[A.length-1] won't repeat in any subarray, rem elements = no of subarrays = (A.length - 2) subarrays
        // idx = max(A[0]...A[A.length-2]) return A.subarray(idx,id+k)

        //8,1,2,3,10,6,9,7,4,5 | k=4
        //{8,1,2,3} {1,2,3,10} {2,3,10,6} {3,10,6,9} {10,6,9,7} {6,9,7,4} {9,7,4,5}, no of subarrays =
        return new int[]{};
    }
}
