package com.leetcode.premium;

import java.util.Arrays;

//problem # 1064 fixed point
//check https://github.com/doocs/leetcode/blob/main/solution/1000-1099/1064.Fixed%20Point/README_EN.md
//for
//more
//details
//TODO: incorrect/inefficient solution
public class FixedPoint_L1064 {
    public static void main(String[] args) {
        //-10,-5,0,3,7
        //0,2,5,8,17
        //-10,-5,3,4,7,9
        System.out.println(fixedPoint(new int[]{-10,-5,0,3,7}));
    }

    //NOTE:: suggest solution other than O(n)
    //-(insertion point) - 1
    public static int fixedPoint(int[] A) {
        //binary search
        //target = A.length/2
        //int idx = Arrays.binarySearch(A,A[target]);
        //if(idx == target) return target;
        //else if A[target] < target -- repeat binary search on right sub-array
        //else -- repeat binary search on left sub-array
        int start = 0, end = A.length-1,res,target;
        while(end - start > 0) {
            res = doBinarySearch(A,start,end);
            target = (end-start+1)/2;
            if (res == target) {
                return A[res];
            } else if(A[target] < target){
                //res = doBinarySearch(A,)
            }
        }
        return -1;

        //if(res == Integer.MIN_VALUE)return -1;

    }

    private static int doBinarySearch(int[] A,int start,int end) {
        if(end-start == 0) return Integer.MIN_VALUE;
        int target = (end-start+1)/2;
        int idx = Arrays.binarySearch(A,target,start,end);
        if(idx == target)return A[target];
        return idx;
    }
}
