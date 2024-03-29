package com.leetcode.practice;

public class BinaryTreeTester {
    public static void main(String[] args) {
        Integer[] treeArray = new Integer[]{1,2,3,4,5};
        BinaryTree binaryTree = new BinaryTree(treeArray[0]);
        for(int i=1;i<treeArray.length;i++) {
            binaryTree.insertNode(treeArray[i]);
        }
        binaryTree.branchedInsertNode(BinaryTree.DIRECTION.RIGHT, 6);
        /*bst.insertNode(3);
        bst.insertNode(10);
        bst.insertNode(1);
        bst.insertNode(4);
        bst.insertNode(7);
        bst.insertNode(12);
        bst.insertNode(2);
        bst.insertNode(14);*/
        //binaryTree.preOrderTraversal();
        //5,3,10,1,4,7,12,2,14
        binaryTree.inOrderTraversal();
    }

    public static Node createBinaryTree(Integer lastNodeValue, BinaryTree.DIRECTION direction) {
        int[] treeArray = new int[]{1,2,3,4,5};
        BinaryTree binaryTree = new BinaryTree(treeArray[0]);
        for(int i=1;i<treeArray.length;i++) {
            binaryTree.insertNode(treeArray[i]);
        }
        if (lastNodeValue != null) {
            //default direction is RIGHT
            if (direction == null) {
                direction = BinaryTree.DIRECTION.RIGHT;
            }
            binaryTree.branchedInsertNode(direction, lastNodeValue);
        }
        return binaryTree.getRoot();
    }

    //bin tree with 8 nodes
    public static BinaryTree createBinaryTree() {
        int[] treeArray = new int[]{1,2,3,4,5};
        BinaryTree binaryTree = new BinaryTree(treeArray[0]);
        for(int i=1;i<treeArray.length;i++) {
            binaryTree.insertNode(treeArray[i]);
        }
        binaryTree.branchedInsertNode(BinaryTree.DIRECTION.RIGHT, 6);
        binaryTree.branchedInsertNode(BinaryTree.DIRECTION.RIGHT, 7);
        binaryTree.branchedInsertNode(BinaryTree.DIRECTION.LEFT, 8);
        return binaryTree;
    }

    //bin tree with 7 fixed nodes
    public static BinaryTree createStaticBinaryTree() {
        //int[] treeArray = new int[]{1,2,3,4,5,6,7};
        int[] treeArray = new int[]{1,2,3,7,6,5,4};
        BinaryTree binaryTree = new BinaryTree(treeArray[0]);
        for(int i=1;i<treeArray.length-2;i++) {
            binaryTree.insertNode(treeArray[i]);
        }
        binaryTree.branchedInsertNode(BinaryTree.DIRECTION.RIGHT, treeArray[treeArray.length - 2]);
        binaryTree.branchedInsertNode(BinaryTree.DIRECTION.RIGHT, treeArray[treeArray.length - 1]);
        return binaryTree;
    }
}
