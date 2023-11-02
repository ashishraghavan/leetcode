package com.leetcode.practice;

import java.util.List;

public class PassByTester {
    private List<Integer> intList;

    public PassByTester() {}

    public PassByTester(List<Integer> intList) {
        this.intList = intList;
    }

    public void addToList(List<Integer> list, Integer value) {
        list.add(value);
    }

    public void updateResult(int result, int value) {
        result += value;
        //return result;
    }
}
