package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

import java.util.List;
import java.util.Objects;

//prob #100 - is same tree
public class IsSameTree_L100 {
    public static void main(String[] args) {
        //new TreeNode(8),null
        TreeNode right1 = new TreeNode(2,new TreeNode(3),new TreeNode(4,null,new TreeNode(5)));
        TreeNode right2 = new TreeNode(2,new TreeNode(3),new TreeNode(4,null,new TreeNode(5)));
        TreeNode root1 = new TreeNode(1,null,right1);
        TreeNode root2 = new TreeNode(1,null,right2);

//        TreeNode left1 = new TreeNode(2,null,new TreeNode(2,new TreeNode(2),null));
//        TreeNode right1 = new TreeNode(2);
//
//        TreeNode left2 = new TreeNode(2,new TreeNode(2),null);
//        TreeNode right2 = new TreeNode(2,new TreeNode(2),null);
//
//        TreeNode root1 = new TreeNode(2,left1,right1);
//        TreeNode root2 = new TreeNode(2,left2,right2);


//        TreeNode root1 = new TreeNode(1,new TreeNode(2),new TreeNode(3));
//        TreeNode root2 = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        System.out.println(isSameTreeII(root1,root2));
    }

    //do inorder traversal for both trees & store in two different strings - s1,s2
    //return s1.equals(s2)
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        doPreOrderTrv(p,sb1);
        doPreOrderTrv(q,sb2);
        System.out.println(sb1);
        System.out.println(sb2);
        return sb1.toString().contentEquals(sb2);
        //return false;
    }

    public static boolean isSameTreeII(TreeNode p, TreeNode q) {
        if(p == q)return true;
        if((p == null && q != null) || (p != null && q == null) || (p.val != q.val))return false;
        return isSameTreeII(p.left,q.left) && isSameTreeII(p.right,q.right);
    }

    public static void doInOrderTrv(TreeNode root,StringBuilder sb) {
        if(root == null)return;
        if(root.left == null)sb.append("#");
        doInOrderTrv(root.left,sb);
        sb.append(root.val);
        if(root.right == null)sb.append("#");
        doInOrderTrv(root.right,sb);
    }

    public static void doPreOrderTrv(TreeNode root,StringBuilder sb) {
        if(root == null)return;
        sb.append(root.val);
        doPreOrderTrv(root.left,sb);
        doPreOrderTrv(root.right,sb);
    }
}
