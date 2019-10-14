package com.leetcode.easy.linkedlist;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 */
public class ReverseLinkedListIterative extends LinkedListMiddle {
    public static void main(String[] args) {
        ListNode head = initializeListByArray(new int[]{1,2,3,4,9,21,23,45,210,510,20});
        ListNode reversedHead = reverseListIterative(head);
        StringBuilder builder = new StringBuilder();
        while(reversedHead != null) {
            builder.append(reversedHead.val).append("->");
            reversedHead = reversedHead.next;
        }
        System.out.println(builder.toString());
    }

    //to reverse
    //5->15->20->25->30->35->40->45->50->
    //To be modified to
    // 5<--15<--20<--25<--30<--35<--40<--45<--50
    static ListNode reverseListIterative(ListNode head) {
        //Get the next element in the linked list
        //if it is null, we have reached the end
        //and this will be the first element now.
        ListNode previous = null;
        ListNode current;
        ListNode next;
        while(head != null) {
            current = head;
            next = current.next;
            current.next = previous;
            previous = current;
            head = next;
        }
        return previous;
    }
}
