package com.algomonster.problems.bfs;

import com.algomonster.problems.Utilities;

import java.util.*;

//https://algo.monster/problems/binary_tree_zig_zag_traversal
public class BinaryTreeZigZagLevelOrderTraversal {
    public static void main(String[] args) {
        //1 2 4 8 x x 9 x x 5 10 x x x 3 6 x 11 x x 7 12 x x 13 x x
        String str = "1 2 4 8 x x 9 x x 5 10 x x x 3 6 x 11 x x 7 12 x x 13 x x";
        String updStr = String.join(",",str.split("\\s"));
        //Collection<String> list = Arrays.asList("1","2","4","x","7","x","x","5","x","8","x","x","3","x","6","x","x");
        Collection<String> list = Arrays.asList(str.split("\\s"));
        Node<Integer> root = Utilities.buildTreeBfs(list.iterator(),Integer::parseInt);
        System.out.println(zigZagTraversalII(root));
    }


    //My solution uses Collections.reverse()
    public static List<List<Integer>> zigZagTraversal(Node<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Node<Integer>> q = new ArrayDeque<>();
        boolean reverse = false;
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>(size);
            for(int i=0;i<size;i++) {
                Node<Integer> elem = q.poll();
                list.add(elem.val);
                if(elem.left != null) {
                    q.offer(elem.left);
                }
                if(elem.right != null) {
                    q.offer(elem.right);
                }
            }
            if(reverse) {
                Collections.reverse(list);
            }
            res.add(list);
            reverse = !reverse;
        }
        return res;
    }

    //Solution from link - uses another queue & adds elements to the front
    public static List<List<Integer>> zigZagTraversalII(Node<Integer> root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root); // at least one element in the queue to kick start bfs
        boolean leftToRight = true;
        while (queue.size() > 0) { // as long as there is element in the queue
            int n = queue.size(); // number of nodes in current level, see explanation above
            ArrayDeque<Integer> newLevel = new ArrayDeque<>();
            // dequeue each node in the current level
            for (int i = 0; i < n; i++) {
                Node<Integer> node = queue.pop();
                if (leftToRight) {
                    newLevel.add(node.val);
                } else { // in reverse order
                    newLevel.addFirst(node.val);
                }
                // enqueue non-null children
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(Arrays.asList(newLevel.toArray(new Integer[0])));
            leftToRight = !leftToRight; // flip flag
        }
        return res;
    }
}
