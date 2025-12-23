package com.algomonster.problems.depthfirstsearch;

import com.algomonster.problems.Utilities;

import java.util.Arrays;
import java.util.Collection;

//my solution
public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Collection<String> list1 = Arrays.asList("3","4","1","x","x","2","x","x","5","x","x");
        Collection<String> list2 = Arrays.asList("4","1","x","x","2","x","x");
        //Collection<String> list1 = Arrays.asList("1","2","4","x","7","x","x","5","x","x","3","x","6","x","x");
        //Collection<String> list2 = Arrays.asList("3","2","x","x","6","x","x");
        Node<Integer> root = Utilities.buildTree(list1.iterator(),Integer::parseInt);
        Node<Integer> subroot = Utilities.buildTree(list2.iterator(),Integer::parseInt);
        System.out.println(subtreeOfAnotherTree(root,subroot));
    }

    //in-order - "14235", "142"
    public static boolean subtreeOfAnotherTree(Node<Integer> root, Node<Integer> subRoot) {
        StringBuilder rootPrOrd = new StringBuilder();
        StringBuilder subRootPrOrd = new StringBuilder();
        dfs(root,rootPrOrd);
        System.out.println(rootPrOrd);
        dfs(subRoot,subRootPrOrd);
        System.out.println(subRootPrOrd);
        return (!rootPrOrd.isEmpty() && !subRootPrOrd.isEmpty()) && rootPrOrd.toString().contains(subRootPrOrd.toString());
    }

    public static void dfs(Node<Integer> node,StringBuilder sb) {
        if(node == null)return;
        dfs(node.left,sb);
        sb.append(node.val);
        dfs(node.right,sb);
    }
}
