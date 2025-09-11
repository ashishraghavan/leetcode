package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

//prob #2900 - longest unequal adjacent groups subsequence I
public class LongestUnequalAdjacentGroupsSubsequenceI_L2900 {
    public static void main(String[] args) {
        //"a","b","c","d" || 1,0,1,1
        //getLongestSubsequence(new String[]{"b","d","c","e","f","z","x","w","y","j","m","q","i","p"},new int[]{1,0,0,0,0,1,0,1,1,1,1,0,1,1})
        System.out.println(getLongestSubsequence(new String[]{"c","a","b"}
                ,new int[]{0,0,1}));
    }

    //1,0,0,0,0,1,0,1,1,1,1,0,1,1 (14)
    //longest alternating subsequence = 1(0),0(1),1(5),0(6),1(7),0(11),1(12) => [b,d,z,x,w,q,i]
    //[b,d,c,e,f,z,x,w,y,j,m,q,i,p] (14)
    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>(groups.length);
        res.add(words[0]);
        int prev = groups[0];
        for(int i=1;i<groups.length;i++) {
            if((groups[i]^prev) == 1) {
                res.add(words[i]);
                prev = groups[i];
            }
        }
        return res;
    }
}
