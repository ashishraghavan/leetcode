package com.leetcode.linkedlist;

import com.leetcode.linkedlist.core.List;

import java.util.ListIterator;

/**
 * MEDIUM #2
 * https://leetcode.com/problems/add-two-numbers/
 * l1 = [2,4,3], l2 = [5,6,4,7,2]
 *
 * 2 -> 4 -> 3 == 342
 * 5 -> 6 -> 4 -> 7 -> 2 == 27465
 *
 * 7 -> 0 -> 8 -> 7 -> 2
 *
 * l1 = [9,9,9,9,9,9,9] == 9 -> 9 -> 9 -> 9 -> 9 -> 9 -> 9
 * l2 = [9,9,9,9]       == 9 -> 9 -> 9 -> 9
 *
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        List.SinglyLinkedList<Integer> l1 = new List.SinglyLinkedList<>();
        //l1.add(2);l1.add(4);l1.add(3);
        l1.add(9);l1.add(9);l1.add(9);

        List.SinglyLinkedList<Integer> l2 = new List.SinglyLinkedList<>();
        //l2.add(5);l2.add(6);l2.add(4);l2.add(7);l2.add(2);
        l2.add(9);l2.add(9);l2.add(9);

        List.SinglyLinkedList<Integer> l3 = new List.SinglyLinkedList<>();

        //no leading zeroes in either numbers, meaning there can't be a list like
        //!!!2 -> 4 -> 3 -> 0 -> 0 ==> 00342!!!

        //Check which one has a bigger length - O(n), where n is size of list
        //No need to check length. Just keep track of carry as maximum can be 19, so
        //maximum value of carry can only be 1.
        Integer carry = 0;
        ListIterator<Integer> itL1 = l1.toList().listIterator();
        ListIterator<Integer> itL2 = l2.toList().listIterator();
        while(itL1.hasNext() && itL2.hasNext()) {
            int curVal = itL1.next() + itL2.next() + carry;
            if(curVal > 9) {
                carry = 1;
                curVal = curVal % 10;
            } else {
                carry = 0;
            }
            l3.add(curVal);
        }
        ListIterator<Integer> itL3;
        if(itL1.hasNext()) {
            itL3 = itL1;
        } else if(itL2.hasNext()) {
            itL3 = itL2;
        } else {
            if(carry != 0) {
                l3.add(carry);
            }
            //we have finished adding everything,
            printResult(l3);
            return;
        }
        while(itL3.hasNext()) {
            int afterVal = itL3.next() + carry;
            if(afterVal > 9) {
                carry = 1;
                afterVal = afterVal % 10;
            } else {
                carry = 0;
            }
            l3.add(afterVal);
        }
        printResult(l3);
    }

    private static void printResult(List.SinglyLinkedList<Integer> result) {
        StringBuilder sb = new StringBuilder();
        for (Integer res : result.toList()) {
            sb.append(res).append("->");
        }
        System.out.println(sb.toString());
    }
}
