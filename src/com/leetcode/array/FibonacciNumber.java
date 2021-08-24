package com.leetcode.array;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(fib(12));
    }

    private static int fib(int N) {
        int num1 = 0;
        int num2 = 1;
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int[] sequence = new int[N];
        sequence[0] = num1;
        sequence[1] = num2;
        int i = 2;
        for (; i < N; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence[i - 1] + sequence[i - 2];
    }

}
