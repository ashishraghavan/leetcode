package com.leetcode.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeDiagonalTraversal {
    public static void main(String[] args) {
        BinaryTree bt = doInserts();
        List<Integer> res = new ArrayList<>();
        Deque<Node> q = new ArrayDeque<>();
        q.offer(bt.getRoot());
        while(!q.isEmpty()) {
            Node curr = q.poll();
            while(curr != null) {
                res.add(curr.getValue());
                if (curr.getLeft() != null) {
                    q.offer(curr.getLeft());
                }
                curr = curr.getRight();
            }
        }
        System.out.print(res);
    }

    //T.C #1
    private static BinaryTree doInserts() {
        BinaryTree bt = new BinaryTree(1);
        bt.insertNode(4);
        bt.insertNode(2);
        bt.insertNode(8);
        bt.insertNode(5);
        Node found = bt.search(2);
        found.setRight(new Node(3));
        found.getRight().setLeft(new Node(6));
        found = bt.search(5);
        found.setLeft(new Node(9));
        found.setRight(new Node(7));
        //bt.inOrderTraversal();
        return bt;
    }

    //T.C #2
//    private static BinaryTree doInserts() {
//        BinaryTree bt = new BinaryTree(7);
//        bt.insertNode(6);
//        bt.insertNode(10);
//        bt.insertNode(2);
//        bt.insertNode(3);
//        Node found = bt.search(10);
//        found.setLeft(new Node(9));
//        bt.inOrderTraversal();
//        return bt;
//    }
}
