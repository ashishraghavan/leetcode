package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

//TODO: definitely revise, [tree], teaches a different way of finding parent of a given node,
// check https://algo.monster/liteproblems/993 for intuitive solution approach
//prob # 993 - cousins in a binary tree
public class CousinsInBinaryTree_L993 {
    static TreeNode p1,p2;
    static int xVal,yVal;
    static int h1,h2;
    public static void main(String[] args) {
        TreeNode left = new TreeNode(2,null,new TreeNode(4));
        TreeNode right = new TreeNode(3,null,new TreeNode(5));
        TreeNode root = new TreeNode(1,left,right);
        System.out.println(isCousins(root,5,4));
    }

    //what is the height of x
    //what is the height of y
    //if x.ht = y.ht && x.parent != y.parent
    //return true else return false
    //int xHt = height(root,x);
    //int yHt = height(root,y);
    //if(xHt != yHt)return false;
    //TreeNode yParent = getParent(root,y);
    //return !xParent.equals(yParent);
    public static boolean isCousins(TreeNode root, int x, int y) {
        xVal = x;
        yVal = y;
        getParent(root,null,x);
        if(p1!=null)System.out.println("parent of x = "+p1.val());
        getParent(root,null,y);
        if(p2!=null)System.out.println("parent of y = "+p2.val());
        height(root,x,0);
        System.out.println("height of x = "+h1);
        height(root,y,0);
        System.out.println("height of y = "+h2);
        return (p1!=null && p2!=null) && (!p1.equals(p2) && h1 == h2);
    }

    public static void getParent(TreeNode root,TreeNode parent,int xy) {
        if(root == null)return;
        if(root.val() == xy){
            if(root.val() == xVal) {
                p1 = parent;
            } else {
                p2 = parent;
            }
            return;
        }
        getParent(root.left(),root,xy);
        getParent(root.right(),root,xy);
    }

    public static void height(TreeNode root,int node,int cnt) {
        if(root == null)return;
        if(root.val() == node){
            if(root.val() == xVal) {
                h1 = cnt;
            } else {
                h2 = cnt;
            }
            return;
        }
        height(root.left(),node,cnt+1);
        height(root.right(),node,cnt+1);
    }
}
