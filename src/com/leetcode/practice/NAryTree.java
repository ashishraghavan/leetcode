package com.leetcode.practice;

import java.util.List;
import java.util.TreeSet;

public class NAryTree {
    public static void main(String[] args) {
        createTree(3,new int[]{4,7,9,0,8,11,1,5});
        traverseTree();
    }

    static void createTree(int n,int[] elements) {

    }

    static void traverseTree() {

    }

    class Node {
        int val;
        List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
