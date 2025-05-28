package com.leetcode.easy;

//problem # 2609 - longest balanced substring of a binary string
//check https://github.com/doocs/leetcode/tree/main/solution/2600-2699/2609.Find%20the%20Longest%20Balanced%20Substring%20of%20a%20Binary%20String for github solution
public class LongestBalancedSubstringOfBinaryString_L2609 {
    public static void main(String[] args) {
        //01000111
        //010101100110
        //000111100000
        //111111
        //000000
        //001000
        //0000111000111
        System.out.println(findTheLongestBalancedSubstring("0000111000111"));
    }

    //01000111
    //010101100110
    //doesn't pass all test cases, check github solution using enumeration optimization (somewhat similar to below)
    public static int findTheLongestBalancedSubstring(String s) {
        int zeroCt = 0,oneCt = 0,maxCt = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '0') {
                zeroCt++;
                oneCt = 0;
            } else {
                oneCt++;
                if(oneCt == zeroCt) {
                    maxCt = Math.max(maxCt,oneCt+zeroCt);
                    zeroCt = 0;
                    oneCt = 0;
                } else if(oneCt > zeroCt) {
                    zeroCt = 0;
                    oneCt = 0;
                } else {
                    //zeroCt > oneCt
                    maxCt = Math.max(maxCt,oneCt*2);
                }
            }
        }
        return maxCt;
    }
}
