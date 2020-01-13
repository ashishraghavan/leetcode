package com.leetcode.easy.strings;

/**
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 *  'A' : Absent.
 *  'L' : Late.
 *  'P' : Present.
 *  A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 *  You need to return whether the student could be rewarded according to his attendance record.
 *
 *  Example 1:
 *  Input: "PPALLP"
 *  Output: True
 *  Example 2:
 *  Input: "PPALLL"
 *  Output: False
 */
public class StudentAttendanceRecord {
    public static void main(String[] args) {
        //PPALLP
        //PPALLL
        System.out.println(checkRecord("LLLPALLPPLPLLL"));
    }

    static boolean checkRecord(String record) {
        char[] recordChar = record.toCharArray();
        int aCount = 0;
        for(int i=0;i<recordChar.length;i++) {
            if(recordChar[i] == 'A') {
                aCount++;
                if(aCount > 1) return false;
                continue;
            }
            if(recordChar[i] == 'L') {
                if(i>1 && recordChar[i-1] == 'L' && recordChar[i-2] == 'L') {
                    return false;
                }
            }
        }
        return true;
    }
}
