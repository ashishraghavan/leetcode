package com.leetcode.easy;

//prob #693 - binary number with alternating bits
public class BinaryNumberWithAlternatingBits_L693 {
    public static void main(String[] args) {
        //11 - 1011
        //1998 - 11111001110
        System.out.println(hasAlternatingBits(1998));
    }

    //xor of 1 & 0 = 1, xor of 0 & 1 = 1
    //xor of 1 & 1 = 0, xor of 0 & 0 = 0
    //5 -> 101 -> for i in 0,ns.length-2 if xor(ns[i] * ns[i+1] == 0)return false
    //11 -> 1011
    public static boolean hasAlternatingBits(int n) {
        String ns = Integer.toBinaryString(n);
        System.out.println(ns);
        for(int i=0;i<=ns.length()-2;i++) {
            int curr = Character.digit(ns.charAt(i),2);
            int next = Character.digit(ns.charAt(i+1),2);
            if((curr ^ next) == 0)return false;
        }
        return true;
    }
}
