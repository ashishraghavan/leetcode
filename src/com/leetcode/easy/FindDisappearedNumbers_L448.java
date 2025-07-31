package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

//prob # 448 - find disappearing numbers
public class FindDisappearedNumbers_L448 {
    public static void main(String[] args) {
        //4,3,2,7,8,2,3,1
        //1,1
        System.out.println(findDisappearedNumbers(new int[]{1,1}));
    }

    //4 - 1 is []
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] A = new int[nums.length+1];
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            A[num] = 1;
        }
        for(int i=1;i<A.length;i++) {
            if(A[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
