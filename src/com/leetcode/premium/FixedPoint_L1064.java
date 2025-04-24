package com.leetcode.premium;

import java.util.Arrays;

//problem # 1064 fixed point
//check https://github.com/doocs/leetcode/blob/main/solution/1000-1099/1064.Fixed%20Point/README_EN.md
//for
//more
//details
public class FixedPoint_L1064 {
    public static void main(String[] args) {
        //-10,-5,0,3,7
        //0,2,5,8,17
        //-10,-5,3,4,7,9
        System.out.println(fixedPoint(new int[]{-10,-5,3,4,7,9}));
    }

    //NOTE:: suggest solution other than O(n)
    //-(insertion point) - 1
    //A[2] = 0, A[i] < i & A[i-1] < A[i] => A[i-1] < i i.e. A[1] < 2 => -5 < 2 & A[i-2,i-3...0] < 2 => A[0] <
    //i=2, A[i] = 0 < i & A[i-1] < A[i] => A[i-1] < 0 i.e. A[1] < 0 ==> go right of A[2]
    public static int fixedPoint(int[] A) {
        //binary search
        //target = A.length/2
        //int idx = Arrays.binarySearch(A,A[target]);
        //if(idx == target) return target;
        //else if A[target] < target -- repeat binary search on right sub-array
        //else -- repeat binary search on left sub-array
        int start = 0, end = A.length-1,res,target;
        while(end - start >= 0) {
            if (A[start] == start)return A[start];
            int mid = (end-start+1)/2;
            target = start+mid;
            res = A[target];
            if (res == target) {
                return A[res];
            } else if(A[target] < target){
                start = target+1;
            } else {
                end = target-1;
            }
        }
        return -1;
    }
}
