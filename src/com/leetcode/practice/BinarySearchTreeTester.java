package com.leetcode.practice;

public class BinarySearchTreeTester {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(5);
        bst.insertNode(3);
        bst.insertNode(10);
        bst.insertNode(1);
        bst.insertNode(4);
        bst.insertNode(7);
        bst.insertNode(12);
        bst.insertNode(2);
        bst.insertNode(14);
        bst.preOrderTraversal();
        //5,3,10,1,4,7,12,2,14
    }
}
