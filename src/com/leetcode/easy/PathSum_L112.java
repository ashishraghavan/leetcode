package com.leetcode.easy;

import com.leetcode.tree.TreeNode;

//problem #112 - path sum in binary tree
//check https://assets.leetcode.com/uploads/2021/01/18/pathsum1.jpg for reference image
public class PathSum_L112 {
    public static void main(String[] args) {
        //5,4,8,11,null,13,4,7,2,null,null,null,1 | targetSum = 22
        TreeNode root = new TreeNode(5,
                new TreeNode(4,new TreeNode(11,new TreeNode(7,null,null),new TreeNode(2,null,null)),null),
                new TreeNode(8,new TreeNode(13,null,null),new TreeNode(4,null,new TreeNode(1,null,null))));
        //TreeNode root = new TreeNode(1,new TreeNode(2,null,null),null);
        System.out.println(hasPathSum(root,22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        } else if(root.left()==null && root.right()==null) {
            return targetSum - root.val() == 0;
        } else {
            return hasPathSum(root.left(),targetSum-root.val()) || hasPathSum(root.right(),targetSum-root.val());
        }
    }

    //null node should not be tested for targetSum == 0 instead leaf node should be tested
    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root == null) {
            return targetSum == 0;
        }
        return hasPathSum2(root.left(),targetSum-root.val()) ||
                hasPathSum2(root.right(),targetSum-root.val());
    }

    public static boolean hasPathSum3(TreeNode root, int targetSum) {
        if(root == null) {
            return targetSum == 0;
        }
        if(root.left() == null && root.right() == null) {
            return targetSum - root.val() == 0;
        } else if(root.left()==null) {
            return hasPathSum3(root.right(),targetSum-root.val());
        } else {
            return hasPathSum3(root.left(),targetSum-root.val());
        }
    }
}
