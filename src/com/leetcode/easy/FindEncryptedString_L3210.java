package com.leetcode.easy;

//prob # 3210 - find the encrypted string
public class FindEncryptedString_L3210 {
    public static void main(String[] args) {
        System.out.println(getEncryptedString("data",3));
    }

    public static String getEncryptedString(String s, int k) {
        StringBuilder sb = new StringBuilder(s.length());
        int reqIdx;
        for(int i=0;i<s.length();i++) {
            reqIdx = (i+k) % s.length();
            sb.append(s.charAt(reqIdx));
        }
        return sb.toString();
    }
}
