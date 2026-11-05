package com.leetcode.medium.tree_dfs;

import java.util.Arrays;

//#226
public class InvertBinaryTree {
    public static void main(String[] args) {
        //4,2,7,null,3,6,null
        //4,2,7,1,3,6,9
        //Arrays.asList(0, -10, 10, -20, 0, null, 100)
        //Arrays.asList(1, 2, 3, 4, null, null, 5)
        //Arrays.asList(1, null, 2, null, 3, null, 4)
        //Arrays.asList(1, 2, null, 3, null, 4)
        //Arrays.asList(1, null, 2)
        //Arrays.asList(1, 2, null)
        //Arrays.asList(1)
        TreeNode root = BinaryTreeBuilder.buildTree(Arrays.asList(1));
        TreeNode updRoot = invertTree(root);
        if(updRoot != null) {
            BinaryTreeBuilder.printLevelOrderTraversal(updRoot);
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null)return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
