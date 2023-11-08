package com.leetcode.practice;

import java.util.Arrays;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        BinaryTree bt = doInserts();
        int[] res = recoverBST(bt.getRoot());
        System.out.print(Arrays.toString(res));
    }

    //uses morris traversal algorithm to achieve O(n) time, O(1) space
    private static int[] recoverBST(Node curr) {
        int[] res = new int[]{};
        while (curr != null) {
            if (curr.getRight() != null && curr.getValue() > curr.getRight().getValue()) {
                return new int[]{curr.getValue(),curr.getRight().getValue()};
            }
            if (curr.getLeft() != null) {
                if (curr.getValue() < curr.getLeft().getValue()) {
                    return new int[]{curr.getValue(),curr.getLeft().getValue()};
                }
                Node pred = findPred(curr.getLeft(),curr);
                if (pred.getRight() == null) {
                    pred.setRight(curr);
                    curr = curr.getLeft();
                } else {
                    pred.setRight(null);
                    curr = curr.getRight();
                }
            } else {
                curr = curr.getRight();
            }
        }
        return res;
    }

    private static Node findPred(Node node,Node curr) {
        while (node.getRight() != null && node.getRight() != curr) {
            node = node.getRight();
        }
        return node;
    }

    private static BinaryTree doInserts() {
        BinaryTree bt = new BinaryTree(7);
        bt.insertNode(6);
        bt.insertNode(10);
        bt.insertNode(2);
        bt.insertNode(3);
        Node found = bt.search(10);
        found.setLeft(new Node(9));
//        Node found = bt.search(3);
//        found.setLeft(new Node(2));
//        found = bt.search(2);
//        found.setLeft(new Node(1));
//        found = bt.search(3);
//        found.setRight(new Node(6));
//        found = bt.search(6);
//        found.setLeft(new Node(5));
//        found = bt.search(5);
//        found.setLeft(new Node(4));
//        found = bt.search(9);
//        found.setLeft(new Node(10));


        //bt.inOrderTraversal();
        return bt;
    }
}
