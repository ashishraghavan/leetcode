package com.leetcode.easy;

//problem # 392 - is subsequence
public class IsSubsequence_L392 {
    public static void main(String[] args) {
        //dbaac, diaboaalical
        //dbaac, iaboldicalaa
        //"abc","ahbgdc"
        System.out.println(isSubsequence("baacd","biaboldicalaa"));
    }

    //dbaac, diaboaalical
    //dbaac, iaboldicalaa
    //using indexOf
    public static boolean isSubsequence(String s, String t) {
        if(s.length() > t.length())return false;
        int currPos;
        int lastPos = -1;
        for(int i=0;i<s.length();i++) {
            currPos = t.indexOf(s.charAt(i),lastPos+1);
            if(currPos == -1 || currPos <= lastPos)return false;
            lastPos = currPos;
        }
        return true;
    }
}
