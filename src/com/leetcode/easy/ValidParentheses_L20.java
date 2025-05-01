package com.leetcode.easy;

import java.util.Stack;

//problem # 20, attempted & passed
public class ValidParentheses_L20 {
    public static void main(String[] args) {
        //(]
        //()[]{}
        //()
        //([])
        //({[{{[]}}]})
        System.out.println(isValid("({[{{[]}[]})"));
    }

    //([{
    public static boolean isValid(String s) {
        //()[]{}
        //({[{{[]}}]})
        //use stack,
        //if curr char is ( or { or [, push to stack
        //if curr char is ) or } or ], pop from stack to check matching
        //opening character i.e. for ), popped char should be (, for } it should be { and for ] it should be [
        //if not return false
        //if stack is empty means all characters matched correctly, return true
        if(s.length() == 1)return false;
        Stack<Character> stCh = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                stCh.push(ch);
            } else {
                if(stCh.isEmpty()) {
                    return false;
                }
                char last = stCh.pop();
                if((ch == ')' && last != '(') || (ch == '}' && last != '{') || (ch == ']' && last != '[')) {
                    return false;
                }
            }
        }
        return stCh.isEmpty();
    }
}
