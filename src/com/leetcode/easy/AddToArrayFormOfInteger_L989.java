package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//problem # 989 add to array form of integer
//TODO: pending
public class AddToArrayFormOfInteger_L989 {
    public static void main(String[] args) {
        //[1,2,0,0], k = 34
        //[2,7,4], k = 181
        //[2,1,5], k = 806
        //[5,7,]
        //[8, 6, 3, 3, 3, 6, 3, 7, 4, 9, 4, 5, 6, 5, 3, 1, 0, 0, 6, 2, 3, 0, 7, 8, 0, 0, 4, 9, 6, 6, 4, 3, 6, 6, 5, 7, 9, 2, 7, 7, 0, 6, 6, 2, 1, 1, 7, 2, 3, 4, 9, 3, 7, 0, 5, 6, 7, 7, 1, 1, 4, 4, 0, 2, 8, 5, 4, 0, 7, 2, 5, 7, 5, 0, 7, 2, 9, 1, 0, 9, 1, 5, 2, 4, 4, 5, 4, 5, 1, 8, 3, 3, 1, 6, 6, 8, 1, 9, 3, 4], 1214
        System.out.println(addToArrayForm(new int[]{8, 6, 3, 3, 3, 6, 3, 7, 4, 9, 4, 5, 6, 5, 3, 1, 0, 0, 6, 2, 3, 0, 7, 8, 0, 0, 4, 9, 6, 6, 4, 3, 6, 6, 5, 7, 9, 2, 7, 7, 0, 6, 6, 2, 1, 1, 7, 2, 3, 4, 9, 3, 7, 0, 5, 6, 7, 7, 1, 1, 4, 4, 0, 2, 8, 5, 4, 0, 7, 2, 5, 7, 5, 0, 7, 2, 9, 1, 0, 9, 1, 5, 2, 4, 4, 5, 4, 5, 1, 8, 3, 3, 1, 6, 6, 8, 1, 9, 3, 4},1));
    }

    //0<=num[i]<=9, no leading zeroes except for 0 itself
    //decimal base -> 1200 -> 10^0 * 0 + 10^1 * 0 + 10^2 * 2 + 10^3 * 1 -> 1200+34 = 1234
    //1<=num.length<=10000 -> max = 10^10000*9
    //out. 3,1,6,6,8,3,0,6,8     exp. 3,6,6,8,3,0,6,8
    //out. 3,1,6,6,8,1,8,5,5     exp. 3,6,6,8,1,8,5,5
    public static List<Integer> addToArrayForm(int[] num, int k) {
        double n = 0, idx = 0;
        for(int i=num.length-1;i>=0;i--) {
            double adder = Math.pow(10,idx++);
            n += (int)adder * num[i];
        }
        System.out.println("sum before addition = "+n);
        n += k;
        System.out.println("total sum = "+n);
        List<Integer> res = new ArrayList<>();
        int finalNum;
        while(n > 0) {
            finalNum = (int)n % 10;
            n = n/10;
            res.add(finalNum);
        }
        System.out.println("res = "+res);
        Collections.reverse(res);
        System.out.println("reverse res = "+res);
        return res;
    }
}
