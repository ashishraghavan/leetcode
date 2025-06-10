package com.leetcode.easy;

//problem # 1790 - check if one string swap can make strings equal
public class AreAlmostEqual_L1790 {
    public static void main(String[] args) {
        //s1 = "bank", s2 = "kanb"
        //s1 = "attack", s2 = "defend"
        //s1 = "kelb", s2 = "kelb"
        //"boyaa", "aoaby"
        //"boyaa", "aoaby"
        //"boyaa", "aoyab"
        //apprehend, ppprehend
        //caa, aaz
        System.out.println(areAlmostEqual("caa","aaz"));
    }

    //s1 = "bank", s2 = "kanb" -> map: {b:1,a:1,n:1,k:1}, iterate s2 decrement count in map against character.
    //
    // Finally, if there is any value in the map > return false else return true

    //"boyaa", "aoaby" -> map: {0:b,1:o,2:y,3:a,4:a}
    //"boyaa", "aoyab" b!=a, a!=b ->
    //"boyaa", "aoayb" b!=a, y!=a, a!=y, a!=b
    //first = b, second = a -> a!=b => first = a, second = b
    //caa, aaz -> first = c, second = a, a = a, b = z
    public static boolean areAlmostEqual(String s1, String s2) {
        char first = '\0', second = '\0',diff = 0;
        for(int i=0;i<s1.length();i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if(a != b) {
                if(++diff > 2)return false;
                if(first == '\0' && second == '\0') {
                    first = a;
                    second = b;
                    continue;
                }
                if(a!=second || b!=first)return false;
            }
        }
        return (diff == 0 || diff == 2);
    }
}
