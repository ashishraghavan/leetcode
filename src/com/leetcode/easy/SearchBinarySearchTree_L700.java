package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

//prob #700 - search bst
public class SearchBinarySearchTree_L700 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        TreeNode right = new TreeNode(7);
        TreeNode root = new TreeNode(4,left,right);
        TreeNode res = searchBST(root,5);
        System.out.println(res == null ? "" : res.val());
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null)return null;
        else if(root.val() == val)return root;
        else if(val > root.val()) {
            //if val < root.val(), search root.right()
            return searchBST(root.right(),val);
        } else {
            //else search root.left()
            return searchBST(root.left(),val);
        }
    }
}
