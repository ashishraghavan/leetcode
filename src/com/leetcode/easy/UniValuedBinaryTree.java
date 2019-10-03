package com.leetcode.easy;

/**
 * A binary tree is univalued if every node in the tree has the same value.
 * <p>
 * Return true if and only if the given tree is univalued.
 */
public class UniValuedBinaryTree {
    public static void main(String[] args) {
        //System.out.println(isUnivalTree(new TreeNode(2)));
    }

    static boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null || (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null || (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
