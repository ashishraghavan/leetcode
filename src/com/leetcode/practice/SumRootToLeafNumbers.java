package com.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
    public static void main(String[] args) {
        BinaryTree tree = doInserts();
        System.out.println("sum root to leaf numbers : "+doSum(tree.getRoot()));
    }

    private static Integer doSum(Node root) {
        String s = String.valueOf(root.getValue());
        List<Integer> sumList = new ArrayList<>();
        sum3(root, sumList, s);
        int sum = 0;
        if (!sumList.isEmpty()) {
            for (Integer no : sumList) {
                sum += no;
            }
        }
        return sum % 1003;
    }

    //try #1
    private static void sum(Node node,Integer sum,StringBuilder sb) {
        if (node.getLeft() == null && node.getRight() == null) {
            sum += Integer.parseInt(sb.toString());
        } else if (node.getLeft() == null) {
            sb.append(node.getRight().getValue());
            sum(node.getRight(), sum, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else if (node.getRight() == null) {
            sb.append(node.getLeft().getValue());
            sum(node.getLeft(), sum, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(node.getLeft().getValue());
            sum(node.getLeft(), sum, sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append(node.getRight().getValue());
            sum(node.getRight(), sum, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    //try #2
    private static int sum2(Node node,int sum,String s) {
        if (node.getLeft() == null && node.getRight() == null) {
            sum += Integer.parseInt(s);
            return sum;
        } else if (node.getLeft() == null) {
            return sum2(node.getRight(), sum, s.concat(String.valueOf(node.getRight().getValue())));
        } else if (node.getRight() == null) {
            return sum2(node.getLeft(), sum, s.concat(String.valueOf(node.getLeft().getValue())));
        } else {
            return sum2(node.getLeft(), sum, s.concat(String.valueOf(node.getLeft().getValue()))) +
                    sum2(node.getRight(), sum, s.concat(String.valueOf(node.getRight().getValue())));
        }
    }

    //try #3
    private static void sum3(Node node, List<Integer> sumList, String s) {
        if (node.getLeft() == null && node.getRight() == null) {
            sumList.add(Integer.parseInt(s));
        } else if (node.getLeft() == null) {
            sum3(node.getRight(), sumList, s.concat(String.valueOf(node.getRight().getValue())));
        } else if (node.getRight() == null) {
            sum3(node.getLeft(), sumList, s.concat(String.valueOf(node.getLeft().getValue())));
        } else {
            sum3(node.getLeft(), sumList, s.concat(String.valueOf(node.getLeft().getValue())));
            sum3(node.getRight(), sumList, s.concat(String.valueOf(node.getRight().getValue())));
        }
    }

    private static BinaryTree doInserts() {
        BinaryTree bt = new BinaryTree(1);
        bt.insertNode(2);
        bt.insertNode(3);
        bt.insertNode(4);
        bt.insertNode(5);
        Node found = bt.search(5);
        found.setRight(new Node(6));
        found.getRight().setRight(new Node(8));
        found = bt.search(6);
        found.setLeft(new Node(7));
        found = bt.search(3);
        found.setRight(new Node(9));
        found.getRight().setLeft(new Node(9));
        bt.inOrderTraversal();
        return bt;
    }
}
