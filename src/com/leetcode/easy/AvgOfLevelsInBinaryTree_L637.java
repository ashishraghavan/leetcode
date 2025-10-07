package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//definitely revise, [tree]
//prob # 637 - avg of levels in binary tree,
public class AvgOfLevelsInBinaryTree_L637 {
    public static void main(String[] args) {
        //2147483647,2147483647,2147483647
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        TreeNode root = new TreeNode(3,left,right);
        System.out.println(averageOfLevels(root));
    }

    //do level order traversal using a queue
    public static List<Double> averageOfLevels(TreeNode root) {
        if(root == null)return null;
        List<Double> list = new ArrayList<>();
        avgOfLevels(root,list);
        return list;
    }

    public static void avgOfLevels(TreeNode root,List<Double> list) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        while(!dq.isEmpty()) {
            int size = dq.size();
            int ct = 0;
            double sum = 0;
            while(ct++ < size) {
                TreeNode curr = dq.pop();
                sum += curr.val();
                if(curr.left() != null) {
                    dq.offer(curr.left());
                }
                if(curr.right() != null) {
                    dq.offer(curr.right());
                }
            }
            list.add(sum/size);
        }
    }
}
