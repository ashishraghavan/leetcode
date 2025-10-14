package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

//definitely revise, [tree], refer https://algo.monster/liteproblems/572 for alternative solution
//prob #572 - subtree of another tree
public class SubTreeOfAnotherTree_L572 {
    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(4,new TreeNode(1),new TreeNode(2,new TreeNode(0),null));
        TreeNode right1 = new TreeNode(5);
        TreeNode root = new TreeNode(3,left1,right1);

        //TreeNode subRoot = new TreeNode(4,new TreeNode(1),new TreeNode(2));
        //TreeNode subRoot = new TreeNode(3,new TreeNode(4),new TreeNode(5));
        TreeNode subRoot = new TreeNode(4,null,new TreeNode(2,new TreeNode(0),null));
        //TreeNode root = new TreeNode(12);
        //TreeNode subRoot = new TreeNode(2);
        System.out.println(isSubtree(root,subRoot));
    }

    //inorder traversal & comparison
    //root[] = [1,4,2,3,5]
    //subroot[] = [1,4,2]
    //root[] = [1,4,0,2,3,5]
    //subroot[] = [1,4,2]
    ////INCORRECT TO ASSUME THAT INORDER STRING OF ROOT WILL CONTAIN INORDER STRING OF SUBROOT BEGINNING AT INDEX 0
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        StringBuilder rootSb = new StringBuilder();
        StringBuilder subRootSb = new StringBuilder();
        preOrderTraversal(root,rootSb);
        preOrderTraversal(subRoot,subRootSb);
        System.out.println(rootSb);
        System.out.println(subRootSb);
        //return false;
        return rootSb.toString().contains(subRootSb);
    }

    public static void preOrderTraversal(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#");
            return;
        }
        sb.append("/").append(root.val()).append("/");
        preOrderTraversal(root.left(),sb.append(","));
        preOrderTraversal(root.right(),sb.append(","));
    }

    public static boolean isSubtreeII(TreeNode root, TreeNode subRoot) {
        if(root == null)return false;
        return isSame(root,subRoot) ||
                isSame(root.left(),subRoot.left()) ||
                isSame(root.right(),subRoot.right());
    }

    public static boolean isSame(TreeNode root,TreeNode subRoot) {
        //if root == null && subroot != null || root != null && subroot == null || root.val != subroot.val return false
        //return isSame(root.left,subroot.left) && isSame(root.right,subroot.right)
        if(root == null || subRoot == null) {
            return root == subRoot;
        }
        return root.val() == subRoot.val() &&
                isSame(root.left(),subRoot.left()) &&
                isSame(root.right(),subRoot.right());
    }
}
