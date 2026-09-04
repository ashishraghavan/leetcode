package com.leetcode.medium.fast_slow_pointers_linked_list;

//#19
public class RemoveNthNodeFromEndOfLinkedList {
    public static void main(String[] args) {
        //1,2,3,4,5|2
        //1|1
        //1,2|1
        //1,2|2
        //1, 2, 3, 4, 5|5
        //1, 2, 3, 4, 5|1
        //1,2,3|2
        //1, 1, 1, 1|2
        //1, 2, 3, 4|3
        //1, 2, 3, 4|2
        ListNode head = LinkedListUtils.buildListWithCycle(new int[]{1, 2, 3, 4, 5},-1);
        int n = 5;
        ListNode result = removeNthFromEndCorrected(head,n);
        result.print();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int cnt = 0;
        while(cnt < n) {
            fast = fast.next;
            cnt++;
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if(slow==head) {
            head = slow.next;
        } else {
            slow.next = slow.next.next;
        }
        return head;
    }

    public static ListNode removeNthFromEndCorrected(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Advance fast pointer n + 1 steps to create an exact gap
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Slide both pointers until fast reaches beyond the last node
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow is now parked right before the node to be removed
        slow.next = slow.next.next;

        return dummy.next;
    }
}
