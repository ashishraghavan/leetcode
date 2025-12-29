package com.algomonster.problems.depthfirstsearch;

import com.algomonster.problems.Utilities;

import java.util.Arrays;
import java.util.Collection;

public class InsertIntoBST {
    public static void main(String[] args) {
        Collection<String> list = Arrays.asList("8","5","2","x","3","x","x","6","x","x","10","x","14","x","x");
        //Collection<String> list = Arrays.asList("1","2","4","x","7","x","x","5","x","x","3","x","6","8","x","x","x");
        Node<Integer> root = Utilities.buildTree(list.iterator(),Integer::parseInt);
        Node<Integer> newBst = insertBst(root,3);
        assert newBst != null;
    }

    public static Node<Integer> insertBst(Node<Integer> root, int val) {
        if(root == null)return new Node<>(val);
        dfs(root,root,val);
        return root;
    }

    public static void dfs(Node<Integer> root,Node<Integer> parent,int val) {
        if(root == null) {
            Node<Integer> node = new Node<>(val);
            if(val < parent.val) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            return;
        }
        if(root.val == val)return;
        if(val < root.val) {
            dfs(root.left,root,val);
        } else {
            dfs(root.right,root,val);
        }
    }
}
