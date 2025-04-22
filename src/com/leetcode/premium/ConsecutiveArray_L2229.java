package com.leetcode.premium;

import java.util.Arrays;

//problem # 2229
//check https://github.com/doocs/leetcode/tree/main/solution/2200-2299/2229.Check%20if%20an%20Array%20Is%20Consecutive
//for
//more
//details
public class ConsecutiveArray_L2229 {
    public static void main(String[] args) {
        //1,3,4,2
        //1,3
        //3,5,4
        //4,8,6,9,3,5,7
        //4,8,6,9,3,7
        System.out.println(isConsecutive(new int[]{4,8,6,9,3,7}));
    }

    //solution #1 no optimization
    public static boolean isConsecutive(int[] A) {
        //O(nlogn)
        Arrays.sort(A);
        int[] _A = new int[A[A.length-1]+1];
        //O(n)
        for(int val:A) {
            ++_A[val];
        }
        //O(n)
        for(int i=A[0];i<A[A.length-1];i++) {
            if(_A[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
