package com.leetcode.easy;

//problem # 674 - longest continuous increasing subsequence
public class LongestContiniousIncreasingSubsequence_L674 {
    public static void main(String[] args) {
        //1,3,5,4,7
        //2,2,2,2,2
        //5, 20, 12, 13, 17, 20, 7, 10
        //17, 0, 13, 2, 14, 6, 10
        //17, 12, 15, 3, 4, 10
        //20,18,16,12,10,8
        //-10000,0
        System.out.println(findLengthOfLCIS(new int[]{20,18,16,12,10,8}));
    }

    //[5, 20, 12, 13, 17, 20, 7, 10]
    //[17, 12, 15, 3, 4, 10]
    //left = l, right = r
    //nums.length == 1 return 1
    //i:(0-nums.length-1) ,l=0,r=1,i=l, clen=1,mlen = clen;
    //if nums[r] > nums[i] ? ++clen, i++,r++
    //else mlen=Math.max(mlen,clen), l=r,i=l,r++
    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length == 1)return 1;
        int l=0,r=1,i=l,clen=1,mlen=clen;
        while(i<nums.length && r<nums.length) {
            if(nums[r] > nums[i]) {
                ++clen;
                i++;
                r++;
            } else {
                mlen = Math.max(mlen,clen);
                l = r;
                i = l;
                r++;
                clen = 1;
            }
        }
        mlen = Math.max(mlen,clen);
        return mlen;
    }
}
