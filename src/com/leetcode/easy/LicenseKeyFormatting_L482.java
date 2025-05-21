package com.leetcode.easy;

//problem # 482 license key formatting
//TODO: review, somewhat good string problem
//see problem discussion for better solution, also check https://github.com/doocs/leetcode/tree/main/solution/0400-0499/0482.License%20Key%20Formatting for github solution
public class LicenseKeyFormatting_L482 {
    public static void main(String[] args) {
        //"2-5g-3-J", k = 2
        //"5F3Z-2e-9-w", k = 4
        //abcd-9eheuiwuei-5i-e-902-ieow, k=3
        //r, k=1
        //"a-----a", k=2
        //"---", k=3
        //"-", k=2
        System.out.println(licenseKeyFormatting("-",2));
    }

    //questions - none
    //5F3Z-2e-9-w, k = 4 -> 5-F3Z2- | ignore dashes, count no of alphanumeric characters, divide count of characters by k
    //how many characters should the first group contain
    //if count(chars_other_than_dash)%k == 0, first group can contain k chars or else first group
    //can contain count(chars_other_than_dash)/k chars

    //abcd-9eheuiwuei-5i-e-902-ieow, k=3, 24 alphanumeric chars, 24/3 = 8 groups, first group can contain k chars
    //abc-d9e-heu-iwu-ei5-ie9-02i-eow
    //TODO: inefficient solution because of use of insert()!
    public static String licenseKeyFormatting(String s, int k) {
        if(s.length() == 1 && s.charAt(0)!='-') {
            return s.toUpperCase();
        }
        StringBuilder sb = new StringBuilder();
        int charCt = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)!='-') {
                charCt++;
                sb.append(s.charAt(i));
            }
        }
        if(charCt == 0) {
            return "";
        }
        int fGrpChCt = charCt % k == 0 ? k : charCt%k;
        if(fGrpChCt >= sb.length()) {
             return sb.toString().toUpperCase();
        }
        sb.insert(fGrpChCt,'-');
        for(int i=fGrpChCt+k+1;i<sb.length();i=i+k+1) {
            sb.insert(i,'-');
        }
        return sb.toString().toUpperCase();
    }
}
