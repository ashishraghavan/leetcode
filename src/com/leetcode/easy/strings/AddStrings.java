package com.leetcode.easy.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("4934953045893099","34989385938948"));
    }

    static String addStrings(String num1, String num2) {
        Map<Character,Integer> numberMap = new HashMap<>();
        numberMap.put('0',0);
        numberMap.put('1',1);
        numberMap.put('2',2);
        numberMap.put('3',3);
        numberMap.put('4',4);
        numberMap.put('5',5);
        numberMap.put('6',6);
        numberMap.put('7',7);
        numberMap.put('8',8);
        numberMap.put('9',9);

        int lengthDifference = Math.abs(num1.length() - num2.length());
        StringBuilder numberBuilder;
        if(num1.length() < num2.length()) {
            //num1 is the smaller number. Prepend zeroes.
             numberBuilder = new StringBuilder();
            for(int i=0;i<lengthDifference;i++) {
                numberBuilder.append("0");
            }
            num1 = numberBuilder.append(num1).toString();
        } else if(num2.length() < num1.length()) {
            //num2 is smaller.
            numberBuilder = new StringBuilder();
            for(int i=0;i<lengthDifference;i++) {
                numberBuilder.append("0");
            }
            num2 = numberBuilder.append(num2).toString();
        }

        int numPtr = num1.length() - 1;

        int total;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while(numPtr >=0 ) {
            int no1 = numberMap.get(num1.charAt(numPtr));
            int no2 = numberMap.get(num2.charAt(numPtr));
            total = no1 + no2 + carry;
            carry = 0;
            if(total > 9) {
                //add to the carry
                carry = total / 10;
                result.append(total%10);
            } else {
                result.append(total);
            }
            --numPtr;
        }
        if(carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
