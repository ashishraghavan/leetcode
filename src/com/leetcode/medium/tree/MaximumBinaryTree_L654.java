package com.leetcode.medium.tree;

import com.leetcode.tree.core.TreeNode;

import java.util.*;

//TODO: non-optimized solution, fix method max(...)
//prob #654 - maximum binary tree
public class MaximumBinaryTree_L654 {
    public static void main(String[] args) {
        //3,2,1,6,0,5
        TreeNode res = constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        assert res != null;
    }

    //3,2,1,6,0,5
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0)return null;
        if(nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int maxIdx = max(nums);
        TreeNode node = new TreeNode(nums[maxIdx]);
        //left subtree
        node.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,maxIdx));
        //right subtree
        node.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums,maxIdx+1,nums.length));
        return node;
    }

    public static int max(int[] nums) {
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}
