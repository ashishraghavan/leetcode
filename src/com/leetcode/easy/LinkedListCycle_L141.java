package com.leetcode.easy;

import com.leetcode.linkedlist.ListNode;

import java.util.HashMap;
import java.util.Map;

//TODO: revise, shows usage of Floyd-Warshall algorithm to detect cycle in a single/doubly linkedlist
//problem # 141 - linked list cycle
//check https://github.com/doocs/leetcode/tree/main/solution/0100-0199/0141.Linked%20List%20Cycle for github solution
public class LinkedListCycle_L141 {
    public static void main(String[] args) {
        ListNode nodeZero = new ListNode(0);
        ListNode nodeTwo = new ListNode(2,nodeZero);
        ListNode last = new ListNode(-4,nodeTwo);
        nodeZero.next = last;
        ListNode head = new ListNode(3,nodeTwo);
        ListNode head2 = new ListNode(1,new ListNode(9,new ListNode(7,null)));
        System.out.println(hasCycleII(head2));
        //printLL(head);
    }

    //3	2	0	-4 - Use a Set to add ListNode as you iterate linked list. If for any element, set.add(element) returns false, return true
    //3	 2	0  3 -4 - Use a hashmap with key = ListNode, value = boolean (can be anything). Start iterating LL. If at any point, we find that current node is already present in hashmap, return true
    public static boolean hasCycle(ListNode head) {
        Map<ListNode,Boolean> map = new HashMap<>();
        ListNode curr = head;
        while(curr != null) {
            if(map.containsKey(curr))return true;
            map.put(curr,Boolean.TRUE);
            curr = curr.next;
        }
        return false;
    }

    //using fast & slow pointers (Floyd-Warshall algorithm)
    public static boolean hasCycleII(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast != null && fast.equals(slow))return true;
        }
        return false;
    }

    public static void printLL(ListNode head) {
        ListNode curr = head;
        int cnt = 0;
        while(curr != null) {
            if(cnt++ > 4)break;
            System.out.print(curr.val+"\t");
            curr = curr.next;
        }
    }
}
