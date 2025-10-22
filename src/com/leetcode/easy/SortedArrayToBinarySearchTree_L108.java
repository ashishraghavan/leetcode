package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

import java.util.Arrays;

//TODO: definitely revise, [tree], good problem involving solving problems
// on trees using recursion. Check https://algo.monster/liteproblems/108 for detailed solution
//prob #108 - sorted array to binary search tree
public class SortedArrayToBinarySearchTree_L108 {
    public static void main(String[] args) {
        //System.out.println();
        //-10,-3,0,5,9
        TreeNode bst = sortedArrayToBST(new int[]{-10,-3,0,5,9});
        assert bst != null;
    }

    //-10,-3,0,5,9
    // start from middle element (mid) - all elements to left
    // of mid are smaller than mid & all elements to the right
    // are greater than mid
    // we have two sub-arrays - [0,mid-1] & [mid+1,n-1] where
    // n=nums.length
    // repeat above step
    // mid = 0, root = 0, left[] = [-10,-3], right[] = [5,9]
    // root.setLeft(findMid(left))
    // root.setRight(findMid(right))

    //-10,-3,0,5,9
    public static TreeNode sortedArrayToBST(int[] nums) {
//        int mid = nums.length/2;
//        TreeNode root = new TreeNode(nums[mid]);
//        findMidSetChild(nums,0,mid-1,root);
//        findMidSetChild(nums,mid+1,nums.length-1,root);
//        return root;
        return buildBST(nums,0,nums.length-1);
    }

    ////My solution
    public static TreeNode sortedArrayToBSTII(int[] nums) {
        if(nums.length == 0)return null;
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,nums.length));
        return root;
    }

    public static TreeNode findMidSetChild(int[] nums,int start,int end,TreeNode root) {
        if(end - start < 0)return null;
        else if(end - start == 0) {
            return new TreeNode(nums[start]);
            //root.val() < nums[start] ? root.setRight(node) : root.
            //return;
        }
        int mid = start + (end-start)/2;
        TreeNode child = new TreeNode(nums[mid]);
        root.setLeft(findMidSetChild(nums,start,mid-1,child));
        root.setRight(findMidSetChild(nums,mid+1,end,child));
        return root;
    }

    public static TreeNode buildBST(int[] nums,int start,int end) {
        if(start > end)return null;
        int mid = start + (end-start)/2;
        TreeNode left = buildBST(nums,start,mid-1);
        TreeNode right = buildBST(nums,mid+1,end);
        return new TreeNode(nums[mid],left,right);
    }
}
