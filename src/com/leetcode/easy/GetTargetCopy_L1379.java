package com.leetcode.easy;

import com.leetcode.tree.core.TreeNode;

public class GetTargetCopy_L1379 {
    public static void main(String[] args) {
        TreeNode left = new TreeNode(6,null,null);
        TreeNode right = new TreeNode(19,null,null);
        TreeNode rtnode = new TreeNode(3,left,right);
        TreeNode ltnode = new TreeNode(4,null,null);
        TreeNode orig = new TreeNode(7,ltnode,rtnode);

        TreeNode leftC = new TreeNode(6,null,null);
        TreeNode rightC = new TreeNode(19,null,null);
        TreeNode rtnodeC = new TreeNode(3,leftC,rightC);
        TreeNode ltnodeC = new TreeNode(4,null,null);
        TreeNode cloned = new TreeNode(7,ltnodeC,rtnodeC);

        //8,null,6,null,5,null,4,null,3,null,2,null,1
        TreeNode one = new TreeNode(1,null,null);
        TreeNode two = new TreeNode(2,null,one);
        TreeNode three = new TreeNode(3,null,two);
        TreeNode four = new TreeNode(4,null,three);
        TreeNode five = new TreeNode(5,null,four);
        TreeNode six = new TreeNode(6,null,five);
        TreeNode tc3 = new TreeNode(8,null,six);

        TreeNode oneC = new TreeNode(1,null,null);
        TreeNode twoC = new TreeNode(2,null,oneC);
        TreeNode threeC = new TreeNode(3,null,twoC);
        TreeNode fourC = new TreeNode(4,null,threeC);
        TreeNode fiveC = new TreeNode(5,null,fourC);
        TreeNode sixC = new TreeNode(6,null,fiveC);
        TreeNode tc3Cloned = new TreeNode(8,null,sixC);

        System.out.println(getTargetCopy(tc3,tc3Cloned,four).val());
    }

    //int val = target.getVal();
    //search cloned tree for this value i.e. return TreeNode res where res.val() == target.val()
    //it is given that values of the tree are unique
    public static TreeNode getTargetCopy(final TreeNode original,
                                         final TreeNode cloned,
                                         final TreeNode target) {
        int targetVal = target.val();
        return search(targetVal,cloned);
    }

    public static TreeNode search(int targetVal,TreeNode root) {
        if(root == null)return null;
        if(root.val() == targetVal)return root;
        TreeNode left = search(targetVal,root.left());
        if(left != null)return left;
        return search(targetVal,root.right());
    }
}
