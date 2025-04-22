package com.leetcode.premium;

import java.util.Arrays;

//problem # 1150
//check https://github.com/doocs/leetcode/tree/main/solution/1100-1199/1150.Check%20If%20a%20Number%20Is%20Majority%20Element%20in%20a%20Sorted%20Array
// for
// more
// details
//TODO: review
public class MajorityElementInSortedArray_L1150 {
    public static void main(String[] args) {
        //2,4,5,5,5,5,5,6,6
        //10,100,101,101
        //1,3,4,7,7,7,7,7
        System.out.println(majorityElementII(new int[]{2,4,5,5,5,5,5,6,6}, 5));
    }

    //TODO: DO BINARY SEARCH FOR OPTIMAL SEARCHING BECAUSE THE ARRAY IS SORTED!!!
    public static boolean majorityElement(int[] A,int target) {
        //start = 2, end = 6, count = 6 - 2 + 1 = 5 ?>? A.length/2
        if(A.length == 1) {
            return true;
        }
        int start = 0, end = A.length - 1;
        while(start < end) {
            if (A[start] > target && A[end] < target) {
                return false;
            }
            if (A[start] == target && A[end] == target) {
                return (end - start + 1) > A.length/2;
            }
            if (A[start] < target) {
                start++;
            }
            if (A[end] > target) {
                end--;
            }
        }
        return false;
    }

    //TODO: add method detail
    public static boolean majorityElementII(int[] A,int target) {
        return false;
    }
}
