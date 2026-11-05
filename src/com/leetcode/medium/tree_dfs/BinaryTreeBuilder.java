package com.leetcode.medium.tree_dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeBuilder {

    /**
     * Builds a binary tree from a level-order representation (LeetCode style).
     *
     * @param values List containing node values and nulls in level order.
     * @return The root node of the constructed binary tree.
     */
    public static TreeNode buildTree(List<Integer> values) {
        if (values == null || values.isEmpty() || values.get(0) == null) {
            return null;
        }

        TreeNode root = new TreeNode(values.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.size()) {
            TreeNode current = queue.poll();

            // Set left child
            if (i < values.size()) {
                Integer leftVal = values.get(i++);
                if (leftVal != null) {
                    current.left = new TreeNode(leftVal);
                    queue.offer(current.left);
                }
            }

            // Set right child
            if (i < values.size()) {
                Integer rightVal = values.get(i++);
                if (rightVal != null) {
                    current.right = new TreeNode(rightVal);
                    queue.offer(current.right);
                }
            }
        }

        return root;
    }

    // Helper method to verify the tree structure via in-order traversal
    public static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
    // Pre-order traversal: Root -> Left -> Right
    public static void printPreOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    // Post-order traversal: Left -> Right -> Root
    public static void printPostOrder(TreeNode node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.val + " ");
    }

    // Level-order traversal (BFS) using a Queue[cite: 2]
    public static void printLevelOrderTraversal(TreeNode node) {
        if (node == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        // Input matching the diagram: [3, 9, 20, null, null, 15, 7]
        List<Integer> input = Arrays.asList(3, 9, 20, null, null, 15, 7);

        TreeNode root = buildTree(input);

        // Verification
        System.out.println("Root: " + root.val);                                 // 3
        System.out.println("Left of 3: " + root.left.val);                      // 9
        System.out.println("Right of 3: " + root.right.val);                    // 20
        System.out.println("Left of 9: " + root.left.left);                     // null
        System.out.println("Right of 9: " + root.left.right);                   // null
        System.out.println("Left of 20: " + root.right.left.val);               // 15
        System.out.println("Right of 20: " + root.right.right.val);             // 7

        System.out.print("In-order traversal: ");
        printInOrder(root); // Expected: 9 3 15 20 7
        System.out.println();
    }
}
