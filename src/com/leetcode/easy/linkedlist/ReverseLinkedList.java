package com.leetcode.easy.linkedlist;

public class ReverseLinkedList extends LinkedListMiddle {
    public static void main(String[] args) {
        //reverseList(
        ListNode head = reverseList(initializeList());
        StringBuilder builder = new StringBuilder();
        while(head != null) {
            builder.append(head.val).append("->");
            head = head.next;
        }
        System.out.println(builder.toString());
    }

    //to reverse
    //5->15->20->25->30->35->40->45->50->
    //To be modified to
    // 5<--15<--20<--25<--30<--35<--40<--45<--50
    static ListNode reverseList(ListNode head) {
        //Get the next element in the linked list
        //if it is null, we have reached the end
        //and this will be the first element now.
        ListNode reversedHead = head;
        ListNode currentNode = head; //previous to current node.
        ListNode temp = head;
        //If we reach here, we have reached the end of
        //the linked list.
        // 5 15 20
        //Before saying current.next = null, save the current and current.next
        //temp will move forward
        /*
        *
        * while
        * ListNode temp = head; //5
        *  ListNode tempNext = temp.next; //15
        *  ListNode current = head.next; //15
        *  current.next = temp; 15 -> 5
        *
        * */
        //set head.next = null before returning
        return temp;
    }
}
