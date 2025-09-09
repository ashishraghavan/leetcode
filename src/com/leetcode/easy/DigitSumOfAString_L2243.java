package com.leetcode.easy;

//prob # 2243 - digit sum of a string
public class DigitSumOfAString_L2243 {
    public static void main(String[] args) {
        //11111222223,3
        //00000000, 3
        System.out.println(digitSum("00000000",3));
    }

    public static String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder();
        while(s.length() > k) {
            int noOfGrp = s.length()/k;
            int grpReminder = s.length()%k;
            int start = 0,end = k;
            String subStr;
            int sum = 0;
            for(int i=0;i<noOfGrp;i++) {
                subStr = s.substring(start,end);
                for(int j=0;j<subStr.length();j++) {
                    sum += Character.digit(subStr.charAt(j),10);
                }
                sb.append(sum);
                start += k;
                end += k;
                sum = 0;
            }
            if(grpReminder != 0) {
                subStr = s.substring(start);
                for(int j=0;j<subStr.length();j++) {
                    sum += Character.digit(subStr.charAt(j),10);
                }
                sb.append(sum);
            }
            s = sb.toString();
            sb.setLength(0);
        }
        return s;
    }
}
