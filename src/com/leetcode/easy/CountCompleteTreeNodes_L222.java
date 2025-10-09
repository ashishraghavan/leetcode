package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

//TODO: search for solution better than runtime of O(n)
//prob #222 - count complete tree nodes
public class CountCompleteTreeNodes_L222 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,new TreeNode(4),new TreeNode(5));
        TreeNode right = new TreeNode(3,new TreeNode(6),new TreeNode(8));
        TreeNode root = new TreeNode(1,left,right);
        System.out.println(countNodes(root));
    }

    //runs in O(n) time
    public static int countNodes(TreeNode root) {
        if(root == null)return 0;
        return 1 + countNodes(root.left()) + countNodes(root.right());
    }

    //no of nodes [1,2^h] where h = no of levels in
    //the tree (0 based)
    public static int countNodesII(TreeNode root) {
        return -1;
    }
}
