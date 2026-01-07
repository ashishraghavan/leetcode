package com.algomonster.problems.twopointers_or_sliding_window;

import com.leetcode.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumOfLinkedList {
    public static void main(String[] args) {
        //5->4->2->1
        //7->2->6->3->8->5
        //ListNode head = new ListNode(5,new ListNode(4,new ListNode(2,new ListNode(1,null))));
        ListNode head = new ListNode(7,new ListNode(2,new ListNode(6,new ListNode(3,new ListNode(8,new ListNode(5,null))))));
        System.out.println(pairSumII(head));
    }

    //5->4->2->1
    //int[] res = int[n/2], [0,n/2] -> [5,4]
    //[n,n/2] -> return max[6,6]
    //[4,2,2,3]

    //7->2->6->3->8->5
    //max(6+3,2+8,7+5)=max(9,10,12) = 12

    //5->4->2->1
    public static int pairSum(ListNode head) {
        int mx = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        ListNode fast = head,slow = head;
        while(fast !=null && fast.next != null) {
            res.add(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }

        int cnt = res.size()-1;
        while(slow != null && cnt >= 0) {
            int temp = res.get(cnt)+slow.val;
            res.set(cnt,temp);
            mx = Math.max(mx,temp);
            slow = slow.next;
            cnt--;
        }
        return mx;
    }

    //7->2->6->3->8->5
    public static int pairSumII(ListNode head) {
        ListNode fast = head,slow = head;
        int mx = Integer.MIN_VALUE;
        while(fast !=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head2 = reverse(slow);
        ListNode head1 = head;
        while(head2 != null) {
            mx = Math.max(mx,head2.val + head1.val);
            head2 = head2.next;
            head1 = head1.next;
        }
        return mx;
    }

    //3->8->5
    public static ListNode reverse(ListNode head) {
        ListNode prev = null,curr=head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
