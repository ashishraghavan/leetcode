package com.leetcode.practice;

public class BinaryTree extends BinarySearchTree {

    public BinaryTree(int rootValue) {
        super(rootValue);
    }

    @Override
    public void insertNode(int value) {
        this.searchAndInsert(getRoot(),value);
    }

    @Override
    protected void searchAndInsert(Node node, int value) {
        Node parent = node;
        Node currentNode = node;
        while(currentNode != null) {
            if(value <= currentNode.getValue()) {
                parent = currentNode;
                currentNode = currentNode.getLeft();
            } else if(value >= currentNode.getValue()) {
                parent = currentNode;
                currentNode = currentNode.getRight();
            }
        }
        currentNode = new Node(value);
        if(value <= parent.getValue()) {
            parent.setLeft(currentNode);
        } else {
            parent.setRight(currentNode);
        }
    }
}
