package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPathsWithSum {
    public static void main(String[] args) {
        BinaryTree tree = doInserts();
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        path.add(tree.getRoot().getValue());
        rootToLeaf(tree.getRoot(), path, tree.getRoot().getValue(),22,res);
        System.out.print(res);
    }

    private static void rootToLeaf(Node node, List<Integer> path, int currSum, int sum, List<List<Integer>> res) {
        if (node.getLeft() == null && node.getRight() == null) {
            if (currSum == sum) {
                List<Integer> currPath = new ArrayList<>(path);
                res.add(currPath);
            }
        } else if (node.getLeft() == null) {
            path.add(node.getRight().getValue());
            rootToLeaf(node.getRight(), path, currSum + node.getRight().getValue(), sum, res);
            path.remove(path.size() - 1);
        } else if (node.getRight() == null) {
            path.add(node.getLeft().getValue());
            rootToLeaf(node.getLeft(), path, currSum + node.getLeft().getValue(), sum, res);
            path.remove(path.size() - 1);
        } else {
            path.add(node.getLeft().getValue());
            rootToLeaf(node.getLeft(), path, currSum + node.getLeft().getValue(), sum, res);
            path.remove(path.size() - 1);
            path.add(node.getRight().getValue());
            rootToLeaf(node.getRight(), path, currSum + node.getRight().getValue(), sum, res);
            path.remove(path.size() - 1);
        }
    }

    private static BinaryTree doInserts() {
        BinaryTree bt = new BinaryTree(5);
        bt.insertNode(4);
        bt.insertNode(8);
        bt.insertNode(11);
        Node found = bt.search(11);
        found.setLeft(new Node(7));
        found.setRight(new Node(2));
        found = bt.search(8);
        found.setLeft(new Node(13));
        found.setRight(new Node(4));
        found.getRight().setRight(new Node(1));
        found.getRight().setLeft(new Node(5));
//        bt.inOrderTraversal();
        return bt;
    }
}
