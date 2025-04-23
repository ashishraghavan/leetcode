package com.leetcode.premium;

//problem # 3353
//check https://github.com/doocs/leetcode/tree/main/solution/3300-3399/3353.Minimum%20Total%20Operations
//for
//more
//details
//TODO: IMPORTANT!!, review
public class MinimumTotalOperations_L3353 {
    public static void main(String[] args) {
        //3,5,0,7,4
        //1,4,2
        //0,5,3,4,7
        System.out.println(minTotalOps(new int[]{0,5,3,4,7}));
    }

    //1,4,2 -- INCORRECT METHOD OF FINDING AVERAGE!! CHECK SOLUTION IN GIVEN LINK ABOVE
    public static int minTotalOps(int[] A) {
        /*
            1,4,2
        * avg = 1+4+2 = 7/3 = 2.3333 ~= 2, make all elements = 2
        *

            3,5,0,7,4
            avg = 19/5 = 3.8 ~= 4
            -3 -> 0,2,-3,4,4
            7 -> 7,9,4,4,4
            -5 -> 2,4,4,4,4
            2 -> 4,4,4,4,4
            So min steps = 4?


            0,5,3,4,7 -> avg = 19/5 ~= 4
            -3 -> -3,2,0,1,4
            3 -> 0,5,3,4,4
            1 -> 1,6,4,4,4
            -2 -> -1,4,4,4,4
            5 -> 4,4,4,4,4
        * */
        if(A.length == 1) return 0;
        int ops = 0;
        for(int i=1;i<A.length;i++) {
            if(A[i] != A[i-1]) {
                ++ops;
            }
        }
        return ops;
    }
}
