package com.leetcode.practice;

import com.leetcode.tree.core.TreeNode;

import java.util.Arrays;

//prob #108 - sorted array to binary search tree
public class SortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        //-10,-3,0,5,9
        TreeNode bst = sortedArrayToBST(new int[]{2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47, 50, 53, 56, 59, 62, 65, 68, 71, 74, 77, 80, 83, 86, 89, 92, 95, 98, 101, 104, 107, 110, 113, 116, 119, 122, 125, 128, 131, 134, 137, 140, 143, 146, 149, 152, 155, 158, 161, 164, 167, 170, 173, 176, 179, 182, 185, 188, 191, 194, 197, 200, 203, 206, 209, 212, 215, 218, 221, 224, 227, 230, 233, 236, 239, 242, 245, 248, 251, 254, 257, 260, 263, 266, 269, 272, 275, 278, 281, 284, 287, 290, 293, 296, 299});
        assert bst != null;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)return null;
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,nums.length));
        return root;
    }
}
