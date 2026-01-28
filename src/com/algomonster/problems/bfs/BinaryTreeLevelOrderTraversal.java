package com.algomonster.problems.bfs;

import com.algomonster.problems.Utilities;

import java.util.*;

//from https://algo.monster/problems/binary_tree_level_order_traversal
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Collection<String> list = Arrays.asList("1","2","4","x","7","x","x","5","x","x","3","x","6","x","x");
        Node<Integer> root = Utilities.buildTreeBfs(list.iterator(),Integer::parseInt);
        System.out.println(levelOrderTraversal(root));
    }

    public static List<List<Integer>> levelOrderTraversal(Node<Integer> root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Node<Integer>> dq = new ArrayDeque<>();
        dq.offer(root);
        while(!dq.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int size = dq.size(),k=0;
            while(k < size) {
                Node<Integer> node = dq.poll();
                subList.add(node.val);
                if(node.left != null) {
                    dq.offer(node.left);
                }
                if(node.right != null) {
                    dq.offer(node.right);
                }
                k++;
            }
            list.add(subList);
        }
        return list;
    }
}
