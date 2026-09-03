package com.leetcode.medium.montonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//#739
public class DailyTemperatures {
    public static void main(String[] args) {
        //73,74,75,71,69,72,76,73
        //30,40,50,60
        //30,60,90
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,60,90})));
    }

    //if(t[i] > t[stk.peek()]) {
    //int idx = stk.pop();
    //t[idx] = i-idx;
    //73,74,75,71,69,72,76,73
    public static int[] dailyTemperatures(int[] t) {
        Deque<Integer> stk = new ArrayDeque<>();
        int[] result = new int[t.length];
        for(int i=0;i<t.length;i++) {
            while(!stk.isEmpty() && t[i] > t[stk.peek()]) {
                int prevIdx = stk.poll();
                result[prevIdx] = i - prevIdx;
            }
            stk.push(i);
        }
        return result;
    }

    public static int[] dailyTemperaturesUpdated(int[] t) {
        int[] result = new int[t.length];
        // Using ArrayDeque is faster than Java's legacy Stack class
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < t.length; i++) {
            while (!stack.isEmpty() && t[i] > t[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return result;
    }
}
