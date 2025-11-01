package com.leetcode.medium.array_strings;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//TODO: incorrect solution, runs in O(NlogN) time
//prob #128 - longest consecutive sequence
public class LongestConsecutiveSequence_L128 {
    public static void main(String[] args) {
        //0,3,7,2,5,8,4,6,0,1
        //100,4,200,1,3,2
        //3,7,5,2,2,0,6,6,6,1,4,5,4
        //3,7,5,2,2,0,6,6,6,1,5
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    ////solution #1
    //0,3,7,2,5,8,4,6,0,1
    //insert all elements into max heap priority queue -> 0,0,1,2,3,4,5,6,7,8
    //for(elem in nums) curr=elem, prev = q.peek(), if
    //set curr = q.poll()
    //while q!= empty() -> prev = q.poll(), if abs(prev-curr) = 1, cnt++;
    //TreeSet - add all elements in nums
    //3,7,5,2,2,0,6,6,6,1,4,5,4 -> 0,1,2,2,3,4,4,5,5,6,6,6,7
    public static int longestConsecutive(int[] nums) {
        if(nums.length <= 1)return 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int num : nums) {
            treeSet.add(num);
        }
        Integer prev = treeSet.pollFirst();
        int cnt = 1;
        int maxCnt = 0;
        while(!treeSet.isEmpty()) {
            Integer curr = treeSet.pollFirst();
            if(curr != null) {
                if(curr == prev)continue;
                if(curr == prev + 1)cnt++;
                else cnt = 1;
            }
            maxCnt = Math.max(maxCnt,cnt);
            prev = curr;
        }
        //System.out.println(maxCnt);
        return maxCnt == 1 ? 0 : maxCnt;
    }

    //100,4,200,1,3,2
    public static int longestConsecutiveII(int[] nums) {
        if(nums.length <= 1) {
            return nums.length == 0 ? 0 : 1;
        }
        Map<Integer,Boolean> mp = new HashMap<>();
        int cnt = 1;
        int maxCnt = 1;
        for(int num : nums) {
            if(mp.containsKey(num-1))cnt++;
            else {
                mp.put(num,true);
                cnt = 1;
            }
            maxCnt = Math.max(maxCnt,cnt);
        }
        return maxCnt;
    }
}
