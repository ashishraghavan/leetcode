package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

//prob #101 - symmetric tree
public class SymmetricTree_L101 {
    public static void main(String[] args) {
//        TreeNode left = new TreeNode(2,null,new TreeNode(3));
//        TreeNode right = new TreeNode(2,null,new TreeNode(3));
//        TreeNode root = new TreeNode(1,left,right);
        TreeNode left = new TreeNode(2,new TreeNode(3),new TreeNode(4));
        TreeNode right = new TreeNode(2,new TreeNode(4),new TreeNode(3));
        TreeNode root = new TreeNode(1,left,right);
        System.out.println(isSymmetric(root));
    }

    //for each node, check if node.left() == node.right &&
    //node.left().left().val == node.right().val
    public static boolean isSymmetric(TreeNode root) {
        if(root == null)return false;
        return isSame(root.left(),root.right());
    }

    public static boolean isSame(TreeNode left,TreeNode right) {
        if(left == null || right == null) {
            return left == right;
        }
        return left.val() == right.val() &&
                isSame(left.left(),right.right()) &&
                isSame(left.right(),right.left());
    }
}
