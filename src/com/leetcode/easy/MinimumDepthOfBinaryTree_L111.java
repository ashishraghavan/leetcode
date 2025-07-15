package com.leetcode.easy;

import com.leetcode.tree.TreeNode;

//TODO: grouped under [tree]
//problem #111 - minimum depth of binary tree
public class MinimumDepthOfBinaryTree_L111 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(15,null,null);
        TreeNode right = new TreeNode(7,null,null);
        TreeNode rtnode = new TreeNode(20,left,right);
        TreeNode ltnode = new TreeNode(9,null,null);
        TreeNode root = new TreeNode(3,ltnode,rtnode);
        //[3,9,20,null,null,15,7]
        System.out.println(minDepth(root));
    }

    //for each node, min depth = minDepth(root.left,root.right)
    //stop cond. if root.left == null && root.right == null return 1
    //else if root.left == null return minDepth(root.right)
    //else if root.right == null return minDepth(root.left)
    //else return 1 + min(minDepth(root.left),minDepth(root.right))
    public static int minDepth(TreeNode root) {
        if(root == null)return 0;
        else if(root.left() == null)return 1+minDepth(root.right());
        else if(root.right() == null)return 1+minDepth(root.left());
        else return 1 + Math.min(minDepth(root.left()),minDepth(root.right()));
    }
}
