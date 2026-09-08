package com.leetcode.medium.binary_search_on_answer;

//#875
//refer https://share.gemini.google/D2ycjHYZ45ls
public class KokoEatingBananas {
    public static void main(String[] args) {
        //3,6,7,11|8
        //30,11,23,4,20|6
        //30,11,23,4,20|5
        //1, 1, 1, 999999999
        //3, 3, 3, 3|8
        int[] piles = new int[]{3, 3, 3, 3};
        int h = 8;
        System.out.println(minEatingSpeedII(piles,h));
    }

    //3,6,7,11  h=8
    static public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, mid, h)) {
                right = mid; // Try to find a smaller valid speed
            } else {
                left = mid + 1; // Speed too slow, must increase
            }
        }

        return left;
    }

    static public int minEatingSpeedII(int[] piles, int h) {
        int left = 1,max=Integer.MIN_VALUE;
        for(int pile : piles) {
            max = Math.max(max,pile);
        }
        int right = max;
        while(left < right) {
            int mid = left + (right - left)/2;
            if(canFinish(piles,mid,h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canFinish(int[] piles, int speed, int h) {
        long totalHours = 0;
//        for (int pile : piles) {
//            totalHours += (pile + speed - 1) / speed; // Integer ceiling division
//        }
        for(int pile : piles) {
            double hours = Math.ceil((double)pile/speed);
            totalHours += (long)hours;
        }
        return totalHours <= h;
    }

    private static boolean canFinishII(int[] piles,int speed,int hour) {
        long totalHours = 0;
        for(int pile : piles) {
            totalHours += (long)Math.ceil((double)pile/speed);
        }
        return totalHours <= hour;
    }
}
