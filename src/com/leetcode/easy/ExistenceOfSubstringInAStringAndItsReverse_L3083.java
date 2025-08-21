package com.leetcode.easy;

//prob # 3083 - existence of substring in a string and its reverse
//check https://github.com/doocs/leetcode/tree/main/solution/3000-3099/3083.Existence%20of%20a%20Substring%20in%20a%20String%20and%20Its%20Reverse for solution using 2D array/hashtable
public class ExistenceOfSubstringInAStringAndItsReverse_L3083 {
    public static void main(String[] args) {
        //leetcode
        //abcba
        //abcd
        //leafbcaef
        System.out.println(isSubstringPresent("leafbcaef"));
    }

    //leetcode
    //[0.0.1.1.3....1...........1....]
    //edocteel
    //abcba
    //abcba
    //[2,2,1]
    //dzfbgzdfb
    public static boolean isSubstringPresent(String s) {
        StringBuilder sb = new StringBuilder(2);
        for(int i=1;i<s.length();i++) {
            sb.setLength(0);
            if(s.charAt(i) == s.charAt(i-1))return true;
            sb.append(s.charAt(i)).append(s.charAt(i-1));
            if(s.indexOf(sb.toString(),i) > 0)return true;
        }
        return false;
    }
}
