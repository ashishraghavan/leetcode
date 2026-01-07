package com.algomonster.problems.twopointers_or_sliding_window;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        //0 1 2 3 4 5
        //0 1 2 3 4
        //new Node<>(5,null)
        //Node<Integer> head = new Node<>(0,new Node<>(1,new Node<>(2,new Node<>(3,new Node<>(4,null)))));
        //[1,3,5,7,9,11,13,15,17,19,21]
        //[7,14,21,28,35,42,49,56,63,70,77,84]
        //[11,22,33,44,55,66,77,88,99]
        //1,2
        System.out.println(middleOfLinkedList(buildList(new Integer[]{1})));
    }

    public static class Node<T> {
        public T val;
        public Node<T> next;

        public Node(T val) {
            this(val, null);
        }

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    public static int middleOfLinkedList(Node<Integer> head) {
        if(head == null)return -1;
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow != null ? slow.val : -1;
    }

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
