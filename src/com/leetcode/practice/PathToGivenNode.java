package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * solution to https://www.interviewbit.com/old/problems/path-to-given-node/
 */
public class PathToGivenNode {
    public static void main(String[] args) {
        //create bin tree - 1,2,3,4,5,6
        Node root = BinaryTreeTester.createBinaryTree();
        List<Integer> path = new ArrayList<>();
        findPath(root,path,6);
        System.out.println(path.toString());
    }

    static boolean findPath(Node node, List<Integer> path, int searchValue) {
        if (node.getValue() == searchValue) {
            path.add(node.getValue());
            return true;
        } else if (node.getRight() == null && node.getLeft() == null) {
            return false;
        } else if (node.getRight() == null) {
            path.add(node.getValue());
            return findPath(node.getLeft(),path,searchValue);
        } else if (node.getLeft() == null) {
            path.add(node.getValue());
            return findPath(node.getRight(),path,searchValue);
        } else {
            path.add(node.getValue());
            boolean isInLeft = findPath(node.getLeft(),path,searchValue);
            boolean isInRight = findPath(node.getRight(),path,searchValue);
            if (!isInLeft && !isInRight) {
                path.remove(path.size()-1);
                return false;
            }
            return true;
        }
    }
}
