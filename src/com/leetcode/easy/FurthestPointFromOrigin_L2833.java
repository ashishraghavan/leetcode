package com.leetcode.easy;

//prob # 2833 - furthest point from origin
public class FurthestPointFromOrigin_L2833 {
    public static void main(String[] args) {
        //L_RL__R
        //_R__LL_
        //_______
        System.out.println(furthestDistanceFromOrigin("_R__LL_"));
    }

    //L_RL__R
    //_ = L | R
    //LLRLLLR || LRRLRRR -> 3 || 3

    //_R__LL_ -> LRLLLL || RRRRLLR ||
    //if n(L) == n(R) return no_of_underscores? else max(L,R) + no_of_underscores
    public static int furthestDistanceFromOrigin(String moves) {
        int cntL = 0,cntR = 0,cntU = 0;
        for(int i=0;i<moves.length();i++) {
            char ch = moves.charAt(i);
            if(ch == 'L') {
                cntL++;
            } else if(ch == 'R') {
                cntR++;
            } else {
                cntU++;
            }
        }
        if(cntL == cntR) {
            return cntU;
        } else {
            int max = Integer.compare(cntL,cntR);
            return Math.max(cntL,cntR) + cntU - (max < 0 ? cntL : cntR);
        }
    }
}
