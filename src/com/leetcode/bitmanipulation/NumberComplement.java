package com.leetcode.bitmanipulation;

/**
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and all
 * the 1's to 0's in its binary representation.
 *
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer n, return its complement.
 *
 * 101 - xor bits? 1 xo 0 = 1 xo 1 = 0
 */
public class NumberComplement {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(bitwiseComplement(n));
    }

    static int bitwiseComplement(int n) {
        if(n == 1)return 0;
        if(n == 0)return 1;
        //n = 5
        String binStr = Integer.toBinaryString(n);
        //binstr = 101
        char[] binChArr = binStr.toCharArray();
        for(int i = 0;i<binChArr.length;i++) {
            if(binChArr[i] == '1') {
                binChArr[i] = '0';
            } else {
                binChArr[i] = '1';
            }
        }
        binStr = String.valueOf(binChArr);
        return Integer.parseInt(binStr,2);
    }
}
