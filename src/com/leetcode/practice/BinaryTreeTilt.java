package com.leetcode.practice;

import com.leetcode.tree.core.TreeNode;

//prob #563 - binary tree tilt
public class BinaryTreeTilt {
    static int tilt;
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,new TreeNode(3),new TreeNode(5));
        TreeNode right = new TreeNode(9,null,new TreeNode(7));
        TreeNode root = new TreeNode(4,left,right);
        System.out.println(findTilt(root));
    }

    //for each node
    //tilt = abs(sum of all nodes in left subtree - sum of all nodes in right subtree)
    public static int findTilt(TreeNode root) {
        dfsSum(root);
        return tilt;
    }

    public static int dfsSum(TreeNode root) {
        if(root == null) return 0;
        int leftSubTreeSum = dfsSum(root.left);
        int rightSubTreeSum = dfsSum(root.right);
        tilt += Math.abs(leftSubTreeSum - rightSubTreeSum);
        return root.val + leftSubTreeSum + rightSubTreeSum;
    }
}
