package com.leetcode.easy;

//prob # 2269 - k beauty of number
public class KBeautyOfNumber_L2269 {
    public static void main(String[] args) {
        //240, 2
        //430043, 2
        //100438572
        System.out.println(divisorSubstrings(100000000,4));
    }

    public static int divisorSubstrings(int num, int k) {
        String no = String.valueOf(num);
        int i=0,j=k-1,cnt=0;
        for(;j<no.length();i++,j++) {
            int val = Integer.parseInt(no.substring(i,j+1));
            if(val == 0)continue;
            if(num % val == 0)cnt++;
        }
        return cnt;
    }
}
