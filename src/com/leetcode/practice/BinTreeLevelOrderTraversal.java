package com.leetcode.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinTreeLevelOrderTraversal {
    public static void main(String[] args) {
        //create a binary tree with nodes [1,2,3,4,5,6]
        Node root = BinaryTreeTester.createBinaryTree(6, BinaryTree.DIRECTION.RIGHT);
        Deque<Node> q = new ArrayDeque<>();
        List<Integer> l = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            l.add(curr.getValue());
            if ( curr.getLeft() != null ) {
                q.offer(curr.getLeft());
            }
            if ( curr.getRight() != null ) {
                q.offer(curr.getRight());
            }
        }
        System.out.println(l.toString());
    }
}
