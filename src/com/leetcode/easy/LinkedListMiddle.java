package com.leetcode.easy;


/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
public class LinkedListMiddle {
    public static void main(String[] args) {
        ListNode headNode = new ListNode(5);
        ListNode node2 = new ListNode(15);
        headNode.next = node2;
        ListNode node3 = new ListNode(20);
        node2.next = node3;
        ListNode node4 = new ListNode(25);
        node3.next = node4;
        ListNode node5 = new ListNode(30);
        node4.next = node5;
        ListNode node6 = new ListNode(35);
        node5.next = node6;
        ListNode node7 = new ListNode(40);
        node6.next = node7;
        ListNode node8 = new ListNode(45);
        node7.next = node8;
        ListNode node9 = new ListNode(50);
        node8.next = node9;
        node9.next = null;
        printListNodes(headNode);
        System.out.println(middleNode(headNode).val);
    }

    @SuppressWarnings("unused")
    static ListNode searchNode(ListNode head,int value) {
        int count = 0;
        while(head != null) {
            count++;
            if(head.val == value) {
                System.out.println("Search position : "+count);
                return head;
            }
            head = head.next;
        }
        return null;
    }

    static void printListNodes(ListNode head) {
        StringBuilder listBuildeer = new StringBuilder();
        listBuildeer.append(head.val).append("->");
        head = head.next;
        while(head != null) {
            listBuildeer.append(head.val);
            head = head.next;
            listBuildeer.append("->");
        }
        System.out.println(listBuildeer.toString());
    }

    //if size of linkedlist is even, there will be two middle nodes
    //if size of linkedlist is odd, there will only be one middle node.
    //[1,2,3,4,5,6] middleNode = 3, middleNode + 1 = 4
    static ListNode middleNode(ListNode head) {
        //calculating the size
        int count = 0;
        ListNode middleNode = head;
        while(head != null){
            count++;
            head = head.next;
        }
        int listCount = 0;
        while(listCount < count/2) {
            middleNode = middleNode.next;
            listCount++;
        }
        return middleNode;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
