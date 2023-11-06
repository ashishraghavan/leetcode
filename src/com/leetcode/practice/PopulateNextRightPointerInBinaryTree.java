package com.leetcode.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PopulateNextRightPointerInBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = BinaryTreeTester.createStaticBinaryTree();
        Deque<Node> q = new ArrayDeque<>();
        List<Node> l = new ArrayList<>();
        q.offer(tree.getRoot());
        while (!q.isEmpty()) {
            l.clear();
            while(q.peekFirst()!= null) {
                l.add(q.pollFirst());
            }
            if (l.size() == 1) {
                l.get(0).setNext(null);
                addChildren(q,l.get(0));
                continue;
            }
            Node prev = l.get(0);
            for (int i = 1; i < l.size(); i++) {
                Node curr = l.get(i);
                prev.setNext(curr);
                addChildren(q,prev);
                addChildren(q,curr);
                prev = curr;
            }
            prev.setNext(null);
        }
        tree.inOrderTraversal();
    }

    static void addChildren(Deque<Node> q, Node node) {
        if (node.getLeft() != null) {
            q.offer(node.getLeft());
        }
        if (node.getRight() != null) {
            q.offer(node.getRight());
        }
    }
}
