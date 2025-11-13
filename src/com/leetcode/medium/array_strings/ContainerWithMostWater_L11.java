package com.leetcode.medium.array_strings;

//TODO: [revise][2-pointer]
//prob #11 - container with most water
public class ContainerWithMostWater_L11 {
    public static void main(String[] args) {
        //1,8,6,2,5,4,8,3,7
        //1,1
        //[10,9,8,7,6,5,4,3,2,1]
        //[2,3,10,5,7,8,9]
        //[4,3,2,1,4]
        //[5,4,3,2,1]
        //[1,2,3,4,5]
        System.out.println(maxArea(new int[]{1,2,3,4,5}));
    }

    //1,8,6,2,5,4,8,3,7
    //i,j>i, find i,j such that j-i is max and abs(h[j]-h[i]) is min
    //i=1, j=8 -> j-i = 7 & abs(7-8) = 1
    ////l[] = [1,8,8,8,8,8,8,8,8] -> not required!
    ////r[] = [8,8,8,8,8,8,8,7,7] -> not required!
    //l=0,r=h.length-1=8, dist=r-l=8, ht=min(h[l],h[r])=1,a=dist*ht=8*1=8, h[l]<h[r]-> l++
    //l=1,r=h.length-1=8, dist=7, ht=min(h[l],h[r])=7, a=7*7=49, h[l]>h[r]-> r--
    //l=1,r=7, dist=6, ht=min(8,3)=3, a=6*3=18, h[l]>h[r]-> r--
    public static int maxArea(int[] h) {
        int l=0,r=h.length-1,a=Integer.MIN_VALUE;
        while(l<r) {
            a = Math.max(a,((r-l) * Math.min(h[l],h[r])));
            if(h[l] < h[r]) l++;
            else r--;
        }
        return a;
    }
}
