package com.leetcode.interview;

import java.util.ArrayDeque;
import java.util.Deque;

public class SingleValidParenthesis {
    public static void main(String[] args) {
        //(abc)
        //)((]()][](
        //(ab(c)
        //(abc
        //null
        String str = ")ab(c)";
        System.out.println(hasSingleValidPairOfParenthesis(str));
    }

    //from the examples I am assuming that parenthesis
    //to consider are '(' & ')' and there can be more
    //than a pair of valid parenthesis i.e. a string such
    //as (a+(b+c)) is correct & (a+b) is also correct
    //whereas )a+b) & [a+b) is incorrect
    static boolean hasSingleValidPairOfParenthesis(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
                continue;
            }
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek().equals('(')) {
                    return true;
                }
            }
        }
        return stack.isEmpty();
    }
}
