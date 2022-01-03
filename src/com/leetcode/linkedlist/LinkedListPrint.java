package com.leetcode.linkedlist;


//TODO : Incomplete!
public class LinkedListPrint {
    public static void main(String[] args) {
        //node = head
        ListNode node = LinkedListUtil.initializeList();
        ListNode head = swapPairsReturnHead(node);
        //print linkedlist
        StringBuilder builder = new StringBuilder();
        while(head != null) {
            builder.append(head.val).append("->");
            head = head.next;
        }
        System.out.println(builder.toString());
    }

    //1->2->3->4->5->
    static ListNode swapPairsReturnHead(ListNode head) {
        ListNode first = head;
        swapFirstPair(first,first.next);
        return first;
    }

    static void swapFirstPair(ListNode first,ListNode second) {
        ListNode temp = first;
        first.next = second.next;
        second.next = temp;
        first = second;
    }
}
