package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

import java.util.Stack;

//prob # 226 - invert binary tree
//IMPORTANT QUESTION - definitely revise, [tree]
public class InvertBinaryTree_L226 {
    public static void main(String[] args) {
        //System.out.println();
        TreeNode right = new TreeNode(7,
                new TreeNode(6),new TreeNode(9));
        TreeNode left = new TreeNode(2,
                new TreeNode(1), new TreeNode(3));
        TreeNode root = new TreeNode(4,left,right);
        TreeNode invertedTree = invertTree(root);
        assert invertedTree != null;
    }


    public static TreeNode invertTree(TreeNode root) {
        //base case
        //when root is a leaf node
        if(root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left());
        TreeNode right = invertTree(root.right());
        root.setLeft(right);
        root.setRight(left);
        return root;
    }


    public static TreeNode invertTreeII(TreeNode root) {
        if(root == null)return null;
        TreeNode temp = root.left();
        root.setLeft(root.right());
        root.setRight(temp);
        invertTreeII(root.left());
        invertTreeII(root.right());
        return root;
    }

    //use Stack<TreeNode>
    //create new T
    //1. push children of a node
    public static TreeNode invertTreeIII(TreeNode root) {
        if(root == null)return null;
        TreeNode invTree = new TreeNode(root.val());
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        while(!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            if(curr.left() != null) {
                stk.push(curr.left());
            }
            if(curr.right() != null) {
                stk.push(curr.right());
            }
            invTree.setLeft(stk.pop());
            invTree.setRight(stk.pop());

        }
        return null;
    }
}
