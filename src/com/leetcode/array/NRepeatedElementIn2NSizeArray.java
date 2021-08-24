package com.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Question : In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
 * Return the element repeated N times.
 * <p>
 * The minimum size of the array is 4 and array size is 2N. Therefore, Size of the array = 2N and N >= 2 i.e N is at least equal
 * to 2 always. Since there are N + 1 unique elements, we have to make sure that we iterate over only N + 2 elements to get the
 * repeated element. This is because there are N+1 unique elements, there is only one element that is repeated and N+2 elements
 * will give us the repeated element in all cases irrespective of number of elements in the array. Therefore, running a loop
 * from 0 to equals to N and adding values to a set until we find a repeated element will give us the answer.
 * <p>
 * Runtime: 1 ms
 * Memory Usage: 39.6 MB
 */
public class NRepeatedElementIn2NSizeArray {
    public static void main(String[] args) {
        //1,2,3,3
        //2,1,2,5,3,2
        System.out.println(repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }

    private static int repeatedNTimes(int[] array) {
        int N = array.length / 2;
        Set<Integer> repeatedSet = new HashSet<>();
        for (int i = 0; i <= N; i++) {
            if (repeatedSet.contains(array[i])) {
                return array[i];
            } else {
                repeatedSet.add(array[i]);
            }
        }
        return array[N + 1];
    }
}
