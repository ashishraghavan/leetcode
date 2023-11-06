package com.leetcode.practice;

import java.util.*;

public class ReverseLevelOrder {
    public static void main(String[] args) {
//        Map<Integer, BinaryTree.DIRECTION> map = new HashMap<>();
//        map.put(9, BinaryTree.DIRECTION.LEFT);
//        map.put(20, BinaryTree.DIRECTION.RIGHT);
//        map.put(15, BinaryTree.DIRECTION.LEFT);
//        map.put(7, BinaryTree.DIRECTION.RIGHT);
        //map.put(6, BinaryTree.DIRECTION.LEFT);
        //map.put(7, BinaryTree.DIRECTION.RIGHT);
        BinaryTree tree = BinaryTreeTester.createStaticBinaryTree();
        Deque<Node> q = new ArrayDeque<>();
        Stack<Node> st = new Stack<>();
        q.offer(tree.getRoot());
        while(!q.isEmpty()) {
            Node curr = q.poll();
            st.push(curr);
            if (curr.getRight() != null) {
                q.offer(curr.getRight());
            }
            if (curr.getLeft() != null) {
                q.offer(curr.getLeft());
            }
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop().getValue()+", ");
        }
    }
}
