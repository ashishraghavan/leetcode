package com.leetcode.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

//Q : What is the range of size of the input array?
//Q : does array only contain positive integers? - assuming yes
public class LargestNumberFromIntegerArray {
    public static void main(String[] args) {
        //9, 34, 5, 3, 30 ---exp. o/p.----> "9534330"
        int[] A = new int[]{9, 22, 5, 3, 22}; //---exp. o/p.----> "9532222"
        System.out.println(largestNumberFromArray(A));
    }

    static String largestNumberFromArray(int[] A) {
        if (A.length == 0) {
            System.out.println("Array has 0 elements");
            return null;
        }
        return Arrays.stream(A)
                .mapToObj(Integer::toString)
                .sorted(new NumberStrComparator())
                .collect(Collectors.joining());
    }

    static class NumberStrComparator implements Comparator<String> {

        //Neither str1 nor str2 will ever be null/empty or a non-positive integer
        //Therefore, only checking for equality & comparison for sorting in descending order
        @Override
        public int compare(String str1, String str2) {
            if (str1.equals(str2)) {
                return 0;
            }
            return (Integer.parseInt(str1+str2) > Integer.parseInt(str2 + str1))?-1:1;
        }
    }
}
