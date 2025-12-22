package com.algomonster.problems.depthfirstsearch;

import com.algomonster.problems.Utilities;

import java.util.Arrays;
import java.util.Collection;

//refer diagram - resources/visible_tree_node.png
public class NoOfVisibleNodes {
    private static int cnt = 0;
    public static void main(String[] args) {
        //Collection<String> list = Arrays.asList("5","4","3","x","x","8","x","x","6","x","x");
        //Collection<String> list = Arrays.asList("5","4","3","7","x","x","x","8","x","x","6","x","x");
        Collection<String> list = Arrays.asList("5","8","3","7","x","x","x","8","x","x","6","9","x","x","11","x","x","x","x");
        Node<Integer> root = Utilities.buildTree(list.iterator(),Integer::parseInt);
        System.out.println(visibleTreeNode(root));
    }

    public static int visibleTreeNode(Node<Integer> root) {
        if(root == null)return 0;
        cnt++;
        dfs(root.left,root.val);
        dfs(root.right,root.val);
        return cnt;
    }

    public static void dfs(Node<Integer> root,int max) {
        if(root == null)return;
        else {
            if(root.val >= max) {
                cnt++;
                max = root.val;
            }
            dfs(root.left,max);
            dfs(root.right,max);
        }
    }
}
