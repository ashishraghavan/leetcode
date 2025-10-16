package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

//TODO: attempt#1 - solved using https://algo.monster/liteproblems/617, definitely revise,
// attempt#2 - worked it out myself
//prob # 617 - merge two binary trees, [tree]
public class MergeTwoBinaryTrees_L617 {
    public static void main(String[] args) {
        TreeNode tr1 = new TreeNode(1,new TreeNode(3,new TreeNode(5),null),new TreeNode(2));
        TreeNode tr2 = new TreeNode(2,new TreeNode(1,null,new TreeNode(4)),new TreeNode(3,null,new TreeNode(7)));
        TreeNode mergedTree = mergeTreesII(tr1,tr2);
        assert mergedTree != null;
    }

    //if
    public static TreeNode mergeTrees(TreeNode root1,
                                      TreeNode root2) {
        if(root1 == null && root2 == null)return null;
        else if(root1 == null)return root2;
        else if(root2 == null)return root1;
        else {
            TreeNode tr3 = new TreeNode(root1.val() + root2.val());
            tr3.setLeft(mergeTrees(root1.left(),root2.left()));
            tr3.setRight(mergeTrees(root1.right(),root2.right()));
            return tr3;
        }
    }

    public static TreeNode merge(TreeNode tr1,
                                 TreeNode tr2,
                                 TreeNode tr3) {
        if(tr1 == null && tr2 == null)return null;
        else if(tr1 == null)return tr2;
        else if(tr2 == null)return tr1;
        else {
            tr3 = new TreeNode(tr1.val() + tr2.val());
            TreeNode left = merge(tr1.left(),tr2.left(),tr3);
            TreeNode right = merge(tr1.right(),tr2.right(),tr3);
            tr3.setLeft(left);
            tr3.setRight(right);
        }
        return tr3;
    }

    public static TreeNode mergeTreesII(TreeNode root1,
                                      TreeNode root2) {
        if((root1 == null || root2 == null) && root1 == root2)return null;
        else if(root1 == null)return root2;
        else if(root2 == null)return root1;
        else {
            TreeNode root = new TreeNode(root1.val + root2.val);
            root.left = mergeTreesII(root1.left,root2.left);
            root.right = mergeTreesII(root1.right,root2.right);
            return root;
        }
    }
}
