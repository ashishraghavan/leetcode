package com.leetcode.medium.montonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

//#901
public class OnlineStockSpan {
    public static void main(String[] args) {
        //100,80,60,70,60,75,85
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }

    static class StockSpanner {
        Deque<int[]> stack;
        public StockSpanner() {
            stack = new ArrayDeque<>();
        }

        public int next(int price) {
            int span = 1;
            while(!stack.isEmpty() && price > stack.peek()[0]) {
                span += stack.pop()[1];
            }
            stack.push(new int[]{price,span});
            return span;
        }
    }
}
