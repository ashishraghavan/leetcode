package com.leetcode.easy;

//TODO: review
// original solution was pending solution to edge case - when index i = 0, flowerbed[i]=0 && flowerbed[i+1] = 0, ct++ && when index i = len-1, flowerbed[i] = 0 && flowerbed[i-1] = 0, ct++
//problem # 605 - can place flowers
public class CanPlaceFlowers_L605 {
    public static void main(String[] args) {
        //1,0,0,0,1 n=1
        //1,0,0,0,1 n=2
        //1,0,0,1,0,0,0,0,1,0,1,0 | n = 1
        //1,0,0,1,0,0,0,0,1,0,1,0 | n = 3
        //1,0,0,1,0,0,0,0,0,0,1,0 | n = 2

        //0,0,1,0,1 | n = 1
        //0,0,1,0,0 | n = 2
        System.out.println(canPlaceFlowersII(new int[]{0,0,1,0,1},1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        //how many ways to place/plant n balls/flowers in container/flowerbed
        //with capacity = containers/flowerbeds with value = 0
        //such that no two balls/flowers are adjacent to each other
        //flowerbed = f
        //1 -> f[1],f[2],f[3] => 3 => return true

        //for i = 0 only check if flowerbed[i] = 0 && flowerbed[i+1] = 0, ct++;
        //for i = flowerbed.length-1 only check if flowerbed[flowerbed.length-1] = 0 && flowerbed[flowerbed.length-]
        //1,0,0,0,1 n=2
        //find count of spots (ct) where if i is the spot, f[i-1] = 0 & f[i+1] = 0
        //if ct < n return false
        if(flowerbed.length <= n)return false;
        int ct = 0;
        int i = 0;
        if(flowerbed.length >= 2 && flowerbed[0] == 0 && flowerbed[i+1] == 0) {
            ct++;
            i+=2;
        }
        while(i<flowerbed.length) {
            if(flowerbed[i] == 0
                    && (i-1 >= 0 && flowerbed[i-1] == 0)
                    && (i+1 <= flowerbed.length-1 && flowerbed[i+1] == 0)) {
                ct++;
                i+=2;
            } else {
                i++;
            }
        }
        return ct >= n;
    }

    //implementing solution from github
    public static boolean canPlaceFlowersII(int[] flowerbed,int n) {
        int len = flowerbed.length;
        for(int i=0;i<len;i++) {
            int l = i == 0 ? 0 : flowerbed[i-1];
            int r = i == len-1 ? 0 : flowerbed[i+1];
            if(l + flowerbed[i] + r == 0) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
