package com.leetcode.practice;

public class MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = doInserts();
        System.out.println("height of binary tree : "+maxDepth(tree.getRoot()));
    }

    static int maxDepth(Node root) {
        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }

    static int height(Node node) {
        if (node == null) {
            return 0;
        } else if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        } else {
            return 1 + Math.max(height(node.getLeft()),height(node.getRight()));
        }
    }

//    private static BinaryTree doInserts() {
//        BinaryTree bt = new BinaryTree(1);
//        bt.insertNode(6);
//        bt.insertNode(2);
//        bt.insertNode(7);
//        bt.insertNode(8);
//        Node found = bt.search(2);
//        found.setLeft(new Node(3));
//        found.setRight(new Node(4));
//        found = bt.search(8);
//        found.setLeft(new Node(9));
//        found.setRight(new Node(5));
//        found.getRight().setRight(new Node(10));
//        //bt.inOrderTraversal();
//        return bt;
//    }

    private static BinaryTree doInserts() {
        BinaryTree bt = new BinaryTree(1);
        bt.insertNode(2);
        Node found = bt.search(2);
        found.setLeft(new Node(3));
        found.getLeft().setLeft(new Node(4));
        return bt;
    }
}
