package com.leetcode.medium.fast_slow_pointers_linked_list;

//#234
public class PalindromeLinkedList {
    public static void main(String[] args) {
        //
        //[1,2,3,3,1,2]
        //10, 2, 10
        //1
        //1, 2
        //1, 1
        //1, 2, 3, 4, 1
        //1, 0, 0
        //1, 2, 3, 1
        ListNode head = LinkedListUtils.buildListWithCycle(new int[]{1, 2, 3},-1);
        System.out.println(isPalindromeCorrected(head));
    }

    //[1,2,3,3,1,2]
    public static boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int nodes = 0;
        while(temp != null) {
            temp = temp.next;
            nodes++;
        }
        ListNode first = head;
        int cnt = 0;
        while(cnt < nodes/2) {
            first = first.next;
            cnt++;
        }
        while(first.val == first.next.val) {
            first = first.next;
        }
        ListNode second = first.next;
        first = head;
        while(second != null) {
            if(second.val != first.val) {
                return false;
            }
            second = second.next;
            first = first.next;
        }
        return true;
    }

    public static boolean isPalindromeCorrected(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse starting from slow
        ListNode prev = null,temp;
        while(slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        ListNode head2 = prev;
        slow = head;
        while(head2 != null) {
            if(slow.val != head2.val)return false;
            slow = slow.next;
            head2 = head2.next;
        }
        return true;
    }
}
