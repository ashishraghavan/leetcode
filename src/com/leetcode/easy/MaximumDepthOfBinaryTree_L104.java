package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

//prob # 104 - maximum depth of binary tree
public class MaximumDepthOfBinaryTree_L104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,new TreeNode(9,null,null),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        System.out.println(maxDepth(root));
    }

    //for each node, get maximum depth of left subtree & right
    //subtree i.e. max(maxDepth(root.left(),maxDepth(root.right()))
    public static int maxDepth(TreeNode root) {
        //base case - when root is null return 0
        if(root == null)return 0;
        //recursive case
        int leftDepth = 1+maxDepth(root.left());
        int rightDepth = 1+maxDepth(root.right());
        return Math.max(leftDepth,rightDepth);
    }
}
