package com.algomonster.problems.bfs;

import com.algomonster.problems.Utilities;

import java.util.*;

//https://algo.monster/problems/binary_tree_right_side_view
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        String str = "1 2 4 8 x x 9 x x 5 10 x x x 3 6 x 11 x x 7 12 x x 13 x x";
        Collection<String> list = Arrays.asList(str.split("\\s"));
        //Collection<String> list = Arrays.asList("1","2","4","x","7","x","x","5","x","x","3","x","6","x","x");
        Node<Integer> root = Utilities.buildTreeBfs(list.iterator(),Integer::parseInt);
        System.out.println(binaryTreeRightSideView(root));
    }

    //[1],[2,3],[4,5,6],[7]
    //for each level, use queue(temp) to store nodes. At the end of for loop over current size
    //of queue(main), do queue(temp).getLast()
    //My solution
    public static List<Integer> binaryTreeRightSideView(Node<Integer> root) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<Node<Integer>> dq = new ArrayDeque<>();
        dq.offer(root);
        while(!dq.isEmpty()) {
            ArrayDeque<Integer> subDq = new ArrayDeque<>();
            int size = dq.size();
            for(int i=0;i<size;i++) {
                Node<Integer> elem = dq.poll();
                subDq.add(elem.val);
                if(elem.left != null) {
                    dq.add(elem.left);
                }
                if(elem.right != null) {
                    dq.add(elem.right);
                }
            }
            res.add(subDq.getLast());
        }
        return res;
    }

    //Solution from website - avoids using extra queue
    public static List<Integer> binaryTreeRightSideViewII(Node<Integer> root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        ArrayDeque<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root); // at least one element in the queue to kick start bfs

        while (queue.size() > 0) { // as long as there is element in the queue
            int n = queue.size(); // number of nodes in current level
            res.add(queue.peek().val); // only append the first node we encounter since it's the rightmost
            // dequeue each node in the current level
            for (int i = 0; i < n; i++) {
                Node<Integer> node = queue.pop();
                // add right child first so it'll pop out of the queue first
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
        }

        return res;
    }
}
