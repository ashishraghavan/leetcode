package com.leetcode.medium.greedy_scheduling_and_sorting;

import java.util.Arrays;

//#621
//refer https://www.youtube.com/watch?v=QDsFBLGL9MM ---> explains greedy solution very clearly!!
public class TaskScheduler {
    public static void main(String[] args) {
        //'A','A','A','B','B','B'|2
        //'A','C','A','B','D','B'|1
        //'A','A','A','B','B','B'|3
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'},3));
    }

    //'A','A','A','B','B','B'   n=2
    //A=3,B=3
    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int spaces = maxFreq-1;
        int idleSlots = spaces * n;

        for(int i=24;i>=0 && freq[i] > 0;i--) {
            idleSlots -= Math.min(freq[i],spaces);
        }

        if(idleSlots > 0) {
            return tasks.length + idleSlots;
        }
        return tasks.length;
    }
}
