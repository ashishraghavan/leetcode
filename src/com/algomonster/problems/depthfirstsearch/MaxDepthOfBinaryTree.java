package com.algomonster.problems.depthfirstsearch;

import com.algomonster.problems.Utilities;

import java.util.Arrays;
import java.util.Collection;

public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        //Iterator<String> strIt = new
        //5 4 3 7 x 8 x x 6 x x
        Collection<String> list = Arrays.asList("5","4","3","7","x","x","x","8","x","x","6","x","x");
        Node<Integer> root = Utilities.buildTree(list.iterator(),Integer::parseInt);
        System.out.println(treeMaxDepth(root));
    }

    public static int treeMaxDepth(Node<Integer> root) {
        if(root == null)return 0;
        return dfs(root);
    }

    public static int dfs(Node<Integer> root) {
        if(root == null)return 0;
        int left = root.left != null ? 1 + dfs(root.left) : 0;
        int right = root.right != null ? 1 + dfs(root.right) : 0;
        return Math.max(left,right);
    }
}
