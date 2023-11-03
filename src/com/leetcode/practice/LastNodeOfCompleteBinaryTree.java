package com.leetcode.practice;

public class LastNodeOfCompleteBinaryTree {
    public static void main(String[] args) {
        //create bin tree - 1,2,3,4,5
        Node root = BinaryTreeTester.createBinaryTree(6, BinaryTree.DIRECTION.RIGHT);
        int heightLeft = 1 + heightLeft(root.getLeft());
        int heightRight = 1 + heightRight(root.getRight());
        System.out.println("ht of left subtree : "+heightLeft+", height of right subtree : "+heightRight);
        if (heightLeft == heightRight) {
            System.out.println(lastChildOnRight(root));
        } else {
            System.out.println(lastChildOnLeft(root.getLeft()));
        }
    }

    static int heightLeft(Node node) {
        if (node == null || (node.getLeft() == null && node.getRight() == null)) {
            return 0;
        } else {
            return 1 + heightLeft(node.getLeft());
        }
    }

    static int heightRight(Node node) {
        if (node == null || node.getLeft() == null) {
            return 0;
        } else {
            return 1 + heightRight(node.getLeft());
        }
    }

    static int lastChildOnRight(Node node) {
        if (node.getRight() == null) {
            return node.getLeft().getValue();
        } else {
            return lastChildOnRight(node.getRight());
        }
    }

    static int lastChildOnLeft(Node node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return node.getValue();
        } else {
            return lastChildOnLeft(node.getRight());
        }
    }
}
