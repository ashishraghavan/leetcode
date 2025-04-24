package com.leetcode.premium;

import java.util.*;

//problem # 293
//check https://github.com/doocs/leetcode/blob/main/solution/0200-0299/0293.Flip%20Game/README_EN.md
//for
//more
//details
public class FlipGame_L293 {
    public static void main(String[] args) {
        //++++
        //+
        //+--++-+--++ => +-----+--++, +--++-+----
        System.out.println(flipGame("+--++-+--++"));
    }

    public static List<String> flipGame(String S) {
        //++++ -> --++, +--+, ++--
        //find all indexes where a + is followed by another + -> for ++++ => K:{0,1,2}
        //if k.size == 0 return Collections.emptyList()
        //else
        //List<String> res = new ArrayList<>()
        //for each i in K: res.add(S.subStr(0,i) + "--" + S.subStr(i+2))
        //return res
        if(S.length() == 1)return Collections.emptyList();
        Set<Integer> keys = new HashSet<>();
        for(int i=0;i<S.length()-1;i++) {
            if (S.charAt(i) == '+' && S.charAt(i+1) == '+') {
                keys.add(i);
            }
        }
        if(keys.isEmpty())return Collections.emptyList();
        List<String> res = new ArrayList<>();
        for(Integer idx:keys) {
            res.add(S.substring(0,idx) + "--" + S.substring(idx+2));
        }
        return res;
    }
}
