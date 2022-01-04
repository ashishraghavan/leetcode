package com.leetcode.bitmanipulation;

/**
 * The complement of an integer is the integer you get when you flip all the 0's to 1's and all
 * the 1's to 0's in its binary representation.
 *
 * For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
 * Given an integer n, return its complement.
 *
 * 101 - xor bits? 1 xo 0 = 1 xo 1 = 0
 * 1010 => 0101 = 0 + (2^2) + 0 + (2^0) = 4 + 1 = 5
 */
public class NumberComplement {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(betterBitwiseComplement(n));
    }

    @SuppressWarnings("unused")
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

    /**
     * 1. convert to binary string using built-in Integer.toBinaryString() method.
     * 2. traverse in reverse direction - start from last character of string from step 1.
     * 3. if this character is a 1, we are not interested in it because it will be changed to a 0 for 1st complement
     * 4. if this character is a 0, we do a Math.pow(2,x), where x = absolute value of (index of i + 1) - (binary string length)
     *      -- we do this to convert the binary string to decimal while we flip the bits. Also we are interested in
     *         only bits which are 0 because we will be flipping these to 1. The ones that are 1 will be flipped to 0
     *         & thus not being a part of the conversion to decimal.
     */
    static int betterBitwiseComplement(int n) {
        if(n == 1)return 0;
        if(n == 0)return 1;
        //n = 5
        String binStr = Integer.toBinaryString(n);
        //binstr = 101
        int bitVal = 0;
        int pow;
        for(int i=binStr.length()-1;i>=0;i--) {
            if(binStr.charAt(i) == '1')continue;
            pow = Math.abs((i+1) - binStr.length());
            bitVal += Math.pow(2,pow);
        }
        return bitVal;
    }
}
