package com.leetcode.medium.tree_dfs;

import java.util.Arrays;

//#112
public class PathSum {
    public static void main(String[] args) {
        //Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,null,1)
        //Arrays.asList(1,2,3)
        //Arrays.asList(1, -2, -3, 1, 3, -2, null, -1)
        //Arrays.asList(-2, null, -3)
        //Arrays.asList(5)
        //Arrays.asList(1, null, 2)
        //Arrays.asList(1, 2, null)
        //Arrays.asList(1, 2)
        //Arrays.asList(1, -2, -3, 1, 3, -2, null, -1)
        //Arrays.asList(0, 0, 0, 0, null, null, 0)
        TreeNode root = BinaryTreeBuilder.buildTree(Arrays.asList(0, 0, 0, 0, null, null, 0));
        int targetSum = 0;
        System.out.println(hasPathSum(root,targetSum));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,0,targetSum);
    }

    public static boolean helper(TreeNode node,int currSum,int targetSum) {
        //base case:
        if(node == null) {
            return false;
        } else if(node.left == null && node.right == null) {
            return (currSum + node.val)==targetSum;
        } else {
            return helper(node.left,currSum+=node.val,targetSum)
                    || helper(node.right,currSum,targetSum);
        }
    }
}
