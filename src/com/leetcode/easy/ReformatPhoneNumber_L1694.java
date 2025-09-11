package com.leetcode.easy;

//prob #1694 - reformat phone number
public class ReformatPhoneNumber_L1694 {
    public static void main(String[] args) {
        //123 4-567
        //123 4-5678
        //1-23-45 6
        //1234567893420 (13)
        System.out.println(reformatNumber("123 4-567"));
    }

    //12345678 - 8/3 groups of 3 = 2 groups of 3
    //1234567893420 - 13/3 groups of 3 = 4 groups of 3 & 13%3 in last group
    //so 3 groups of 3 = 9, remaining = 13-9=4
    public static String reformatNumber(String number) {
        number = number.replaceAll("\\s+","");
        number = number.replaceAll("-","");
        StringBuilder sb = new StringBuilder();
        //System.out.println(number);
        int len = number.length();
        int grp = len/3;
        int lastGrp = len % 3;
        if(lastGrp == 1) {
            grp -= 1;
            lastGrp = len - (grp*3);
        }
        int start = 0,end = 3;
        for(int i=0;i<grp;i++) {
            sb.append(number, start, end).append("-");
            start += 3;
            end += 3;
        }
        if(lastGrp == 4) {
            String reminderStr = number.substring(start);
            sb.append(reminderStr, 0, 2).append("-").append(reminderStr.substring(2));
        } else {
            sb.append(number.substring(start));
        }
        String res = sb.toString();
        return res.endsWith("-") ? res.substring(0,res.length()-1) : res;
    }
}
