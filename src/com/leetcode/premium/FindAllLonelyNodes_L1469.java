package com.leetcode.premium;

import com.leetcode.tree.core.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//prob # 1469 - find all lonely nodes, [tree],[premium]
public class FindAllLonelyNodes_L1469 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
//        TreeNode left = new TreeNode(1,new TreeNode(6),null);
//        TreeNode right = new TreeNode(4,new TreeNode(5),new TreeNode(3,null,new TreeNode(2)));
//        TreeNode root = new TreeNode(7,left,right);

        TreeNode left = new TreeNode(99,new TreeNode(77,new TreeNode(55,new TreeNode(33),null),null),null);
        TreeNode right = new TreeNode(88,null,new TreeNode(66,null,new TreeNode(44,null,new TreeNode(22))));
        TreeNode root = new TreeNode(11,left,right);
        System.out.println(Arrays.toString(lonelyNodes(root)));
    }


    public static int[] lonelyNodes(TreeNode root) {
        ctLonelyNodes(root);
        System.out.println(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static TreeNode ctLonelyNodes(TreeNode root) {
        if(root == null)return null;
        else if(root.left == null && root.right == null)return root;
        else {
            TreeNode leftChild = ctLonelyNodes(root.left);
            TreeNode rightChild = ctLonelyNodes(root.right);
            if(leftChild == null || rightChild == null) {
                list.add(leftChild == null ? rightChild.val : leftChild.val);
            }
            return root;
        }
    }
}
