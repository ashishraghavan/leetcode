package com.leetcode.linkedlist;

import java.util.Objects;

/**
 * Class definition provided by leetcode
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public int val() {
        return this.val;
    }

    public ListNode next() {
        return this.next;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + Objects.hashCode(next);
        return result;
    }

    @Override
    public String toString() {
        return val+ " -> ";
    }

    public void print() {
        ListNode curr = this;
        StringBuilder sb = new StringBuilder();
        while(curr != null) {
            if(!sb.isEmpty()) {
                sb.append("->");
            }
            sb.append(curr.val);
            curr = curr.next;
        }
        System.out.println(sb);
    }
}
