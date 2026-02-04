package com.algomonster.problems.bfs;

import com.algomonster.problems.Utilities;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;

//https://algo.monster/problems/binary_tree_min_depth
public class BinaryTreeMinimumDepth {
    public static void main(String[] args) {
        //Collection<String> list = Arrays.asList("1","2","4","x","7","x","x","5","x","8","x","x","3","x","6","x","x");
        //[1,2,3,4,5,6,7,8,9,10]
        //Collection<String> list = Arrays.asList("1","2","x","x","3","x","x");
        Collection<String> list = Arrays.asList("1","2","3","x","x","4","x","x","5","x","x");
        Node<Integer> root = Utilities.buildTreeBfs(list.iterator(),Integer::parseInt);
        System.out.println(binaryTreeMinDepth(root));
    }

    //do bfs, for each level - increment height(ht),
    //return ht when you encounter first node where left & right child = null
    public static int binaryTreeMinDepth(Node<Integer> root) {
        ArrayDeque<Node<Integer>> q = new ArrayDeque<>();
        q.offer(root);
        int ht = -1;
        while(!q.isEmpty()) {
            ht++;
            int size = q.size();
            for(int i=0;i<size;i++) {
                Node<Integer> node = q.pop();
                if(node.left == null && node.right == null) {
                    return ht;
                }
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return ht;
    }
}
