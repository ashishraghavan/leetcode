package com.leetcode.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigZagLevelOrderBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = BinaryTreeTester.createStaticBinaryTree();
        Deque<Node> q = new ArrayDeque<>();
        List<Node> l = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        boolean rev = false;
        q.offer(tree.getRoot());
        while(!q.isEmpty()) {
            l.clear();
            while(q.peekFirst() != null) {
                l.add(q.pollFirst());
            }
            if (!rev) {
                addAll(res,l);
            } else {
                reverseAddAll(res,l);
            }
            rev = !rev;
            for (Node node : l) {
                if (node.getLeft() != null) {
                    q.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    q.offer(node.getRight());
                }
            }
        }
        System.out.print(res);
    }

    private static void addAll(List<Integer> res, List<Node> l) {
        for (Node node : l) {
            res.add(node.getValue());
        }
    }

    private static void reverseAddAll(List<Integer> res, List<Node> l) {
        for (int i = l.size() - 1; i>=0; i--) {
            res.add(l.get(i).getValue());
        }
    }
}
