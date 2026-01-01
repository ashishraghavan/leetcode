package com.algomonster.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PossibleNLetterWords {
    public static void main(String[] args) {
        System.out.println(letterCombination(2));
    }

//    function dfs(start_index, path):
//            if is_leaf(start_index):
//    report(path)
//    return
//            for edge in get_edges(start_index):
//            path.add(edge)
//    dfs(start_index + 1, path)
//    path.pop()

    //a,b
    public static List<String> letterCombination(int n) {
        List<String> paths = new ArrayList<>();
        dfs("ab",0,n,new StringBuilder(),paths);
        return paths;
    }

    public static void dfs(String s,int stIdx,int n,StringBuilder path,List<String> paths) {
        if(stIdx == n) {
            paths.add(path.toString());
            return;
        }
        for(int i=0; i < 2;i++) {
            path.append(s.charAt(i));
            dfs(s,stIdx+1,n,path,paths);
            path.deleteCharAt(path.length()-1);
        }
    }
}
