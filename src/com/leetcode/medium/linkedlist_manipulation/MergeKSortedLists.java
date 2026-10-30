package com.leetcode.medium.linkedlist_manipulation;

import com.leetcode.medium.fast_slow_pointers_linked_list.ListNode;
import com.leetcode.medium.fast_slow_pointers_linked_list.LinkedListUtils;

import java.util.Comparator;
import java.util.PriorityQueue;

//#23
public class MergeKSortedLists {
    public static void main(String[] args) {
        //new int[][]{{-10, -5, 0}, {-8, -3, 2}, {-1, 4}}
        //new int[][]{{1, 2, 3, 4, 5, 6, 7, 8}, {9}}
        //new int[][]{{10}, {5}, {1}, {8}, {3}}
        //new int[][]{{2, 2, 2}, {2, 2}, {2, 2, 2, 2}}
        //new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
        //new int[][]{{}, {1}, {}}
        //new int[][]{{}}
        ListNode l1 = LinkedListUtils.buildListWithCycle(new int[]{},-1);
//        ListNode l2 = LinkedListUtils.buildListWithCycle(new int[]{1},-1);
//        ListNode l3 = LinkedListUtils.buildListWithCycle(new int[]{},-1);
//        ListNode l4 = LinkedListUtils.buildListWithCycle(new int[]{8},-1);
//        ListNode l5 = LinkedListUtils.buildListWithCycle(new int[]{3},-1);
        ListNode[] list = new ListNode[]{l1};
        ListNode head = mergeKLists(list);
        if(head != null) {
            head.print();
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode origHead = null;
        ListNode prev = null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(ListNode::val));
        for(ListNode head : lists) {
            if(head != null) {
                pq.offer(head);
            }
        }
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            if(origHead == null) {
                origHead = node;
                if(node.next() != null) {
                    pq.offer(node.next());
                }
                origHead.setNext(null);
                prev = origHead;
            } else {
                if(node.next() != null) {
                    pq.offer(node.next());
                }
                node.setNext(null);
                prev.setNext(node);
                prev = node;
            }
        }
        return origHead;
    }
}
