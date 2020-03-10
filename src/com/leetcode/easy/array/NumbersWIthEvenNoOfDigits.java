package com.leetcode.easy.array;

/**
 * Given an array nums of integers, return how many of them contain an even number of digits.
 * Constraints
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 *
 * Solution implemented using the link <link>https://www.baeldung.com/java-number-of-digits-in-int</link>
 * under section <strong>Logarithmic Approach</strong>
 */
public class NumbersWIthEvenNoOfDigits {
    public static void main(String[] args) {
        //12,345,2,6,7896
        //555,901,482,1771
        System.out.println(findNumbers(new int[]{555,901,482,1771}));
    }

    /**
     * There is no log 0 base 10. But, in constraints, it is given nums[i] is between (including) 1 and 10 ^ 5. Therefore, we are not checking for 0
     * @param nums The array of numbers
     * @return The number of integers in the array whose count of digits is an even number.
     */
    private static int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            if(((int)(Math.log10(num) + 1)) % 2 == 0) {
                //Number has even digits
                count++;
            }
        }
        return count;
    }
}
