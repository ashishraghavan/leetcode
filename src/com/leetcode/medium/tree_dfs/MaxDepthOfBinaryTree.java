package com.leetcode.medium.tree_dfs;

import java.util.Arrays;
import java.util.List;

//#104
public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        //Arrays.asList(3, 9, 20, null, null, 15, 7)
        //Arrays.asList(1, null, 2, null, 3, null, 4, null, 5)
        //Arrays.asList(1, 2, 3, 4, null, null, 5, 6)
        //Arrays.asList(0, -10, 10, -20, 0, null, 100)
        //Arrays.asList()
        TreeNode root = BinaryTreeBuilder.buildTree(Arrays.asList());
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        //base case
        if(root == null) {
            return 0;
        }

        //recursive case
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return 1 + Math.max(maxLeft,maxRight);
    }
}
