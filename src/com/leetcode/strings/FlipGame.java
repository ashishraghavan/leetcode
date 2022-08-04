package com.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Question #293
 * given str containing only '+' & '-', one move = flip
 * two consecutive '+' to '-'. i.e. if original str = "++",
 * one move will change this to "--". Game ends when a player
 * can no longer make a move and therefore other player is
 * the winner.
 *
 * Return all possible states of input string str after one
 * valid move in any order. If no more valid moves, return
 * empty list[].
 *
 * TODO : NO JUDGE; THIS IS A GREYED OUT PROBLEM
 */
public class FlipGame {

    private static List<String> flipGame(String str) {
        List<String> res = new ArrayList<>();
        int i = 1;
        while(i < str.length()) {
            if(str.charAt(i) == '+' && str.charAt(i-1) == '+') {
                res.add(str.substring(0,i-1)
                        .concat("--")
                        .concat((i+1) < str.length() ? str.substring(i+1) : ""));
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        //"++++"
        //"++--+---++++"
        System.out.println(flipGame("+----+++++--++----+++"));
    }
}
