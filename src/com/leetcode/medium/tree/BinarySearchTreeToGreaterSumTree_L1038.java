package com.leetcode.medium.tree;

import com.leetcode.tree.core.TreeNode;

//TODO: See https://algo.monster/liteproblems/1038 for reference
//prob #1038 - binary search tree to greater sum tree
public class BinarySearchTreeToGreaterSumTree_L1038 {
    static int sum = 0;
    public static void main(String[] args) {
        TreeNode left = new TreeNode(1,new TreeNode(0),new TreeNode(2,null,new TreeNode(3)));
        TreeNode right = new TreeNode(6,new TreeNode(5),new TreeNode(7,null,new TreeNode(8)));
        TreeNode root = new TreeNode(4,left,right);
        TreeNode res = bstToGst(root);
        assert res != null;
    }

    //go right, go to root, go left
    //base case - if
    public static TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    public static void dfs(TreeNode root) {
        if(root == null)return;
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
    }
}
