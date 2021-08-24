package com.leetcode.linkedlist;

public class MergeTwoSortedLists extends LinkedListMiddle {
    public static void main(String[] args) {
        ListNode l1 = initializeListByArray(new int[]{1,2,5});
        ListNode l2 = initializeListByArray(new int[]{1,3,4});
        ListNode mergedHead = mergeTwoLists(l1,l2);
        StringBuilder listBuilder = new StringBuilder();
        while(mergedHead != null) {
            listBuilder.append(mergedHead.val).append("->");
            mergedHead = mergedHead.next;
        }
        System.out.println(listBuilder);
    }


    //1->2->5->
    //1->3->4->
    //1->1->2->3->4->5->
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode originalL1 = l1;
        while(l1!= null &&
                l2 != null) {
            //Don't assign l1 = something or l2 = something
            //until all operations are over
            if(l1.val <= l2.val) {
                //create new node
                ListNode element = new ListNode(l2.val);
                //before assigning l1.next to be the new node
                //save the next node for l1
                ListNode nextL1 = l1.next;
                l1.next = element;
                element.next = nextL1;
                //Proceed to the next node.
                l1 = nextL1;
                l2 = l2.next;
            }  else {
                //l1.val > l2.val
                //->l2.val->l1.val->
                //In place of l1, we need to set l2.
                //SAVE l1 | temp = [5] -> null
                ListNode temp = l1;
                ListNode element = new ListNode(l2.val);

            }
        }
        //If any of l1 or l2 is null.
        //we copy all remaining elements from the list which is left
        /*if(l1.next == null) {
            l1.next = l2;
        } else {
            l2.next = l1;
        }*/
        return originalL1;
    }
}
