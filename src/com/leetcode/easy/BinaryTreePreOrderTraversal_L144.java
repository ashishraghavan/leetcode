package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//prob # 144 - binary tree preorder traversal
public class BinaryTreePreOrderTraversal_L144 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,new TreeNode(4),new TreeNode(5,new TreeNode(6),new TreeNode(7)));
        TreeNode right = new TreeNode(3,null,new TreeNode(8,new TreeNode(9),null));
        TreeNode root = new TreeNode(1,left,right);
        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        potrv(root,list);
        return list;
    }

    public static void potrv(TreeNode root, List<Integer> list) {
        if(root == null)return;
        list.add(root.val());
        potrv(root.left(),list);
        potrv(root.right(),list);
    }
}
