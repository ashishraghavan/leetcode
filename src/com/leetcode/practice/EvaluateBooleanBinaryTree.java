package com.leetcode.practice;

import com.leetcode.tree.core.TreeNode;

//prob #2331 - evaluate boolean binary tree
public class EvaluateBooleanBinaryTree {
    public static void main(String[] args) {
//        TreeNode left = new TreeNode(1);
//        TreeNode right = new TreeNode(3,new TreeNode(0),new TreeNode(1));
//        TreeNode root = new TreeNode(2,left,right);

        TreeNode left = new TreeNode(2,new TreeNode(3,new TreeNode(1),new TreeNode(0)),new TreeNode(0));
        TreeNode right = new TreeNode(3,new TreeNode(0),new TreeNode(1));
        TreeNode root = new TreeNode(2,left,right);
        System.out.println(evaluateTree(root));
    }

    //full binary tree, each node has either 0 or 2 children
    //leaf nodes - 0(false) or 1(true)
    //non-leaf nodes - 2(or) or 3(and)
    public static boolean evaluateTree(TreeNode root) {
        if(root.val == 1 || root.val == 0) {
            return root.val == 1;
        } else {
            boolean leftChild = evaluateTree(root.left);
            boolean rightChild = evaluateTree(root.right);
            return root.val == 2 ? leftChild || rightChild : leftChild && rightChild;
        }
    }
}
