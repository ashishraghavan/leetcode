package com.leetcode.medium.tree;

import com.leetcode.tree.core.TreeNode;

//prob #1302 - deepest leaves sum
public class DeepestLeavesSum_L1302 {
    static int sum = 0;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode left = new TreeNode(7,new TreeNode(2,new TreeNode(9,new TreeNode(10),null),null),new TreeNode(5,new TreeNode(1),new TreeNode(4,null,new TreeNode(15,new TreeNode(17),null))));
        TreeNode right = new TreeNode(8,new TreeNode(0),new TreeNode(3));
        TreeNode root = new TreeNode(6,left,right);
        System.out.println(deepestLeavesSum(root));
    }

    public static int deepestLeavesSum(TreeNode root) {
        if(root.left == null && root.right == null)return root.val;
        maxPath(root,0);
        nodeSumOfMaxPath(root,0);
        return sum;
    }

    public static int maxPath(TreeNode root, int cnt) {
        if(root == null)return 0;
        if(root.left == null && root.right == null)return cnt;
        cnt++;
        int leftCnt = maxPath(root.left,cnt);
        int rightCnt = maxPath(root.right,cnt);
        max = Math.max(max,Math.max(leftCnt,rightCnt));
        return max;
    }

    public static void nodeSumOfMaxPath(TreeNode root,int cnt) {
        if(root == null)return;
        if((root.left == null && root.right == null) && cnt == max) sum += root.val;
        cnt++;
        nodeSumOfMaxPath(root.left,cnt);
        nodeSumOfMaxPath(root.right,cnt);
    }
}
