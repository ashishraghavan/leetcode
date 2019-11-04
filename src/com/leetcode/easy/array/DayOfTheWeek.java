package com.leetcode.easy.array;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static java.util.Calendar.DAY_OF_WEEK;

public class DayOfTheWeek {
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(13,6,1987));
    }

    static String dayOfTheWeek(int day, int month, int year) {
        String[] daysStrArray = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        boolean isLeapYear  = isLeapYear(year);
        int days = isLeapYear ? 366 : 365;
        int weekCount = days/7;
        Map<Integer,Integer> monthDay = new HashMap<>();
        monthDay.put(1,31);
        monthDay.put(2,isLeapYear ? 29 : 28);
        monthDay.put(3,31);
        monthDay.put(4,30);
        monthDay.put(5,31);
        monthDay.put(6,30);
        monthDay.put(7,31);
        monthDay.put(8,31);
        monthDay.put(9,30);
        monthDay.put(10,31);
        monthDay.put(11,30);
        monthDay.put(12,31);

        int dayCount = 0;
        for(int i=1;i<month;i++) {
            dayCount += monthDay.get(i);
        }
        dayCount += day;
        int week = dayCount % 7;
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,day);
        int dayOfWeek = calendar.get(DAY_OF_WEEK);
        return "";
    }

    static boolean isLeapYear(int year) {
        int lastTwo = year % 100;
        return (lastTwo % 4 == 0);
    }
}
