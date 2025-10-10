package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

import java.util.*;

//prob # 501 - find mode in binary search tree
public class FindModeInBinarySearchTree_L501 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(-20,new TreeNode(-25),new TreeNode(-20));
        TreeNode right = new TreeNode(2,new TreeNode(2),new TreeNode(3,null,new TreeNode(7)));
        TreeNode root = new TreeNode(1,left,right);
        System.out.println(Arrays.toString(findMode(root)));
    }

    //is a poor solution, consider revising
    //connection between bst & max frequency of node values
    //inorder traversal will give nodes in ascending order
    //[-25, -20, -20, 1, 2, 2, 3, 7]
    public static int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ioTraversal(root,list);
        //System.out.println(list);
        Map<Integer,Integer> freq = new HashMap<>();
        for(Integer elem : list) {
            freq.merge(elem,1, Integer::sum);
        }
        System.out.println(freq);
        int max = freq.values().stream().max(Integer::compareTo).orElse(-1);
        List<Integer> res = new ArrayList<>();
        for(Integer key : freq.keySet()) {
            if(freq.get(key) == max) {
                res.add(key);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void ioTraversal(TreeNode root, List<Integer> list) {
        if(root == null)return;
        ioTraversal(root.left(),list);
        list.add(root.val());
        ioTraversal(root.right(),list);
    }
}
