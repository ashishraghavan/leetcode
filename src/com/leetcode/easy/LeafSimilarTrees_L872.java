package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

import java.util.ArrayList;
import java.util.List;

//prob # 872 - leaf similar trees
public class LeafSimilarTrees_L872 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(7,
                new TreeNode(6),new TreeNode(9));
        TreeNode right = new TreeNode(2,
                new TreeNode(1), new TreeNode(3));
        TreeNode root = new TreeNode(4,left,right);

        TreeNode left2 = new TreeNode(7);
        TreeNode right2 = new TreeNode(2,
                new TreeNode(3), new TreeNode(1));
        TreeNode root2 = new TreeNode(4,left2,right2);
        System.out.println(leafSimilar(root,root2));
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> rList1 = new ArrayList<>();
        List<Integer> rList2 = new ArrayList<>();
        leaves(root1,rList1);
        System.out.println(rList1);
        leaves(root2,rList2);
        System.out.println(rList2);
        return rList1.equals(rList2);
        //return false;
    }

    public static void leaves(TreeNode root, List<Integer> list) {
        if(root == null)return;
        else if(root.left() == null && root.right() == null) {
            list.add(root.val());
        } else {
            leaves(root.left(),list);
            leaves(root.right(),list);
        }
    }
}
