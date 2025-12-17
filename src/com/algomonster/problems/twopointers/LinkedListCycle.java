package com.algomonster.problems.twopointers;

public class LinkedListCycle {
    public static void main(String[] args) {
        //6,5,4,-1,1,3,7,2,3,8
        Node<Integer> node1 = new Node<>(0);
        Node<Integer> node2 = new Node<>(1);
        Node<Integer> node3 = new Node<>(2);
        Node<Integer> node4 = new Node<>(3);
        Node<Integer> node5 = new Node<>(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        System.out.println(hasCycle(node1));
    }

    public static boolean hasCycle(Node<Integer> nodes) {
        Node<Integer> fast = nodes;
        Node<Integer> slow = nodes;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast != null && fast.equals(slow))return true;
        }
        return false;
    }
}
