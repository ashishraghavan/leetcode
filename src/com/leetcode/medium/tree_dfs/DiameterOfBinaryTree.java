package com.leetcode.medium.tree_dfs;

import java.util.Arrays;

//#543
public class DiameterOfBinaryTree {
    static int dMeter = 0;
    public static void main(String[] args) {
        //Arrays.asList(1,2,3,4,5)
        //Arrays.asList(1, 2, null, 3, 4, 5, null, null, 6)
        //Arrays.asList(1)
        //Arrays.asList(1, 2)
        //Arrays.asList(1, 2, null, 3, null, 4, null, 5)
        //Arrays.asList(1, null, 2, null, 3, null, 4, null, 5)
        //Arrays.asList(1, 2, 3, 4, 5, 6, 7) -> fail(2 vs 4)
        TreeNode root = BinaryTreeBuilder.buildTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(diameterOfBinaryTree(root));
    }

    //ans = max depth of left subtree + max depth of right subtree
    //for each node, check above
    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return dMeter;
    }

    //refer https://share.gemini.google/0csPQaGAdMvc for better explanation
    //think about bottom-up recursion
    public static int depth(TreeNode node) {
        if(node == null)return 0;

        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        dMeter = Math.max(dMeter,leftDepth + rightDepth);

        //doing below so that the parent doesn't have to recalculate the depth
        //ex. for resources/diameter_of_binary_tree_example-gemini-2.png consider
        //depth calculation for root node = 1
        //line #32 gets called for 1->2->4. Next call node.left = null as 4->left=null
        //so returns 0 -> leftDepth = 0, now onto line 33, go right of 4 -> 4->right=null
        //so returns 0 -> rightDepth = 0, dMeter = max(0,0+0) = 0
        //and we return 1 + max(4.leftDepth,4.rightDepth) to its parent i.e.
        //2 => we return 1 + 0 = 1 to 2 i.e. leftDepth of node 2 = 1
        return 1 + Math.max(leftDepth,rightDepth);
    }
}
