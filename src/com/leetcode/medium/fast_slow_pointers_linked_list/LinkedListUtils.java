package com.leetcode.medium.fast_slow_pointers_linked_list;

//built using gemini here - https://share.gemini.google/gy3xYBNFhSd8
public class LinkedListUtils {

    /**
     * Builds a linked list from an array and creates a cycle if pos != -1.
     *
     * @param arr The array of integers to convert into a linked list.
     * @param pos The zero-based index where the tail should connect.
     * @return The head of the newly created linked list.
     */
    public static ListNode buildListWithCycle(int[] arr, int pos) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        ListNode cycleNode = (pos == 0) ? head : null;

        // Build the list and track the node at the target position
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;

            if (i == pos) {
                cycleNode = current;
            }
        }

        // If a valid position was provided, connect the tail to create a cycle
        if (pos >= 0 && cycleNode != null) {
            current.next = cycleNode;
        }

        return head;
    }

    public static void main(String[] args) {
        // Example: Array [3, 2, 0, -4], cycle at index 1 (value 2)
        int[] arr = {3, 2, 0, -4};
        int pos = 1;

        ListNode head = buildListWithCycle(arr, pos);

        // Verification (Prints nodes up to the cycle point + 1 to prove loop)
        ListNode temp = head;
        for (int i = 0; i <= arr.length; i++) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("... (cycle continues)");
    }
}
