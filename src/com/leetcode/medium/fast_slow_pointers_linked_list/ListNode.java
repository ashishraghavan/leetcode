package com.leetcode.medium.fast_slow_pointers_linked_list;

import java.util.HashSet;
import java.util.Set;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public void print() {
        Set<ListNode> visited = new HashSet<>();
        ListNode curr = this;

        while (curr != null) {
            if (visited.contains(curr)) {
                System.out.print(curr.val + " -> (cycle back to " + curr.val + ")");
                System.out.println();
                return;
            }

            visited.add(curr);
            System.out.print(curr.val);

            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }

        System.out.println(" -> null");
    }
}
