package com.leetcode.easy.tree;

/**
 * Note that TreeNode has already been created for us.
 * To get the left value (less than value of current node) of the current node, we will
 * use root.left.val and to get the right (greater than value of current node), we will
 * use root.right.val.
 */
public class RangeSumOfBST {
    static int count = 0;
    public static void main(String[] args) {
        //Check in leetcode problem name Range Sum of Binary Search Tree
        //The implementation of the TreeNode class is there somewhere in
        //Leetcode. You just have to call the inOrderTraversal method
        //and keep the count variable as a static class one.
        //TODO : Find a better solution without having to keep the count as a static variable.
    }

    static int rangeSumBST(TreeNode root, int L, int R) {
        inOrderTraversal(root,L,R);
        return count;
    }

    static void inOrderTraversal(TreeNode node,int L,int R) {
        if(node == null) {
            return;
        }
        if(node.val >= L && node.val <= R) {
            count += node.val;
        }
        inOrderTraversal(node.left,L,R);
        inOrderTraversal(node.right,L,R);
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
