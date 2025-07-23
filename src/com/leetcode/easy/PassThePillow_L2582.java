package com.leetcode.easy;

//TODO: heavy on math [revise]
//problem # 2582 - pass the pillow
//check https://github.com/doocs/leetcode/tree/main/solution/2500-2599/2582.Pass%20the%20Pillow for github solution
public class PassThePillow_L2582 {
    public static void main(String[] args) {
        //4,5 exp. 2
        //3,2
        //4,10 exp. 3
        //100,900 exp. 91
        //1000,673 exp. 674
        //18,38 exp. 5
        System.out.println(passThePillow(18,38));
    }

    //n=4,time=5 -> 1,2,3,4
    //1 -> 2 -> 3 -> 4 -> 3 -> 2
    //while(t < 5)
    //// come up with a better solution other than traversing n elements back & forth
    public static int passThePillow(int n, int time) {
        if(time < n) {
            return time+1;
        }
        int t = 0,p=1;
        boolean reverse = false;
        while(t < time) {
            t++;
            p = reverse ? p-1:p+1;
            if(p == 1 || p == n) {
                reverse = !reverse;
            }
        }
        return p;
    }
}
