package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

import java.util.ArrayList;
import java.util.List;

//TODO: definitely revise - uses backtracking, check https://algo.monster/liteproblems/257
// for intuitive solution
public class BinaryTreePaths_L257 {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,null,new TreeNode(5));
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1,left,right);
        System.out.println(binaryTreePathsII(root));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> subList = new ArrayList<>();
        btreePaths(root,subList);
        System.out.println(list);
        return list;
    }

    public static void btreePaths(TreeNode root,List<String> subList) {
        if(root == null) {
            return;
        }
        subList.add(String.valueOf(root.val));
        if(root.left == null && root.right == null) {
            list.add(String.join("->",subList));
        } else {
            btreePaths(root.left,subList);
            btreePaths(root.right,subList);
        }
        subList.remove(subList.size()-1);
    }

    public static List<String> binaryTreePathsII(TreeNode root) {
        List<String> subList = new ArrayList<>();
        buildPath(root,subList);
        return list;
    }

    public static void buildPath(TreeNode root,List<String> subList) {
        if(root == null)return;
        subList.add(String.valueOf(root.val));
        if(root.left == null && root.right == null) {
            list.add(String.join("->",subList));
        } else {
            buildPath(root.left,subList);
            buildPath(root.right,subList);
        }
        subList.remove(subList.size()-1);
    }
}
