package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

//TODO: check solution at https://algo.monster/liteproblems/2331
//prob #2331 - evaluate boolean binary tree
public class EvaluateBooleanBinaryTree_L2331 {
    public static void main(String[] args) {
//        TreeNode left = new TreeNode(0,null,null);
//        TreeNode right = new TreeNode(1,null,null);
        TreeNode rtnode = new TreeNode(3,new TreeNode(0),new TreeNode(1));
        TreeNode ltnode = new TreeNode(2,new TreeNode(3,new TreeNode(0),new TreeNode(1)),new TreeNode(0));
        TreeNode root = new TreeNode(2,ltnode,rtnode);
        System.out.println(evaluateTreeII(root));
    }

    //each node has either 0 or 2 children
    //for leaf nodes 0=false,1=true
    //for non-leaf nodes 2=OR,3=AND
    public static boolean evaluateTree(TreeNode root) {
        if(root.val() == 0 || root.val() == 1) {
            return root.val() != 0;
        }
        //evaluate left
        if(root.left() != null) {
            boolean left = evaluateTree(root.left());
            boolean right = evaluateTree(root.right());
            return root.val() == 2 ? left || right : left && right;
        }
        return false;
        //evaluate root
    }

    //solution from website
    public static boolean evaluateTreeII(TreeNode root) {
        if(root.left() == null) {
            return root.val() == 1;
        }
        boolean left = evaluateTreeII(root.left());
        boolean right = evaluateTreeII(root.right());
        return root.val() == 2 ? left || right : left && right;
    }
}
