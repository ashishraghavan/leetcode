package com.leetcode.easy;

//problem # 168 - excel sheet column title
//TODO: revise
//check https://github.com/doocs/leetcode/tree/main/solution/0100-0199/0168.Excel%20Sheet%20Column%20Title for github solution
public class ExcelSheetColumnTitle_L168 {
    public static void main(String[] args) {
        //701
        //28
        //1
        System.out.println(convertToTitle(701));
    }

    //    A -> 1
    //    B -> 2
    //    C -> 3
    //            ...
    //    Z -> 26
    //    AA -> 27
    //    AB -> 28
    //    AC -> 29
    //            ...
    //    AZ -> 52, 26*2
    //    BA -> 53, BB - 54

    //github solution!
    public static String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber != 0) {
            --columnNumber;
            res.append((char) ('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        return res.reverse().toString();
    }
}
