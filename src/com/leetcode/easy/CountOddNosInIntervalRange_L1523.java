package com.leetcode.easy;

//problem #1523 - count odd nos in interval range
public class CountOddNosInIntervalRange_L1523 {
    public static void main(String[] args) {
        //3,7
        //8,10
        //2,3
        //6,9
        //4,9
        System.out.println(countOdds(4,9));
    }

    //3,7 -> 3,4,5,6,7, total nos = 7-3+1 = 5 = odd, odd nos ~= 5/2 = res = 2, if first no is odd return res+1
    //4,8 -> 4,5,6,7,8 total nos = 8-4+1 = 5 = odd, odd nos ~= 5/2 = res = 2, first no != odd return res
    //4,9 -> 4,5,6,7,8,9 total nos = 9-4+1 = 6 = even, odd nos ~= 6/2 = res = 3, return res
    //5,10 -> 5,6,7,8,9,10 total nos = 6 = even, odd nos ~= 6/2 = res = 3, return res
    //2,3 -> 2,3 total nos = 3-2+1 = 2 = even, odd nos ~= 2/2 = res = 1, first no != odd return res
    //6,9 -> 6,7,8,9 total nos = 9-6+1 = 4 = even, odd nos ~= 4/2 = res = 2, return res
    public static int countOdds(int low, int high) {
        int totalNos = high-low+1,res=totalNos/2;
        if(totalNos % 2 == 0) return res;
        return (low % 2 != 0) ? res+1 : res;
    }
}
