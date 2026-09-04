package com.leetcode.medium.fast_slow_pointers_linked_list;


//#142
public class LinkedListCycle_II {
    public static void main(String[] args) {
        //[3,2,0,-4],1
        //[1, 2],-1
        //[1, 2],0
        //1, 2, 3, 4, 5, 6|4
        //1, 2, 3, 4, 5, 6, 7|1
        //1, 2, 3, 4|3
        //2, 2, 2, 2|1
        ListNode head = LinkedListUtils.buildListWithCycle(new int[]{1},-1);
        ListNode result = detectCycleIII(head);
        if(result != null) {
            System.out.println(result.val);
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null)return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)break;
        }
        if(slow != fast)return null;
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static ListNode detectCycleII(ListNode head) {
        if(head == null || head.next==null)return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)break;
        }
        if(fast == null || fast.next == null){
            return null;
        }
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static ListNode detectCycleIII(ListNode head) {
        if(head == null || head.next == null)return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                slow = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
