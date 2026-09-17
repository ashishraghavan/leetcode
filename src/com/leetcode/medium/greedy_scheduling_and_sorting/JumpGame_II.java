package com.leetcode.medium.greedy_scheduling_and_sorting;

//#45, refer https://share.gemini.google/5tGS6Hi6MyNO
public class JumpGame_II {
    public static void main(String[] args) {
        //2,3,1,1,4
        //1, 1, 1, 1, 1
        //10, 1, 1, 1, 1
        //7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3
        //2, 1, 3, 1, 1, 1
        //1, 2, 1, 1, 1
        //3, 4, 0, 0, 1, 2, 1
        System.out.println(jumpII(new int[]{2,3,1,1,4}));
    }

    //2,3,1,1,4
    public static int jump(int[] A) {
        int jumps = 0;
        int curEnd = 0;
        int farthest = 0;

        // Loop up to nums.length - 2 because reaching or crossing
        // the last index from the current window needs no extra jump.
        for (int i = 0; i < A.length - 1; i++) {
            farthest = Math.max(farthest, i + A[i]);

            // Exhausted the current interval window; take a jump
            if (i == curEnd) {
                jumps++;
                curEnd = farthest;

                // Early exit: if we can already hit the end
                if (curEnd >= A.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }

    //2,3,1,1,4
    //start at i=0,max jump possible is 2 - either jump 1 step(land at i=1) or 2 steps(land at i=2)
    //our current window is i:(0,2). What is the maxmimum jump possible in the range (0,2) i.e. at
    //any of the indices (0 or 1 or 2) which index will take me the farthest. In case of (0,2), it
    //is the index i=1. From here, I can jump 3 places forward. Therefore, when we reach the end
    //of our current window i.e. at 2, we increment our jump signifying we made a jump to this
    //farthest index which is 1+3=4. We also set our currEnd = 1+3 = 4.
    public static int jumpII(int[] A) {
        int farthest = 0;
        int currEnd = 0;
        int jumps = 0;
        for(int i=0;i<A.length-1;i++) {
            farthest = Math.max(farthest,i + A[i]);
            if(i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
            if(currEnd >= A.length-1) {
                break;
            }
        }
        return jumps;
    }
}
