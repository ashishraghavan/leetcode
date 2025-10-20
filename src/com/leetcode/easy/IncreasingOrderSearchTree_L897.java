package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

//prob #89 - increasing order search tree
public class IncreasingOrderSearchTree_L897 {
    static TreeNode ans;
    static TreeNode parent;
    public static void main(String[] args) {
        TreeNode left = new TreeNode(3,new TreeNode(2,new TreeNode(1),null),new TreeNode(4));
        TreeNode right = new TreeNode(6,null,new TreeNode(8,new TreeNode(7),new TreeNode(9)));
        TreeNode root = new TreeNode(5,left,right);
        TreeNode res = increasingBST(root);
        assert res != null;
        //System.out.println();
    }

    public static TreeNode increasingBST(TreeNode root) {
        if(root == null)return null;
        inOrder(root);
        return ans;
    }

    public static void inOrder(TreeNode root) {
        if(root == null)return;
        inOrder(root.left);
        if(parent == null) {
            ans = new TreeNode(root.val);
            parent = ans;
        } else {
            TreeNode curr = new TreeNode(root.val);
            parent.right = curr;
            parent = curr;
        }
        inOrder(root.right);
    }
}
