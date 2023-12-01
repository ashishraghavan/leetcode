package com.leetcode.interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

//Q : What is the size of the input array?
public class LargestNumberFromIntegerArray {
    public static void main(String[] args) {
        int[] A = new int[]{9, 34, 5, 3, 30}; //---exp. o/p.----> "9534330"
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

    //if (((str1 == null || str1.isEmpty()) &&
    //                    (str2 == null || str2.isEmpty())) || str1.equals(str2))
    static class NumberStrComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            //if str1 = null & str2 = null
            if ((str1 == null || str1.isEmpty())
                    || (str2 == null || str2.isEmpty())
                    || (str1.equals(str2))) {
                return 0;
            }
            return (Integer.parseInt(str1+str2) > Integer.parseInt(str2 + str1))?-1:1;
        }
    }
}
