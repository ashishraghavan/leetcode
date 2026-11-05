package com.leetcode.medium.tree_dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//#113
public class PathSumII {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        //Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,5,1)
        //Arrays.asList(1, 2, 2, 3, 4, 4, 3)
        TreeNode root = BinaryTreeBuilder.buildTree(Arrays.asList(0, 0, 0, 0, null, null, 0));
        int targetSum = 0;
        System.out.println(pathSum(root,targetSum));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        helper(root,list,0,targetSum);
        return result;
    }

    public static void helper(TreeNode node,List<Integer> list,int currSum,int targetSum) {
        if(node == null)return;
        currSum += node.val;
        list.add(node.val);
        if(node.left == null && node.right == null) {
            //if this is a leaf node
            if(currSum == targetSum) {
                //and our sum including this leaf node matches targetSum, add the list to result
                result.add(new ArrayList<>(list));
            }
        } else {
            //navigate left child of this node recursively
            helper(node.left,list,currSum,targetSum);
            //navigate right child of this node recursively
            helper(node.right,list,currSum,targetSum);
        }
        //remove the last node val from list as we go back up since the sum including this last node was not equal to targetSum
        list.remove(list.size()-1);
    }

    public static void dfs(TreeNode node,List<Integer> list,List<List<Integer>> result,int currSum,int targetSum) {
        if(node == null)return;
        currSum+=node.val;
        list.add(node.val);
        if(node.left == null && node.right == null) {
            if(currSum == targetSum) {
                result.add(new ArrayList<>(list));
            }
        } else {
            dfs(node.left,list,result,currSum,targetSum);
            dfs(node.right,list,result,currSum,targetSum);
        }
        list.remove(list.size()-1);
    }
}
