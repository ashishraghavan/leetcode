package com.leetcode.linkedlist;

public class LinkedListUtil {

    //values : 1,2,3,4,5
    //values : 5,15,20,25,30
    public static ListNode initializeList() {
        ListNode headNode = new ListNode(1);
        ListNode node2 = new ListNode(2);
        headNode.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node5.next = null;
        return headNode;
    }
}
