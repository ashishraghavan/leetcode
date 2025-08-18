package com.leetcode.easy;

//TODO: pending optimization (solution passing)
//prob # 868 - binary gap
public class BinaryGap_L868 {
    public static void main(String[] args) {
        //22
        //8
        //5
        //513 = 1000000001
        //9799847 = 100101011000100010100111
        System.out.println(binaryGap(9799847));
    }

    //22 = 10110
    //get positions of two 1's with maximum no of zeroes between them
    //sliding window
    //get me first index of 1(fidx), set i=fidx, j=i+1
    //227 = 11100011
    public static int binaryGap(int n) {
        String bin = Integer.toBinaryString(n);
        int idxOf1 = bin.indexOf("1");
        if(idxOf1 < 0)return 0;
        int i=idxOf1,j=i+1;
        int diff = 0;
        while(j < bin.length()) {
            if(bin.charAt(j) == '1') {
                diff = Math.max(diff,j-i);
                i=j;
            }
            j++;
        }
        return diff;
    }
}
