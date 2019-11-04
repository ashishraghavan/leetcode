package com.leetcode.practice;

public class BinaryTreeTester {
    public static void main(String[] args) {
        Integer[] treeArray = new Integer[]{1,2,3,4};
        BinaryTree binaryTree = new BinaryTree(treeArray[0]);
        for(int i=1;i<treeArray.length;i++) {
            binaryTree.insertNode(treeArray[i]);
        }
        /*bst.insertNode(3);
        bst.insertNode(10);
        bst.insertNode(1);
        bst.insertNode(4);
        bst.insertNode(7);
        bst.insertNode(12);
        bst.insertNode(2);
        bst.insertNode(14);*/
        binaryTree.preOrderTraversal();
        //5,3,10,1,4,7,12,2,14
    }
}
