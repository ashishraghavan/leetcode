package com.leetcode.array;

/**
 * Given a date, return the corresponding day of the week for that date.
 *
 * The input is given as three integers representing the day, month and year respectively.
 *
 * Return the answer as one of the following values {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}.
 *
 *
 */
public class DayOfTheWeek {
    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(11,8,1987));//Saturday
    }

    //Jan 1st 1971 is Friday
    static String dayOfTheWeek(int day, int month, int year) {
        int noOfFebDays = isLeapYear(year)?29:28;
        int[] monthDayArray = new int[]{31,noOfFebDays,31,30,31,30,31,31,30,31,30,31};
        String[] daysStrArray = new String[]{"Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        boolean isLeapYear  = isLeapYear(year);
        int dayCount = 0;
        for(int i=1971;i<year;i++) {
            if(isLeapYear) {
                dayCount += 366;
            } else {
                dayCount += 365;
            }
        }
        for(int i=0;i<month-1;i++) {
            dayCount += monthDayArray[i];
        }
        //day count
        dayCount += day-1;
        int arrIndex = dayCount % 7;
        return daysStrArray[arrIndex];
    }

    static boolean isLeapYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        return year % 4 == 0;
    }
}
