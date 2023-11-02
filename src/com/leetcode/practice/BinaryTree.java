package com.leetcode.practice;

public class BinaryTree extends BinarySearchTree {

    public enum DIRECTION {
        LEFT,
        RIGHT
    }

    public BinaryTree(int rootValue) {
        super(rootValue);
    }

    @Override
    public void insertNode(int value) {
        this.rInsert(getRoot(),value);
    }

    public void branchedInsertNode(DIRECTION direction, int value) {
        boolean wasInserted = (direction == DIRECTION.LEFT? rInsert(getRoot().getLeft(),value) : rInsert(getRoot().getRight(),value));
        System.out.println("was node inserted? - "+wasInserted);
    }

    //insert into a binary tree - each node has only two children
    public boolean rInsert(Node node, int value) {
        if (node.getLeft() == null) {
            Node left = new Node(value);
            node.setLeft(left);
            return true;
        } else if (node.getRight() == null) {
            Node right = new Node(value);
            node.setRight(right);
            return true;
        } else {
            return rInsert(node.getLeft(),value) || rInsert(node.getRight(),value);
        }
    }
}
