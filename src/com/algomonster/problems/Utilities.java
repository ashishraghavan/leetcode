package com.algomonster.problems;

import com.algomonster.problems.twopointers.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Function;

public class Utilities {
    public static <T> Node<T> buildList(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null; // empty list
        }

        Node<T> head = new Node<>(arr[0]);
        Node<T> current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new Node<>(arr[i]);
            current = current.next;
        }

        return head;
    }

    public static <T> com.algomonster.problems.depthfirstsearch.Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        if (val.equals("x")) return null;
        com.algomonster.problems.depthfirstsearch.Node<T> left = buildTree(iter, f);
        com.algomonster.problems.depthfirstsearch.Node<T> right = buildTree(iter, f);
        return new com.algomonster.problems.depthfirstsearch.Node<T>(f.apply(val), left, right);
    }

    public static <T> com.algomonster.problems.backtracking.Node<T> buildTreeBT(Iterator<String> iter, Function<String, T> f) {
        String val = iter.next();
        int num = Integer.parseInt(iter.next());
        ArrayList<com.algomonster.problems.backtracking.Node<T>> children = new ArrayList<>();
        for (int i = 0; i < num; i++)
            children.add(buildTreeBT(iter, f));
        return new com.algomonster.problems.backtracking.Node<T>(f.apply(val), children);
    }
}
