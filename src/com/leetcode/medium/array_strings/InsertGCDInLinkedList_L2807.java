package com.leetcode.medium.array_strings;

import com.leetcode.linkedlist.ListNode;

//prob #2807 - insert gcd in linked list
public class InsertGCDInLinkedList_L2807 {
    public static void main(String[] args) {
        //18,6,10,3
        ListNode head = new ListNode(18,new ListNode(6,new ListNode(10,new ListNode(3,null))));
        ListNode res = insertGreatestCommonDivisors(head);
        assert res != null;
        res.print();
    }

    //18,6,10,3
    //use gcd(n1,n2) to return gcd of 2 numbers using euler's theory
    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode root = head;
        while(root != null && root.next != null) {
            int n1 = root.val;
            int n2 = root.next.val;
            int gcd = gcd(n1,n2);
            ListNode temp = root.next;
            root.next = new ListNode(gcd);
            root.next.next = temp;
            root = temp;
        }
        return head;
    }

    //18,6 || 6,18
    //18%6 = 0 || 6%18 = 6
    public static int gcd(int n1,int n2) {
        if(n2 == 0)return n1;
        return gcd(n2,n1%n2);
    }
}
