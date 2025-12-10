package com.algomonster.problems.twopointers;

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
}
