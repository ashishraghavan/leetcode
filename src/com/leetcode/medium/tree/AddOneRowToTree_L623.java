package com.leetcode.medium.tree;

import com.leetcode.tree.core.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

//prob #623 - add one row to tree
public class AddOneRowToTree_L623 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,new TreeNode(3),new TreeNode(1));
        TreeNode right = new TreeNode(5,null,new TreeNode(7));
        TreeNode root = new TreeNode(4,left,right);

//        TreeNode left = new TreeNode(2,new TreeNode(3),new TreeNode(1));
//        TreeNode right = new TreeNode(6,new TreeNode(5),null);
//        TreeNode root = new TreeNode(4,left,right);
        TreeNode res = addOneRow(root,1,3);
        assert res != null;
        //System.out.println();
    }

    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        bfs(root,val,1,depth);
        return root;
    }

    public static void bfs(TreeNode root,int val,int currDepth,int depth) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while(!dq.isEmpty()) {
            int size = dq.size();
            for(int i=0;i<size;i++) {
                TreeNode node = dq.remove();
                if(currDepth == depth - 1) {
                    TreeNode left = null,right = null;
                    left = node.left;
                    node.left = new TreeNode(val);
                    node.left.left = left;

                    right = node.right;
                    node.right = new TreeNode(val);
                    node.right.right = right;
                } else {
                    if(node.left != null) {
                        dq.offer(node.left);
                    }
                    if(node.right != null) {
                        dq.offer(node.right);
                    }
                }
            }
            currDepth++;
        }
    }
}
