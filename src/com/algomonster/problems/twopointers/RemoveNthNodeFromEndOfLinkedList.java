package com.algomonster.problems.twopointers;

public class RemoveNthNodeFromEndOfLinkedList {
    public static void main(String[] args) {
        //1,2,3,4 | 4
        //1,2,3,4 | 1
        //1,2,3,4 | 2
        //1,2,3,4,5 | 3
        //[1, 2, 3, 4, 5, 6, 7] | 4
        //[10, 20, 30, 40, 50]
        //[0, 0, 0, 0] | 2
        //[1, 2, 3, 4, 5, 6] | 1
        Node<Integer> res = removeNthFromEnd(Utilities.buildList(new Integer[]{1, 2, 3, 4, 5, 6}),1);
        while(res != null) {
            System.out.print(res.val+"->");
            res = res.next;
        }
    }

    //1->2->3->4
    //diff between fast & slow pointers need to be = n?
    //prev=head,slow=head
    //fast=head, cnt=0,while(fast != null && cnt++ <= n){fast=fast.next;}
    //fast=3,slow=1 while(fast != null) {prev=slow,slow=slow.next;fast=fast.next}

    //10, 20, 30, 40, 50 | 5
    //non-optimized solution with passing test-cases
    public static Node<Integer> removeNthFromEnd(Node<Integer> head, int n) {
        int nodes = 0,diff;
        Node<Integer> node = head,prev=head,curr=head;
        while(node != null) {
            nodes++;
            node = node.next;
        }
        System.out.println("node count = "+nodes);
        diff = nodes - n;
        nodes=0;
        while(nodes < diff) {
            prev = curr;
            curr = curr.next;
            nodes++;
        }
        if(curr == null) {
            prev.next = null;
        } else {
            prev.next = curr.next;
        }
        if(diff == 0) {
            head = head.next;
        }
        return head;
    }
}
