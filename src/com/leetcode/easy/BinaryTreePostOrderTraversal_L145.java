package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//prob # 145 - binary tree post order traversal
public class BinaryTreePostOrderTraversal_L145 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,new TreeNode(4),new TreeNode(5,new TreeNode(6),new TreeNode(7)));
        TreeNode right = new TreeNode(3,null,new TreeNode(8,new TreeNode(9),null));
        TreeNode root = new TreeNode(1,left,right);
        System.out.println(postorderTraversal(root));
    }

    //visit left child, mark this as curr -> if curr has left child,
    //visit left of curr. keep continuing until no more left children
    //print curr
    //go back to parent. visit right child, mark as curr -> if curr has left
    //
    public static List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        doPoTraversal(root,list);
        return list;
    }

    public static void doPoTraversal(TreeNode root,List<Integer> list) {
        if(root == null)return;
        doPoTraversal(root.left(),list);
        doPoTraversal(root.right(),list);
        list.add(root.val());
    }
}
