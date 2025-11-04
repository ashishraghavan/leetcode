package com.leetcode.medium.array_strings;

import java.util.Arrays;

//TODO: definitely [revise], based on dutch national flag algorithm, uses 3 pointers,
// check https://algo.monster/liteproblems/75 for detailed & intuitive explanation
//prob #75 - sort colors
public class SortColors_L75 {
    public static void main(String[] args) {
        //2,0,2,1,1,0
        //1,2,1,1,0,1,0,2,2
        //0, 1, 2, 0, 0, 1, 0, 0, 2, 1, 0, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 2, 1, 1, 0, 0, 1, 1, 1, 1, 0, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 2, 1, 2, 1, 1, 0, 1, 2, 1, 2, 0, 2, 1, 2, 1, 1, 2, 0, 0, 0, 1, 2, 1, 2, 2, 1, 2, 1, 2, 0, 1, 0, 1, 0, 2, 2, 0, 2, 2, 0, 2, 0, 1, 0, 0, 2, 0, 0, 0, 0, 1, 0, 2, 0, 2, 2, 0, 1, 2, 2, 2, 1, 2, 2, 2, 0, 1, 0, 2, 1, 2, 0, 1, 1, 2, 0, 0, 1, 2, 1, 2, 2, 2, 0, 2, 1, 0, 1, 0, 2, 0, 0, 2, 0, 0, 2, 1, 0, 2, 1, 1, 1, 1, 2, 1, 0, 2, 1, 1, 0, 2, 0, 0, 0, 1, 2, 0, 0, 2, 2, 1, 0, 1, 1, 0, 2, 1, 1, 0, 0, 0, 0, 0, 2, 1, 0, 1, 1
        int[] nums = new int[]{0, 1, 2, 0, 0, 1, 0, 0, 2, 1, 0, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 2, 1, 1, 0, 0, 1, 1, 1, 1, 0, 2, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 2, 1, 2, 1, 1, 0, 1, 2, 1, 2, 0, 2, 1, 2, 1, 1, 2, 0, 0, 0, 1, 2, 1, 2, 2, 1, 2, 1, 2, 0, 1, 0, 1, 0, 2, 2, 0, 2, 2, 0, 2, 0, 1, 0, 0, 2, 0, 0, 0, 0, 1, 0, 2, 0, 2, 2, 0, 1, 2, 2, 2, 1, 2, 2, 2, 0, 1, 0, 2, 1, 2, 0, 1, 1, 2, 0, 0, 1, 2, 1, 2, 2, 2, 0, 2, 1, 0, 1, 0, 2, 0, 0, 2, 0, 0, 2, 1, 0, 2, 1, 1, 1, 1, 2, 1, 0, 2, 1, 1, 0, 2, 0, 0, 0, 1, 2, 0, 0, 2, 2, 1, 0, 1, 1, 0, 2, 1, 1, 0, 0, 0, 0, 0, 2, 1, 0, 1, 1};
        sortColorsIII(nums);
        System.out.println(Arrays.toString(nums));
    }

    //2,0,2,1,1,0
    //0,0,2,1,1,2
    //0,0,1,1,2,2

    //f=0,m=0,l=8
    //1,2,1,1,0,1,0,2,2
    //if A[l]==2 ? l--, if A[f]==0 ? f++
    //swap(f,l), if A[m]==0 ? m++ //f=1,m=1,l=6
    //0,2,1,1,0,1,1,2,2
    //0,1,1,1,0,1,2,2,2

    //1,2,1,1,0,1,0,2,2
    //1,0,1,1,0,1,2,2,2
    //1,0,1,1,0,1
    //2-pointer
    //0,0,1,1,1,1,2,2,2

    //1,2,1,1,0,1,0,2,2
    //[1, 0, 1, 1, 0, 2, 1, 2, 2]
    public static void sortColors(int[] A) {
        //sort all 2's
        int first = 0,last = A.length-1;
        while (first < last) {
            if(A[first] != 2) {
                first++;
                continue;
            }
            if(A[last] == 2) {
                last--;
                continue;
            }
            swap(A, first, last);
            first++;
            last--;
        }
        System.out.println(Arrays.toString(A));
        //System.out.println("first = "+first+", last = "+last);
        first=0;
        while(first < last) {
            if(A[last] == 1){
                last--;
                continue;
            }
            if(A[first] == 0) {
                first++;
                continue;
            }
            swap(A,first,last);
        }
        System.out.println(Arrays.toString(A));
    }

    public static void swap(int[] A,int a,int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public static void sortColorsII(int[] nums) {
        int i=-1,k=0,j=nums.length;
        while(k < j) {
            if(nums[k]==0) {
                i++;
                swap(nums,i,k);
                k++;
            } else if(nums[k]==2) {
                j--;
                swap(nums,k,j);
            } else {
                k++;
            }
        }
    }

    ////MY SOLUTION - also runs in O(n) time
    public static int[] sortColorsIII(int[] A) {
        int left = 0, right = A.length-1;
        while(left < right) {
            if(A[left] == 2) {
                if(A[right] == 2)right--;
                else {
                    swap(A,left,right);
                    left++;
                    right--;
                }
            } else {
                if(A[right] == 2)right--;
                else left++;
            }
        }
        System.out.println("right = "+right);
        System.out.println("Before swapping 0,1 from start : "+Arrays.toString(A));
        left = 0;
        if(A[right]==2)right--;
        //(0,1),(0,0),(1,0),(1,1)
        while(left < right) {
            if(A[right]==1)right--;
            else {
                if(A[left]==1) {
                    swap(A,left,right);
                    left++;
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(Arrays.toString(A));
        return A;
    }
}
