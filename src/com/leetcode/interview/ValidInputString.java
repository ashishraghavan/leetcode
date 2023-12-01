package com.leetcode.interview;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidInputString {
    public static void main(String[] args) {
        //String str = "(){}[]";
        //str = "((({}{})])";
        String str = "(]";
        str = "";
        str = "[(())[{[]}]]";
        str = ")]{}";
        str = "([{}]";
        str = "]{{][]";
        str = "(([][][]{[]()}))";
        str = "][({})}[";
        System.out.println(isValid(str));
    }

    //is best solved using a stack, push character as they are
    //encountered. Since ch can only be one of the six
    // - '(', ')', '{', '}', '[', ']' when we see a closing bracket ) or } or ], we call
    //stack.peek() to check the last character pushed on the stack.
    //If this is not a matching opening brace, we return false
    //if ch is one of the closing brackets -
    private static boolean isValid(String str) {
        if (str == null) {
            //assuming null string as false
            return false;
        }
        if (str.isEmpty()) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }
            if (ch == ')' && (stack.isEmpty() || !stack.peek().equals('('))) {
                return false;
            } else if (ch == '}' && (stack.isEmpty() || !stack.peek().equals('{'))) {
                return false;
            } else if (ch == ']' && (stack.isEmpty() || !stack.peek().equals('['))) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
