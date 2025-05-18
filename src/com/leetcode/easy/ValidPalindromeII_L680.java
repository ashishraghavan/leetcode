package com.leetcode.easy;

//problem # 680 - valid palindrome II
//TODO: pending - revisit problem
//check https://github.com/doocs/leetcode/tree/main/solution/0600-0699/0680.Valid%20Palindrome%20II for github solution
public class ValidPalindromeII_L680 {
    public static void main(String[] args) {
        //deeee
        //deeeedd
        //aba
        //abca
        //abc
        //dcqabaqcd
        //dqcababqd -> dqababqd || dqcabaqd
        //ashsa
        //ashisa
        //adshsca
        //System.out.println(validPalindrome("deeee"));
//        char[] abh = new char[26];
//        String alphabets = "abcdefghijklmnopqrstuvwxyz";
//        for(int i=0;i<alphabets.length();i++) {
//            abh[i] = alphabets.charAt(i);
//        }
//        for(int i=0;i<abh.length;i++) {
//            System.out.println(i + " = "+abh[i]);
//        }
    }

    //
    //atmost 1 => you can also remove zero characters i.e. string is already a palindrome
    //if isPalindrome(s) => return true
    //pointer f=0, l = s.length()-1, int diff = 0;
    //while(f<l) {
    //  if(s.charAt(f) != s.charAt(l)) break;
    // }
    // return (l-f == 1)
    public static boolean validPalindrome(String s) {
        if(s.length() == 1)return true;
        int[] bets = new int[26];
        //deeee -> bets[3] = 1, bets[4] = 4
        //ashisa -> bets[0], bets[]
        int f = 0, l = s.length()-1;
        while(f < l) {
            if(s.charAt(f) != s.charAt(l))break;
            f++;
            l--;
        }
        return f >= l || l-f == 1;
    }

    public static boolean validPalindromeII(String s) {
        return false;
    }

    private static boolean isPalindrome(String s) {
        return false;
    }
}
