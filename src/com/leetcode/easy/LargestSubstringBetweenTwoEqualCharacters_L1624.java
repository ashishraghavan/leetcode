package com.leetcode.easy;

import java.util.*;

//update - wrote another solution - see maxLengthBetweenEqualCharactersII
//TODO: need to review problem answer, zdbqfyzijqklmzoy returns answer as 12 instead of 9, for char=z
// at indexes 0, 6, 13, judge is computing length as 13-0-1 = 12 but s.substring(0,13) contains char z at index = 6
//prob # 1624 - largest substring between two equal characters
public class LargestSubstringBetweenTwoEqualCharacters_L1624 {
    public static void main(String[] args) {
        //zdbqfyzijqklmzoy
        //zdbqfyijqklmzoy
        //abca
        //cbzxy
        //aa
        System.out.println(maxLengthBetweenEqualCharactersIII("zdbqfyzijqklmzoy"));
    }

    //zdbqfyzijqklmzoy -> zdbqfyzijqklmz, qfyijq, yijqklmzoy
    //int[] chArr = new int[26] -> [0,1,0,1,0,1.......0]
    //initialize chArr with -1, populate chArr by rules - for i in (0,str.length()-1) ch = str.charAt(i),
    //set chArr[ch-'a'] = i where

    //use set(S) & map(M), for each char in s, insert into S - check if S.add() returns true ? add into M,

    //Map<Character,List> mp -> [{z,{0,6,13}}, {q,{3,8}}, {}]
    //{q=[3, 9], y=[5, 15], z=[0, 6, 13]}
    //// logic written to exclude cases where there is same character as ones on the opposite ends
    public static int maxLengthBetweenEqualCharacters(String s) {
        if(s.length() == 1)return 0;
        int[] chArr = new int[26];
        Map<Character, List<Integer>> mp = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            chArr[s.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(chArr));
        for(int i=0;i<s.length();i++) {
            if(chArr[s.charAt(i) - 'a'] > 1) {
                List<Integer> idxList = mp.get(s.charAt(i));
                if (idxList == null) {
                    idxList = new ArrayList<>();
                }
                idxList.add(i);
                mp.put(s.charAt(i),idxList);
            }
        }
        //System.out.println(mp);
        int mx = Integer.MIN_VALUE;
        for(Character ch : mp.keySet()) {
            List<Integer> idxList = mp.get(ch);
            for(int i=0;i<idxList.size()-1;i++) {
                mx = Math.max(mx,idxList.get(i+1)-idxList.get(i)-1);
            }
        }
        return mx;
    }

    //zdbqfyzijqklmzoy
    public static int maxLengthBetweenEqualCharactersII(String s) {
        if(s.length() == 1)return -1;
        Map<Character,List<Integer>> map = new HashMap<>(s.length());
        for(int i=0;i<s.length();i++) {
            if(map.containsKey(s.charAt(i))) {
                List<Integer> list = map.get(s.charAt(i));
                list.add(i);
                map.put(s.charAt(i),list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(s.charAt(i),list);
            }
        }
        System.out.println(map);
        int mxLen = 0;
        for(Character ch : map.keySet()) {
            if(map.get(ch) != null && map.get(ch).size() > 1) {
                List<Integer> list = map.get(ch);
                mxLen = Math.max(mxLen,list.get(list.size()-1) - list.get(0) - 1);
            }
        }
        return mxLen;
    }


    //zdbqfyzijqklmzoy
    //solution based on first result from google search "leetcode 1624 intuition"
    public static int maxLengthBetweenEqualCharactersIII(String s) {
        if(s.length() == 1)return -1;
        Map<Character,Integer> mp = new HashMap<>(s.length());
        int mxLen = 0;
        for(int i=0;i<s.length();i++) {
            if(mp.containsKey(s.charAt(i))) {
                mxLen = Math.max(mxLen,i - mp.get(s.charAt(i)) - 1);
            } else {
                mp.put(s.charAt(i),i);
            }
        }
        return mxLen;
    }
}
