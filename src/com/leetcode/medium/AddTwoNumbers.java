package com.leetcode.medium;

import java.util.*;

public class AddTwoNumbers {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(9);
        List<Integer> integerList2 = Arrays.asList(1,9,9,9);
        LinkedList<Integer> l1 = new LinkedList<>(integerList);
        Iterator<Integer> l1Iterator = l1.iterator();

        LinkedList<Integer> l2 = new LinkedList<>(integerList2);
        Iterator<Integer> l2Iterator = l2.iterator();

        int l1Count = 0;
        while(l1Iterator.hasNext()) {
            l1Count++;
            l1Iterator.next();
        }

        int l2Count = 0;
        while(l2Iterator.hasNext()) {
            l2Count++;
            l2Iterator.next();
        }
        //Pad with zeroes for number with less digits.
        int zeroPadding = 0;
        if(l1Count < l2Count) {
            zeroPadding = l2Count - l1Count;
            for(int i =0;i<zeroPadding;i++) {
                l1.add(0);
            }
        } else if(l2Count < l1Count) {
            zeroPadding = l1Count - l2Count;
            for(int i =0;i<zeroPadding;i++) {
                l2.add(0);
            }
        }

        //Now, you can do either l1.hasNext() or l2.hasNext(), but we do an and operation because we are adding l2Iterator.next too.
        int carry = 0;
        //The result array list to be converted to a linked list when returning.
        List<Integer> reverseList = new ArrayList<>();
        l1Iterator = l1.iterator();
        l2Iterator = l2.iterator();
        while(l1Iterator.hasNext() && l2Iterator.hasNext()) {
            int result = carry + l1Iterator.next() + l2Iterator.next();
            if(result > 9) {
                //Get the first digit of result and assign it to carry whereas second digit will be added to the new linkedlist
                carry = String.valueOf(Math.abs((long)result)).charAt(0) - '0';
                Integer tensValue = result % 10;
                reverseList.add(tensValue);
            } else {
                carry = 0;
                reverseList.add(result);
            }
        }
        //If there is no carry after the last operation, it would take the carry from the previous op, which we don't want.
        if(carry > 0) {
            reverseList.add(carry);
        }
        //Add the carry finally if it is greater than 0
        //Reverse the digits
        Collections.reverse(reverseList);
        System.out.print(reverseList);
    }
}
