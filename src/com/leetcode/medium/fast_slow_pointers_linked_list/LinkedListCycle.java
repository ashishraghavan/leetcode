package com.leetcode.medium.fast_slow_pointers_linked_list;

//#141
public class LinkedListCycle {
    public static void main(String[] args) {
        System.out.println(hasCycleII(LinkedListUtils.buildListWithCycle(new int[]{1, 1, 1, 1},-1)));
    }

    //[1, 2, 3, 4], 3
    public static boolean hasCycle(ListNode head) {
        if(head == null)return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next==null)return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static boolean hasCycleII(ListNode head) {
        if(head == null)return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)return true;
        }
        return false;
    }
}
