package com.leetcode.medium.fast_slow_pointers_linked_list;

//#160
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        //[4,1,8,4,5]
        ListNode headA = LinkedListUtils.buildListWithCycle(new int[]{4,1,8,4,5},-1);
        //[5,6,1,8,4,5]
        ListNode headB = LinkedListUtils.buildListWithCycle(new int[]{5,6,1,8,4,5},-1);
        ListNode result = getIntersectionNode(headA,headB);
        if(result != null) {
            System.out.println(result.val);
        }
    }

    //[4,1,8,4,5]
    //[5,6,1,8,4,5]
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB) {
            if(pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            if(pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
}
