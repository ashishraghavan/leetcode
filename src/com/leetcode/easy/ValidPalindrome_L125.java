package com.leetcode.easy;

//prob # 125 - valid palindrome
public class ValidPalindrome_L125 {
    public static void main(String[] args) {
        //A man, a plan, a canal: Panama
        //race a car
        System.out.println(isPalindrome("A man, a plan, a canal: Ponama"));
    }

    //i=0,j=s.length()-1, while i<j, if
    //learn about important methods in Character class
    public static boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i < j) {
            if(!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--)))return false;
        }
        return true;
    }
}
