package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBinarySearchTree {
    public static void main(String[] args) {
        //we need kth smallest number in a tree
        int k = 4;
        BinarySearchTree bst = new BinarySearchTree(8);
        bst.insertNode(6);
        bst.insertNode(5);
        bst.insertNode(4);
        bst.insertNode(7);
        bst.insertNode(10);
        bst.insertNode(9);
        bst.insertNode(12);
        bst.insertNode(11);
        bst.insertNode(13);
        Node node = bst.getRoot();
        List<Integer> l = new ArrayList<>();
        inOrder(node,l);
        //System.out.print(l);
        System.out.println("kth smallest number is : "+l.get(k - 1));
    }

    static void inOrder(Node node, List<Integer> l) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft(),l);
        l.add(node.getValue());
        inOrder(node.getRight(),l);
    }
}
