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
 *
 * Solution got from https://leetcode.com/problems/add-strings/discuss/480958/Simple-Java-Soltn
 *
 * If you do int a = '0', b = '9' a will be equal to 48, b will be equal to 57.
 * Loop should check if either a or b has any characters left or carry != 0. Go in and process if these
 * conditions are met. The subtraction by '0' is needed because we are using the character values of numbers
 * i.e 57 for '9', 48 for '0'. On subtracting by '0', we get the intended value.
 *
 * int i = num1.length()-1;
 *         int j = num2.length()-1;
 *         int carry = 0;
 *
 *         StringBuilder ans = new StringBuilder("");
 *
 *         while( i >= 0 || j >=0 || carry != 0){
 *
 *             char  a = i >=0 ? num1.charAt(i) : '0';
 *             char  b = j >=0 ? num2.charAt(j) : '0';
 *
 *             int c =  a + b + carry -'0' -'0' ;
 *
 *             ans.append(c%10);s
 *             carry = c/10;
 *             i--;j--;
 *         }
 *
 *         return ans.reverse().toString();
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
