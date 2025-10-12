package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

import java.util.ArrayList;
import java.util.List;

//TODO: [solved][tree], can be solved in a better way
//prob #530 - minimum absolute difference in bst
public class MinimumDifferenceInBST_L530 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        TreeNode right = new TreeNode(6);
        TreeNode root = new TreeNode(4,left,right);

        TreeNode left1 = new TreeNode(980,new TreeNode(980),new TreeNode(980));
        TreeNode right1 = new TreeNode(1002,null,new TreeNode(1003));
        TreeNode root1 = new TreeNode(1000,left1,right1);

        TreeNode left2 = new TreeNode(384,null,new TreeNode(445));
        TreeNode right2 = new TreeNode(652,null,new TreeNode(699));
        TreeNode root2 = new TreeNode(543,left2,right2);
        System.out.println(getMinimumDifference(root2));
    }

    //do inorder traversal, return difference
    //between value at index 1 - value at index 0
    public static int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root,list);
        System.out.println(list);
        //return inOrdArr.get(1) - inOrdArr.get(0);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++) {
            min = Math.min((list.get(i) - list.get(i-1)),min);
        }
        return min;
    }

    public static void inOrderTraversal(TreeNode root,List<Integer> inOrdArr) {
        if(root==null)return;
        inOrderTraversal(root.left(),inOrdArr);
        inOrdArr.add(root.val());
        inOrderTraversal(root.right(),inOrdArr);
    }
}
