package com.leetcode.easy;

//prob # 3105 - longest monotonic increasing or decreasing subarray
//check https://github.com/doocs/leetcode/tree/main/solution/3100-3199/3105.Longest%20Strictly%20Increasing%20or%20Strictly%20Decreasing%20Subarray for github solution
public class LongestMonotonicSubArray_L3105 {
    public static void main(String[] args) {
        //1,4,3,3,2
        //3,3,3,3
        //3,2,1
        //1,1,2,1,3,6,8,8
        System.out.println(longestMonotonicSubArray(new int[]{1,4,3,3,2}));
    }

    //LOGIC FROM GITHUB SOLUTION
    //1,1,2,1,3,6,8,8
    //sliding window?
    //if nums.length = 1 return 1
    //len = 1
    //i=0,j=i+1
    //while j < nums.length
    //res = nums[j] - nums[i]
    //if res <= 0 ? i++,j++;
    //if res > 0 ? len = max(len,j-i+1),i=j,j++
    public static int longestMonotonicSubArray(int[] nums) {
        if(nums.length <= 1)return 1;
        int len = 1,mxLen = 1;
        //increasing
        int i = 0,j = i+1;
        while(j < nums.length) {
            int cmp = nums[j] - nums[i];
            if(cmp <= 0) {
                len = 1;
                i++;
            } else {
                mxLen = Math.max(++len,mxLen);
                i=j;
            }
            j++;
        }

        //decreasing
        i = 0;
        j = i+1;
        len = 1;
        while(j < nums.length) {
            int cmp = nums[j] - nums[i];
            if(cmp < 0) {
                mxLen = Math.max(++len,mxLen);
                i=j;
            } else {
                len = 1;
                i++;
            }
            j++;
        }
        return mxLen;
    }
}
