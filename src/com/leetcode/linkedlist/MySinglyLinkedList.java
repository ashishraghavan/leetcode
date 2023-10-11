package com.leetcode.linkedlist;

public class MySinglyLinkedList {
    private ListNode first = null;
    private ListNode last = null;

    MySinglyLinkedList() {}

    public ListNode getFirst() {
        return this.first;
    }

    /*
        *
        * void linkLast(E e) {
            final Node<E> l = last;
            final Node<E> newNode = new Node<>(l, e, null);
            last = newNode;
            if (l == null)
                first = newNode;
            else
                l.next = newNode;
            size++;
            modCount++;
        }*/
    public void add(int value) {
        if (this.first == null) {
            this.first = new ListNode(value,null);
            this.last = this.first;
        } else {
            ListNode tempLast = this.last;
            this.last = new ListNode(value, null);
            tempLast.next = this.last;
        }
    }

    public void print() {
        if (this.first == null) {
            System.out.println("empty list");
            return;
        }
        ListNode node = this.first;
        while(node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }
}
