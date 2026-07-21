package com.leetcode.medium.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//#15, see https://share.gemini.google/KQJCpuu4bi3j
public class ThreeSum {
    public static void main(String[] args) {
        //-1,0,1,2,-1,-4
        //0, 0, 0, 0
        //1, 2, 3, 4, 5
        //0.1
        //-2, 0, 0, 2, 2 - F
        //-2, -2, -2, 0, 2
        //-5, -4, -3, -2, -1
        //-2, 0, 1, 1, 2
        //-2, -2, -2, -2
        //-100, -50, -10, 0, 10, 50, 100
        System.out.println(threeSumUpdated(new int[]{-2, 0, 0, 2, 2}));
    }

    //-1,0,1,2,-1,-4
    //-4,-1,-1,0,1,2
    //-4, -4+y+z=0, y+z=4, NP
    //-1, -1+y+z=0, y+z=1,
    //0, 0+y+z=0, y+z=0, NP
    //1...
    public static List<List<Integer>> threeSum(int[] A) {
        Arrays.sort(A);
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<A.length-2;i++) {
            int x = A[i];
            int target = -x;
            int y=i+1,z=i+2;
            while(z < A.length) {
                if(A[y] + A[z] == target) {
                    l.add(Arrays.asList(A[i],A[y],A[z]));
                    z++;
                } else if((A[y] + A[z]) < target) {
                    z++;
                } else {
                    y++;
                }
            }
        }
        return l;
    }

    //-4,-1,-1,0,1,2
    //-4, -4+y+z=0, y+z=4, NP
    //-1, -1+y+z=0, y+z=1,
    //0, 0+y+z=0, y+z=0, NP
    //1...

    //-2, 0, 0, 2, 2
    public static List<List<Integer>> threeSumUpdated(int[] A) {
        Arrays.sort(A);
        List<List<Integer>> l = new ArrayList<>();
        for(int i=0;i<A.length-2;i++) {
            int x = A[i];
            int target = -x;
            int y=i+1,z=A.length-1;
            //skip over same pivot's as this will result in same target value
            if(i > 0 && A[i]==A[i-1]) {
                continue;
            }
            while(y<z) {
                if(A[y]+A[z] == target) {
                    l.add(Arrays.asList(A[i],A[y],A[z]));
                    while(y < z && A[y]==A[y+1]) {
                        y++;
                    }
                    while(y < z && A[z]==A[z-1]) {
                        z--;
                    }
                    y++;
                    z--;
                } else if(A[y]+A[z] > target) {
                    z--;
                } else {
                    y++;
                }
            }
        }
        return l;
    }
}
