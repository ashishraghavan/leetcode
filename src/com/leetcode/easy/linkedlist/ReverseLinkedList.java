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

        return null;
    }
}
