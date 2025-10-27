package com.leetcode.medium.tree;

import com.leetcode.tree.core.TreeNode;

import java.util.*;

//prob #103 - binary tree zigzag level order traversal
public class BinaryTreeZigZagLevelOrderTraversal_L103 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        TreeNode root = new TreeNode(3,left,right);
        System.out.println(zigzagLevelOrder(root));
    }

    //[[3],[20,9],[15,7]]
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)return Collections.emptyList();
        boolean zigZag = false;
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        dq.offer(root);
        while(!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> subList = new ArrayList<>(size);
            for(int i=0;i<size;i++) {
                TreeNode node = dq.pop();
                subList.add(node.val);
                if(node.left != null) {
                    dq.offer(node.left);
                }
                if(node.right != null) {
                    dq.offer(node.right);
                }
            }
            if(zigZag) {
                Collections.reverse(subList);
            }
            list.add(subList);
            zigZag = !zigZag;
        }
        return list;
    }
}
