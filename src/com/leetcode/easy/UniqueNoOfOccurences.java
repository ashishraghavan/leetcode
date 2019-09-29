package com.leetcode.easy;

import java.util.*;

public class UniqueNoOfOccurences {
    public static void main(String[] args) {
        //1,2,2,1,1,3
        //1,2
        //-3,0,1,-3,1,1,1,-3,10,0
        System.out.println(uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    }

    @SuppressWarnings("ForLoopReplaceableByForEach")
    private static boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> numOccurenceMap = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            if(numOccurenceMap.containsKey(arr[i])) {
                numOccurenceMap.put(arr[i],numOccurenceMap.get(arr[i]) + 1);
            } else {
                numOccurenceMap.put(arr[i],1);
            }
        }
        Set<Integer> values = numOccurenceMap.keySet();
        Set<Integer> uniqueSet = new HashSet<>(values.size());
        for(Integer key : values) {
            if(uniqueSet.contains(numOccurenceMap.get(key))) {
                return false;
            } else {
                uniqueSet.add(numOccurenceMap.get(key));
            }
        }
        return true;
    }
}
