package com.algomonster.problems.depthfirstsearch;

import com.algomonster.problems.Utilities;

import java.util.Arrays;
import java.util.Collection;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Collection<String> list = Arrays.asList("1","2","4","x","7","x","x","5","x","x","3","x","6","x","x");
        Node<Integer> root = Utilities.buildTree(list.iterator(),Integer::parseInt);
        Node<Integer> invTree = invertBinaryTree(root);
        assert invTree != null;
        //System.out.println();
    }

    public static Node<Integer> invertBinaryTree(Node<Integer> root) {
        if(root == null)return null;
        return dfs(root);
    }

    public static Node<Integer> dfs(Node<Integer> root) {
        if(root == null)return null;
        Node<Integer> left = dfs(root.left);
        Node<Integer> right = dfs(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
