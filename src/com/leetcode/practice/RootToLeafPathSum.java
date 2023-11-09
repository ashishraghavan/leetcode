package com.leetcode.practice;

public class RootToLeafPathSum {
    public static void main(String[] args) {
        BinaryTree tree = doInserts();
        System.out.println(pathSum(tree.getRoot(), 0, 18) ? 1 : 0);
    }

    private static boolean pathSum(Node node, int currSum, int sum) {
        if (node.getLeft() == null && node.getRight() == null) {
            return currSum + node.getValue() == sum;
        } else if (node.getLeft() == null) {
                return pathSum(node.getRight(), currSum + node.getValue(), sum);
            } else if (node.getRight() == null) {
                return pathSum(node.getLeft(), currSum + node.getValue(), sum);
            } else {
                return pathSum(node.getLeft(), currSum + node.getValue(), sum) ||
                        pathSum(node.getRight(), currSum + node.getValue(), sum);
            }
    }

    private static BinaryTree doInserts() {
        BinaryTree bt = new BinaryTree(0);
        bt.insertNode(1);
        bt.insertNode(2);
        bt.insertNode(3);
        bt.insertNode(4);
        Node found = bt.search(4);
        found.setRight(new Node(6));
        found.getRight().setRight(new Node(7));
        found = bt.search(2);
        found.setRight(new Node(5));
        //bt.inOrderTraversal();
        return bt;
    }
}
