package com.leetcode.medium.fast_slow_pointers_linked_list;

//#876
public class MiddleOfLinkedList {
    public static void main(String[] args) {
        //1, 2, 3, 4, 5
        //1, 2, 3, 4, 5, 6
        //1,2
        //1
        ListNode head = LinkedListUtils.buildListWithCycle(new int[]{1},-1);
        ListNode result = middleNodeUpdated(head);
        result.print();
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return fast == null ? slow : slow.next;
    }

    public static ListNode middleNodeUpdated(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
