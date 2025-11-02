package com.leetcode.medium.array_strings;

import com.leetcode.linkedlist.ListNode;

//TODO: can be optimized for space!, come back later
//prob #2181 - merge nodes in between zeroes
public class MergeNodesInBetweenZeroes_L2181 {
    public static void main(String[] args) {
        //0,3,1,0,4,5,2,0
        //0,1,0,3,0,2,2,0
        ListNode head = new ListNode(0,new ListNode(3,new ListNode(1,new ListNode(0,new ListNode(4,new ListNode(5,new ListNode(2,new ListNode(0))))))));
        ListNode res = mergeNodes(head);
        assert res != null;
        //System.out.println();
    }

    //0,3,1,0,4,5,2,0
    public static ListNode mergeNodes(ListNode head) {
        return buildLinkedList(head.next);
    }

    //0,3,1,0,4,5,2,0 => [4,11]
    public static ListNode buildLinkedList(ListNode head) {
        int sum = 0;
        ListNode newHead = null;
        ListNode prev = null;
        while(head != null) {
            if(head.val == 0) {
                ListNode currNode = new ListNode(sum);
                if(prev==null) {
                    newHead = currNode;
                    prev = currNode;
                } else {
                    prev.next = currNode;
                    prev = currNode;
                }
                sum=0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return newHead;
    }
}
