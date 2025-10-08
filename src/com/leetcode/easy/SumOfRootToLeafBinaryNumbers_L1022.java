package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

//TODO: refer https://algo.monster/liteproblems/257, https://algo.monster/liteproblems/1022
// for a better understanding of the solution
//prob #1022 - sum of root to leaf binary numbers
public class SumOfRootToLeafBinaryNumbers_L1022 {
    public static void main(String[] args) {
//        TreeNode left = new TreeNode(0,new TreeNode(0),new TreeNode(1));
//        TreeNode right = new TreeNode(1,new TreeNode(0),new TreeNode(1));
//        TreeNode root = new TreeNode(1,left,right);

        TreeNode left = new TreeNode(0,new TreeNode(1),null);
        TreeNode right = new TreeNode(0);
        TreeNode root = new TreeNode(1,left,right);
        System.out.println(sumRootToLeaf(root));
    }

    public static int sumRootToLeaf(TreeNode root) {
        //base case
        //if this is leaf node return root.val
        if(root.left() == null && root.right() == null) {
            return root.val();
        }
        //recursive case
        return sum(root,new StringBuilder());
    }

    //res = 1,10,101
    public static int sum(TreeNode root,StringBuilder res) {
        if(root == null)return 0;
        res.append(root.val());
        if(root.left() == null && root.right() == null) {
            return Integer.parseInt(res.toString(),2);
        } else {
            int leftSum = sum(root.left(),res);
            if(leftSum != 0) res.deleteCharAt(res.length()-1);
            int rightSum = sum(root.right(),res);
            if(rightSum != 0) res.deleteCharAt(res.length()-1);
            return leftSum + rightSum;
        }
    }
}
