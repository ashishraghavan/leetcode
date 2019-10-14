package com.leetcode.easy.linkedlist;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 *
 * Given linked list -- head = [4,5,1,9], which looks like following:
 *
 * [4,1,9]
 */

//5->15->20->25->30->35->40->45->50->
//5->15->20->25->30->35->40->->50->
//40.next = 45
//45.next = 50
//45 = 45.next = 50
//delete(45);
public class DeleteANode extends LinkedListMiddle {
    public static void main(String[] args) {
        ListNode head = initializeList();
        ListNode printHead = head;
        //45
        while(head != null) {
            if(head.val == 45) {
                deleteNode(head);
                break;
            }
            head = head.next;
        }
        printListNodes(printHead);
    }

    //previous.next = node;
    //we have to delete node.
    //so that previous.next = node.next;
    //you cannot create a new node!!!!
    static void deleteNode(ListNode node) {
        //set current node to be the next node.
        node = node.next;
    }
}
