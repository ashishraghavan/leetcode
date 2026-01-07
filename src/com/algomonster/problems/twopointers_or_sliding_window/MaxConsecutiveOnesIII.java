package com.algomonster.problems.twopointers_or_sliding_window;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        //1,1,1,0,0,0,1,1,1,1,0 | 2
        //0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1 | 3
        //[1,0,1,0,1,0,1],2
        System.out.println(longestOnesII(new int[]{1,0,1,0,1,0,1},2));
    }

    //1,1,1,0,0,0,1,1,1,1,0 | 2
    //cnt1=0,cnt0=0,i=0,j in (0,A.length-1) A[j]==0 ? cnt0++,cnt0 > k
    public static int longestOnes(int[] A, int k) {
        int i=0,cnt0=0,cnt1=0,mx=Integer.MIN_VALUE;
        for(int j=1;j<A.length;j++) {
            if(A[j]==1 && A[j-1]==1) {
                if(cnt1==0){
                    cnt1+=2;
                } else {
                    cnt1++;
                }
                mx = Math.max(mx,cnt1);
            } else {
                cnt0++;
                if(cnt0 > k) {
                    mx = Math.max(mx,j-i);
                    i=j;
                    cnt0=1;
                    cnt1=0;
                }
                mx = Math.max(mx,cnt1+cnt0);
            }
        }
        return mx;
    }

    //1,1,1,0,0,0,1,1,1,1,0 | 2
    //0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1 | 3
    public static int longestOnesII(int[] A, int k) {
        int i=0,j=0,cnt0=0,mx = Integer.MIN_VALUE;
        for(;j<A.length;j++) {
            if(A[j]==0) {
                cnt0++;
            }
            if(cnt0 > k) {
                while(cnt0 > k) {
                    if(A[i]==0)cnt0--;
                    i++;
                }
            }
            mx = Math.max(mx,j-i+1);
        }
        return mx;
    }
}
