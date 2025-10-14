package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

//prob # 783 - minimum distance between binary search tree nodes
public class MinimumDistanceBetweenBSTNodes_L783 {
    static int diff = Integer.MAX_VALUE;
    static TreeNode prev = null;
    public static void main(String[] args) {
//        TreeNode left = new TreeNode(2,new TreeNode(1),new TreeNode(3));
//        TreeNode right = new TreeNode(6);
//        TreeNode root = new TreeNode(4,left,right);
        TreeNode left = new TreeNode(69,new TreeNode(49,null,new TreeNode(52)),new TreeNode(89));
        TreeNode root = new TreeNode(90,left,null);
        System.out.println(minDiffInBST(root));
        //minDiffInBST(root);
    }

    //49,52,69,89,90
    public static int minDiffInBST(TreeNode root) {
        dfs(root);
        return diff;
    }

    public static void dfs(TreeNode root) {
        if(root == null)return;
        dfs(root.left());
        if(prev != null && (Math.abs(root.val() - prev.val()) < diff)) {
            diff = Math.abs(root.val() - prev.val());
        }
        prev = root;
        dfs(root.right());
    }

    public static void dfsII(TreeNode root) {
        if(root == null)return;
        dfsII(root.left());
        System.out.print(root.val()+",");
        dfsII(root.right());
    }
}
