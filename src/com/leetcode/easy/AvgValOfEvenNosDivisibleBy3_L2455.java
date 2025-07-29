package com.leetcode.easy;

//prob # 2455 - average value of even numbers divisible by 3
public class AvgValOfEvenNosDivisibleBy3_L2455 {
    public static void main(String[] args) {
        //1,3,6,10,12,15
        //1,2,4,7,10
        //{652, 122, 876, 908, 547, 257, 783, 812, 1, 27, 832, 28, 594, 240, 124, 517, 461, 51, 745, 133}
        //734, 869, 787, 256, 976, 996, 864, 17, 538, 509, 820, 389, 851, 654, 930, 859, 495, 432, 328, 827, 853, 686, 21, 204, 332, 953, 509, 896, 177, 213, 360, 777, 743, 377, 96, 708, 30, 765, 729, 359
        System.out.println(averageValue(new int[]{652, 122, 876, 908, 547, 257, 783, 812, 1, 27, 832, 28, 594, 240, 124, 517, 461, 51, 745, 133}));
    }

    public static int averageValue(int[] nums) {
        int sum = 0, cnt = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                cnt++;
            }
        }
        return cnt == 0 ? 0 : sum/cnt;
    }
}
