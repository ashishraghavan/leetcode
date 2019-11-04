package com.leetcode.practice;

public class IsLeapYear {
    public static void main(String[] args) {
        int year = 2005;
        int lastTwo = year % 100;
        if(lastTwo % 4 == 0) {
            System.out.println("Leap!");
        } else {
            System.out.println("No Leap!!");
        }
    }
}
