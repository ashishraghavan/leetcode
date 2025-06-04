package com.leetcode.easy;

//problem # 2259 - remove digit from number to maximize result
public class RemoveDigitFromNumberToMaximizeResult_L2259 {
    public static void main(String[] args) {
        //1231, 1
        //123, 1
        //551, 5
        //788788888888887887, 7
        System.out.println(removeDigit("788788888888887887",'7'));
    }

    //84395023842340923329848475803923203984023948457
    //788788888888887887 7 -> 88788888888887887, 78888888888887887, 78878888888888887, 78878888888888788
    //9999699999999999999999699999999999999699999999999969999999999999996999999999999999999996999999969966, 6
    //INEFFICIENT SOLUTION
    public static String removeDigit(String number, char digit) {
        String res = "";
        String subStr,pre;
        for(int i=0;i<number.length();i++) {
            if(number.charAt(i) == digit) {
                pre = number.substring(0,i);
                subStr = i+1 < number.length() ? pre + number.substring(i+1) : pre;
                String result = isBigger(subStr,res);
                if(result!= null && result.equals(subStr)) {
                    res = subStr;
                }
            }
        }
        return res;
    }

    //s1, s2 will be of same length
    private static String isBigger(String s1,String s2) {
        if(s1.isEmpty() || s2.isEmpty()) {
            return s1.isEmpty() ? s2 : s1;
        }
        for(int i=0;i<s1.length();i++) {
            int s1N = Character.digit(s1.charAt(i),10);
            int s2N = Character.digit(s2.charAt(i),10);
            if(s1N == s2N)continue;
            return s1N > s2N ? s1 : s2;
        }
        //can never happen
        return null;
    }
}
