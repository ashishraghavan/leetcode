package com.leetcode.easy;

//prob # 1491 - avg salary excluding min & max salary
public class AvgSalaryExcludingMinAndMaxSalary_L1491 {
    public static void main(String[] args) {
        //4000,3000,1000,2000
        //1000,2000,3000
        System.out.println(average(new int[]{1000,2000,3000}));
    }

    //all salaries are unique therefore 2nd is a better choice for ths problem
    //1. sort & return (sum of all elements except first & last)/no_of_elements - 2
    //2. find max, min in single pass & store them, iterate array, sum all elements except max & min, return sum/no_of_elements-2
    public static double average(int[] salary) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int sal : salary) {
            max = Math.max(max,sal);
            min = Math.min(min,sal);
        }
        double sum = 0;
        for(int sal : salary) {
            if(sal != max && sal != min) {
                sum += sal;
            }
        }
        return sum/(salary.length-2);
    }
}
