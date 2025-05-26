package com.leetcode.easy;

import java.util.Arrays;

//problem # 645 - set mismatch
//check https://github.com/doocs/leetcode/tree/main/solution/0600-0699/0645.Set%20Mismatch for github solution
public class SetMismatch_L645 {
    public static void main(String[] args) {
        //4,2,1,2
        //1,1
        //2,1,6,3,2,5,4
        System.out.println(Arrays.toString(findErrorNums(new int[]{2,1,6,3,2,5,4})));
    }

    //4,2,1,2, n=4, int[]{0,1,-1,0} -> return new int[]{2,3} i.e. idx(1),idx(-1)
    //will repeated number, missing number be always consecutive? i.e. 2,3 OR 1,2 or 4,5
    public static int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
        for (int num : nums) {
            arr[num - 1]++;
        }
        int[] res = new int[2];
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == 1) {
                res[0] = i+1;
            } else if(arr[i] == -1) {
                res[1] = i+1;
            }
        }
        return res;
    }
}
