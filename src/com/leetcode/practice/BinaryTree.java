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

    public Node search(int value) {
        if (this.getRoot() == null) {
            System.out.println("can't traverse tree without a root");
            return null;
        }
        return rSearch(this.getRoot(), value);
    }

    private Node rSearch(Node curr, int value) {
        if (curr == null) {
            return null;
        }
        if (curr.getValue() == value) {
            return curr;
        }
        Node left, right = null;
        left = rSearch(curr.getLeft(),value);
        if (left == null) {
            right = rSearch(curr.getRight(),value);
        }
        if (left == null && right == null) {
            return null;
        } else {
            return left != null ? left : right;
        }
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
