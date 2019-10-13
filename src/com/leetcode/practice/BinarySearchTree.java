package com.leetcode.practice;

import javax.naming.BinaryRefAddr;

public class BinarySearchTree {
    private Node node;
    private Node root = null;
    public BinarySearchTree(int rootValue) {
        root = new Node(rootValue);
        root.setLeft(null);
        root.setRight(null);
    }

    private BinarySearchTree(){}

    public void insertNode(int value) {
        //Insert in the proper place.
        searchAndInsert(this.root,value);
    }

    public void print() {
        printInOrder(this.root);
    }

    public void inOrderTraversal() {
        printInOrder(this.root);
    }

    public void preOrderTraversal() {
        //root, left child, right child
        preOrder(this.root);
    }

    public void postOrderTraversal() {

    }

    private void searchAndInsert(Node node,int value) {
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

    private void printInOrder(Node node) {
        if(node.getLeft() == null && node.getRight() == null) {
            System.out.println(node.getValue());
        } else {
            if(node.getLeft() != null) {
                printInOrder(node.getLeft());
            }
            System.out.println(node.getValue());
            if(node.getRight() != null) {
                printInOrder(node.getRight());
            }
        }
    }

    private void preOrder(Node node) {
        if((node.getLeft() != null || node.getRight() != null) ||
                (node.getLeft() == null && node.getRight() == null)) {
            System.out.println(node.getValue());
        }
        if(node.getLeft() != null) {
            preOrder(node.getLeft());
        }
        if(node.getRight() != null) {
            preOrder(node.getRight());
        }
    }
}
