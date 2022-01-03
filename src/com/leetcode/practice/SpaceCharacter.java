package com.leetcode.practice;

public class SpaceCharacter {
    public static void main(String[] args) {
        String str = "EnjoyyourCoffee";
        int len = str.length() + 2;
        char[] modArr = new char[len];
        //insert space at index 5, 9 => insert space at index 5, 10
        modArr[5] = ' ';
        modArr[10] = ' ';
        int count = 0;
        for(int i = 0;i < str.length();i++) {
            if(Character.isSpaceChar(modArr[count])) {
                count++;
            }
            modArr[count++] = str.charAt(i);
        }
        System.out.println(modArr);
    }
}
