package com.algomonster.problems.twopointers_or_sliding_window;

import com.algomonster.problems.Utilities;

//TODO: good problem, definitely [revise], check https://algo.monster/problems/remove_nth_from_end for detailed explanation
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
        Node<Integer> res = removeNthFromEndII(Utilities.buildList(new Integer[]{1, 2, 3, 4}),3);
        while(res != null) {
            System.out.print(res.val+"->");
            res = res.next;
        }
    }


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

    //1->2->3->4->5->6 | 1
    //diff between fast & slow pointers need to be = n?
    //prev=head,slow=head
    //fast=head, cnt=0,while(fast != null && cnt++ <= n){fast=fast.next;}
    //optimized solution
    //1. add dummy node(to make it easy when we gotta delete the head node)
    //2. set slow, fast pointers to this dummy node. use counter, set to zero, move fast pointer one step at a time till counter < n
    //3. move fast & slow pointers - fast pointer one step at a time until fast.next != null i.e.
    // till fast reaches the last node, slow pointer one step at a time until it reaches the node just before the node we want to delete
    //4. set slow.next = slow.next.next to delete the required node
    //5. return dummy.next
    public static Node<Integer> removeNthFromEndII(Node<Integer> head, int n) {
        Node<Integer> dummy = new Node<>(Integer.MIN_VALUE,head);
        Node<Integer> fast = dummy,slow=dummy;
        int cnt = 0;
        while(cnt++ < n) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
