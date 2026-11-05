package com.leetcode.medium.tree_dfs;

import java.util.Arrays;

//#124 **** unsolved ****
//refer https://share.gemini.google/NtOp3AGNHVSG for explanation!!!
public class BinaryTreeMaximumPathSum {
    private static int mxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        //Arrays.asList(-10,9,20,null,null,15,7)
        TreeNode root = BinaryTreeBuilder.buildTree(Arrays.asList(-10,9,20,null,null,15,7));
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        maxSum(root);
        return mxSum;
    }

    public static int maxSum(TreeNode node) {
        if(node == null)return 0;
        return -1;
    }
}
