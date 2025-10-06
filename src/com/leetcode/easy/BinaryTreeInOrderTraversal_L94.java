package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

import java.util.ArrayList;
import java.util.List;

//prob # 94 - binary tree in order traversal
public class BinaryTreeInOrderTraversal_L94 {
    public static void main(String[] args) {
        TreeNode right = new TreeNode(3,
                null,new TreeNode(8,new TreeNode(9),null));
        TreeNode left = new TreeNode(2,
                new TreeNode(4),new TreeNode(5,new TreeNode(6),new TreeNode(7)));
        TreeNode root = new TreeNode(1,left,right);
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        InOrderTraversal(root,list);
        return list;
    }

    //base case - if root = null
    public static void InOrderTraversal(TreeNode root,List<Integer> list) {
        if(root == null)return;
        else if(root.left() != null) {
            InOrderTraversal(root.left(),list);
        }
        list.add(root.val());
        InOrderTraversal(root.right(),list);
    }
}
