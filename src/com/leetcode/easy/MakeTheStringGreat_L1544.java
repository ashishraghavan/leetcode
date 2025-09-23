package com.leetcode.easy;

import java.util.Stack;

//TODO: [revise] very good problem on Stack
//prob # 1544 - make the string great
public class MakeTheStringGreat_L1544 {
    public static void main(String[] args) {
        //leEeetccCoDddDde
        //leEeetcode
        //abBAcC
        //s
        //hHcOzoC
        System.out.println(makeGoodII("hHcOzoC"));
    }

    //leEeetccCoDddDde -> leetcode
    //abBAcC    a=97, A=65
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int i;
        for(i=0;i<=s.length()-2;i++) {
            if(Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(i+1))
                    && ((Character.isLowerCase(s.charAt(i)) && Character.isUpperCase(s.charAt(i+1)))
                    || (Character.isUpperCase(s.charAt(i)) && Character.isLowerCase(s.charAt(i+1))))) {
                i++;
                continue;
            }
            sb.append(s.charAt(i));
        }
        System.out.println("i = "+i);
        if(i == s.length() - 1) sb.append(s.charAt(i));
        return sb.toString();
    }

    //from google search solution - use stack data structure to push or pop last inserted character
    // if lowercase(current_char) = uppercase(previous_char) or uppercase(current_char) = lowercase(previous_char)
    //abBAcC
    //leEeetccCoDddDde
    //hHcOzoC
    public static String makeGoodII(String s) {
        Stack<Character> stk = new Stack<>();
        stk.push(s.charAt(0));
        for(int i=1;i<s.length();i++) {
            char currCh = s.charAt(i);
            if(stk.isEmpty()){
                stk.push(currCh);
                continue;
            }
            Character lastCh = stk.peek();
            if(Character.toLowerCase(currCh) == Character.toLowerCase(lastCh) &&
                    ((Character.isLowerCase(currCh) && Character.isUpperCase(lastCh)) ||
                            (Character.isUpperCase(currCh) && Character.isLowerCase(lastCh)))) {
                stk.pop();
            } else {
                stk.push(currCh);
            }
        }
        StringBuilder sb = new StringBuilder(s.length());
        while(!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
