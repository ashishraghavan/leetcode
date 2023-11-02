package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class PassByRefOrPassByValue {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        PassByTester tester = new PassByTester();
        tester.addToList(list,10);
        System.out.println("In Java, objects are pass-by-reference - "+list.toString());
        int result = 10;
        tester.updateResult(result,2);
        System.out.println("In Java, primitives are pass by value - "+result);
    }
}
