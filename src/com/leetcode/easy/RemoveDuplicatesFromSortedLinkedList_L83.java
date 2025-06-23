package com.leetcode.easy;

import com.leetcode.linkedlist.ListNode;

//problem # 83 - remove duplicates from sorted list
public class RemoveDuplicatesFromSortedLinkedList_L83 {
    public static void main(String[] args) {
        //1->1->2->3->3
        ListNode head = new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(3,null)))));
        ListNode head2 = new ListNode(4,null);
        ListNode head3 = new ListNode(4,new ListNode(4,null));
        ListNode head4 = new ListNode(1,new ListNode(1,new ListNode(2,null)));
        ListNode head5 = new ListNode(1,new ListNode(9,null));
        ListNode head6 = new ListNode(1,new ListNode(9,new ListNode(7,null)));
        ListNode res = deleteDuplicates(head4);
        printLL(res);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null)return head;
        ListNode curr = head, next = head.next, temp;
        while(next != null) {
            if(next.val == curr.val) {
                temp = next;
                while(temp != null && temp.val == curr.val) {
                    temp = temp.next;
                }
                if(temp == null) {
                    curr.next = null;
                    return head;
                } else {
                    curr.next = temp;
                    next = temp;
                }
            }
            curr = next;
            next = curr.next;
        }
        return head;
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp);
            temp = temp.next;
        }
    }
}
