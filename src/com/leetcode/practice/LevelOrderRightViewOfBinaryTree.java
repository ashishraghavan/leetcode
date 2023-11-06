package com.leetcode.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LevelOrderRightViewOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = BinaryTreeTester.createBinaryTree();
        Deque<Node> q = new ArrayDeque<>();
        List<Node> l = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        q.offer(tree.getRoot());
        while(!q.isEmpty()) {
            l.clear();
            while(q.peekFirst() != null) {
                l.add(q.pop());
            }
            res.add(l.get(l.size()-1).getValue());
            for(Node node : l) {
                if (node.getLeft() != null) {
                    q.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    q.offer(node.getRight());
                }
            }
        }
        System.out.println(res);
    }
}
