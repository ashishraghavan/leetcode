package com.leetcode.linkedlist;

public class SinglyLinkedListReverseDryRun {

    public static void main(String[] args) {
        MySinglyLinkedList sll = new MySinglyLinkedList();
        sll.add(1);
        sll.add(2);
        sll.add(3);
        sll.add(4);
        sll.add(5);

        ListNode prev = null;
        ListNode curr = sll.getFirst();

        //code to reverse ll
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //printing reversed ll, prev will be the first node after reversing
        System.out.println("reversed ll");
        ListNode node = prev;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node= node.next;
        }
    }
}
