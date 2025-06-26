package com.leetcode.easy;

//problem # 58 - length of last word
public class LengthOfLastWord_L58 {
    public static void main(String[] args) {
        //Hello World
        //"   fly me   to   the moon     "
        //luffy is still joyboy
        //"     blue   "
        //"blue   "
        System.out.println(lengthOfLastWord("blue   "));
    }

    //start iterating from end ignoring spaces, stop on reaching first non-space character
    //mark this as i, start decrementing i till you encounter space or you reach 0. Mark this as j
    //return j-i+1 as answer
    public static int lengthOfLastWord(String s) {
        int k = s.length()-1;
        for(;k >= 0; k--) {
            if(!Character.isWhitespace(s.charAt(k))) {
                break;
            }
        }
        int start = k,end = -1;
        for(int j=k;j>=0;j--) {
            if(Character.isWhitespace(s.charAt(j))) {
                end = j;
                break;
            }
        }
        return (end == -1) ? start + 1 : start - end;
    }
}
