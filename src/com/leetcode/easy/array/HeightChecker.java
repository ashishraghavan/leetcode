package com.leetcode.easy.array;

import java.util.Arrays;

/**
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 * HINT : Build the correct order of heights by sorting another array, then compare the two arrays.
 */
public class HeightChecker {
    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{46, 82, 7, 10, 92, 57, 48, 81, 47, 22, 14, 68, 26, 3, 48, 79, 24, 12, 87, 40, 36, 9, 44, 60, 58, 62, 4, 67, 91, 88, 38, 22, 52, 76, 27, 66, 58, 90, 83, 51, 7, 68, 33, 38, 91, 55, 80, 83, 28, 51, 67, 41, 32, 88, 44, 68, 100, 4, 9, 60, 68, 82, 20, 51, 25, 63, 13, 20, 38, 93, 38, 23, 31, 47, 87, 79, 7, 44, 20, 57, 9, 85, 78, 95, 11, 30, 83, 37, 45, 48, 66, 87, 86, 22, 45, 34, 12, 63, 3, 12}));
    }

    /**
     * Space complexity would be O(N) because you are creating an exact copy
     * of the original array which is of length N. time complexity would be O(N)
     * because you are iterating over all N elements for getting the difference
     * count.
     *
     * @param heights the heights array of students
     * @return the number of moves to be made
     */
    private static int heightChecker(int[] heights) {
        int[] sortedArray = Arrays.copyOf(heights, heights.length);
        //[0,1,1,3,4,4,5,5]
        //[1,1,4,3,4,5,5,0]
        Arrays.sort(sortedArray);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sortedArray[i]) {
                count++;
            }
        }
        return count;
    }
}
