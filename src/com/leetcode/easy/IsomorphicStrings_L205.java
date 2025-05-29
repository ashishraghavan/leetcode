package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

//problem # 205 isomorphic strings
//TODO: very important question concept wise, definitely revise
// pending github solution review
// check https://github.com/doocs/leetcode/tree/main/solution/0200-0299/0205.Isomorphic%20Strings for github solution
public class IsomorphicStrings_L205 {
    public static void main(String[] args) {
        //"paper","title"
        //"egg","add"
        //"aab","xxy"

        //"foo" and "bar"
        //"aab" and "xyz"
        //"badc" and "baba" -> {b:b,a:a,d:b,c:a}
        System.out.println(isIsomorphic("badc","baba"));
    }

    //"paper","title" -> paer, tile
    //paper, turet -> paer, ture p->t, a->u, e->r, r->e => paper = tutre
    //if no. of unique characters in s = no. of unique characters in t && index of pairs is same
    // i.e. for paper, title
    // idx(p)=0 idx(t)=0
    // idx(a)=1 idx(i)=1
    // idx(p)=2 idx(t)=2
    // idx(e)=3 idx(l)=3
    // idx(r)=4 idx(e)=4
    //{p:t,a:i,e:l,r:e}

    //pepper, turret -> {p:t,e:u,} -> if p is already present as a key in the map and map.get(p) != t(curr_idx) return true
    //paper, turet

    //"badc" and "baba" -> {b:b,a:a,d:b,c:a}
    //b:b, d:b -> two different characters cannot map to same character
    // if map contains value tCh && (!map.containsKey(sCh) || map.get(sCh) != tCh) return false
    //MY SOLUTION
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> mp = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            Character sCh = s.charAt(i);
            Character tCh = t.charAt(i);
            if(mp.containsValue(tCh) && (!mp.containsKey(sCh) || mp.get(sCh) != tCh)) {
                return false;
            }
            if(!mp.containsKey(sCh)) {
                mp.put(sCh,tCh);
                continue;
            }
            if(mp.get(sCh) != tCh) {
                return false;
            }
        }
        return true;
    }
}
