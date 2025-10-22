package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//prob #653 - two sum input is a bst
public class TwoSumInputIsBST_L653 {
    static List<Integer> list = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
//        TreeNode left = new TreeNode(3,new TreeNode(2),new TreeNode(4));
//        TreeNode right = new TreeNode(6,null,new TreeNode(7));
//        TreeNode root = new TreeNode(5,left,right);

        TreeNode left = new TreeNode(12,new TreeNode(9,new TreeNode(3),new TreeNode(10)),new TreeNode(13));
        TreeNode right = new TreeNode(23,new TreeNode(17),null);
        TreeNode root = new TreeNode(16,left,right);
        System.out.println(findTargetII(root,29));
    }

    //1. inorder traversal -> sorted array ->
    // two pointer technique to find two sum
    //2.
    //for each node,
    //compare(node.val,k) - if -1/0, search node.val-k in left subtree
    //else search k-node.val in right subtree
    public static boolean findTarget(TreeNode root, int k) {
        inOrder(root);
        return isTwoSum(k);
    }

    ////solution from [...](https://github.com/doocs/leetcode/blob/main/solution/0600-0699/0653.Two%20Sum%20IV%20-%20Input%20is%20a%20BST/README_EN.md#java)
    public static boolean findTargetII(TreeNode root, int k) {
        return dfs(root,k);
    }

    public static boolean dfs(TreeNode root,int k) {
        if(root == null)return false;
        if(set.contains(k - root.val))return true;
        set.add(root.val);
        return dfs(root.left,k) || dfs(root.right,k);
    }

    public static void inOrder(TreeNode root) {
        if(root == null)return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public static boolean isTwoSum(int k) {
        int start = 0,end = list.size()-1;
        while(start < end) {
            int sum = list.get(start) + list.get(end);
            if(sum == k)return true;
            else {
                if(sum > k) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return false;
    }
}
