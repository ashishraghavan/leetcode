package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

//TODO: definitely revise, [tree], check - https://algo.monster/liteproblems/543 for solution
//prob #543 - diameter of binary tree
public class DiameterOfBinaryTree_L543 {
//    static int leftSum;
//    static int rightSum;
    static int maxSum = Integer.MIN_VALUE;
    static int maxDmtr = Integer.MIN_VALUE;
    public static void main(String[] args) {
        //TreeNode left = new TreeNode(2,new TreeNode(4),new TreeNode(5,null,new TreeNode(7)));
        TreeNode left = new TreeNode(2,new TreeNode(4),new TreeNode(5));
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1,left,right);
        System.out.println(diameterOfBinaryTreeIII(root));
    }

    //for each node return 2 + height_of_left_subtree + height_of_right_subtree
    //for each node,
        //traverse as much left as possible adding 1 everytime you do root.left = leftSum
        //traverse as much right as possible adding 1 everytime you do root.right = rightSum
        //return max(maxSum,leftSum + rightSum)
    public static int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null))return 0;
        int leftSum = 0,rightSum = 0;
        if(root.left != null) {
            leftSum = diameterOfBinaryTree(root.left);
        }
        if(root.right != null) {
            rightSum = diameterOfBinaryTree(root.right);
        }
        maxSum = Math.max(maxSum,leftSum + rightSum);
        return 1 + maxSum;
    }

    public static int diameterOfBinaryTreeII(TreeNode root) {
        calcHt(root);
        return maxDmtr;
    }

    public static int calcHt(TreeNode root) {
        if(root == null)return 0;
        int leftHt = calcHt(root.left);
        int rightHt = calcHt(root.right);
        maxDmtr = Math.max(maxDmtr,leftHt + rightHt);
        return 1 + Math.max(leftHt,rightHt);
    }

    //for each node
        //max(maxDmtr,max depth of left subtree + max depth of right subtree)
        //return 1 + max(max depth of left subtree,max depth of right subtree)
    public static int diameterOfBinaryTreeIII(TreeNode root) {
        maxDepth(root);
        return maxDmtr;
    }

    public static int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);
        maxDmtr = Math.max(maxDmtr,maxLeftDepth + maxRightDepth);
        return 1 + Math.max(maxLeftDepth,maxRightDepth);
    }
}
