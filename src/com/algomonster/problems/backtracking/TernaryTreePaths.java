package com.algomonster.problems.backtracking;

import com.algomonster.problems.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TernaryTreePaths {
    public static void main(String[] args) {
        //Collection<String> list = Arrays.asList("1","2","3","x","x","x","6","x","x");
//        Collection<String> list = Arrays.asList("1","2","3","x","x","x","x","x","4","x","x","x","6","x","x","x");
//        com.algomonster.problems.backtracking.Node<Integer> root = Utilities.buildTreeBT(list.iterator(),Integer::parseInt);
        Node<Integer> root = new Node<>(1,List.of(new Node<>(2,List.of(new Node<>(3))),new Node<>(4),new Node<>(6)));
        System.out.println(ternaryTreePaths(root));
    }

    public static List<String> ternaryTreePaths(Node<Integer> root) {
        List<String> paths = new ArrayList<>();
        dfs(root,new ArrayList<>(),paths);
        return paths;
    }

    public static void dfs(Node<Integer> root,List<String> path,List<String> paths) {
        if(root.children.isEmpty()) {
            //we have reached a leaf node
            path.add(String.valueOf(root.val));
            paths.add(String.join("->", path));
            return;
        }
        List<Node<Integer>> children = root.children;
        path.add(String.valueOf(root.val));
        for(Node<Integer> child : children) {
            dfs(child,path,paths);
            path.remove(path.size()-1);
        }
    }
}
