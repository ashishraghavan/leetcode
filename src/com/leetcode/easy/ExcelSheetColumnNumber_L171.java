package com.leetcode.easy;

//prob # 171 - excel sheet column number
public class ExcelSheetColumnNumber_L171 {
    public static void main(String[] args) {
        //A
        //AB
        //ZY
        //FXSHRXW
        System.out.println(titleToNumber("FXSHRXW"));
    }

    //A=1...Z=26
    //ZY = 26^0 * 25 + 26^1 * 26 = 701
    //AB = 26^0 * 2 + 26^1 * 1 = 28
    public static int titleToNumber(String columnTitle) {
        int cnt = 0;
        int title = 0;
        for(int i=columnTitle.length()-1;i>=0;i--) {
            System.out.println(columnTitle.charAt(i)-'A'+1);
            title += (int)Math.pow(26,cnt++) * (columnTitle.charAt(i)-'A'+1);
        }
        return title;
    }
}
