package com.leetcode.medium.prefixsum;

//#303 - https://share.gemini.google/Obm9MoM6qBLN
public class RangeSumQuery_Immutable {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(1,3));//-2
        System.out.println(numArray.sumRange(0,5));//-3
        System.out.println(numArray.sumRange(4,5));//1
        System.out.println(numArray.sumRange(2,2));//3
        System.out.println(numArray.sumRange(0,0));//-2
        //numArray.printPSum();
    }

    static class NumArray {
        int[] pSums;
        public NumArray(int[] nums) {
            this.pSums = new int[nums.length];
            pSums[0]=nums[0];
            for(int i=1;i<nums.length;i++) {
                pSums[i] = pSums[i-1] + nums[i];
            }
        }

        //nums = -2,0,3,-5,2,-1
        //pSum = -2,-2,1,-4,-2,-3
        //left=1,right=3
        public int sumRange(int left, int right) {
            if(left==0)return pSums[right];
            else {
                return pSums[right] - pSums[left-1];
            }
        }

        public void printPSum() {
            //IntStream.range(0,pSums.length).forEach(x->System.out.print(x))
            for(int i=0;i<pSums.length;i++) {
                System.out.print(pSums[i] + ",");
            }
        }
    }
}
