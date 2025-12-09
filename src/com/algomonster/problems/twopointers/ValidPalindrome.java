package com.algomonster.problems.twopointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        //Do geese see God?
        //Was it a car or a cat I saw?
        //A brown fox jumping over
        //"A man, a plan, a canal: Panama"
        //"race a car"
        //"No lemon, no melon"
        //"Eva, can I see bees in a cave?"
        //"Able was I, ere I saw Elba"
        //"Palindrome"
        System.out.println(isPalindrome("Palindrome"));
    }

    //
    public static boolean isPalindrome(String s) {
        int f = 0, l = s.length()-1;
        while(f < l) {
            if(!Character.isLetterOrDigit(s.charAt(f))) {
                f++;
                continue;
            } else if(!Character.isLetterOrDigit(s.charAt(l))) {
                l--;
                continue;
            }
            if((Character.isDigit(s.charAt(f)) && s.charAt(f) != s.charAt(l)) ||
                    (Character.isDigit(s.charAt(l)) && s.charAt(l) != s.charAt(f))) {
                return false;
            }
            if(Character.toLowerCase(s.charAt(f)) != Character.toLowerCase(s.charAt(l))) {
                return false;
            }
            f++;
            l--;
        }
        return true;
    }
}
