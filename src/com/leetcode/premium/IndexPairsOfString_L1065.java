package com.leetcode.premium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

//TODO; review
//problem # 1065 index pairs of string
//check https://github.com/doocs/leetcode/tree/main/solution/1000-1099/1065.Index%20Pairs%20of%20a%20String
//for
//more
//details
public class IndexPairsOfString_L1065 {
    public static void main(String[] args) {
        System.out.println(idxPairsOfString("whatbydoyoumeanbythatdo",new String[]{"by","do","you"}));
    }

    //[14,15],[4,5],[6,8]
    //TODO: calculate time - O(n * n)??
    public static List<List<Integer>> idxPairsOfString(String text,String[] words) {
        //int[26] alpha = new int[]{}
        //w = w - 'a'

        List<List<Integer>> res = new ArrayList<>();
        int lastIdx;
        for (String word:words) {
            lastIdx = 0;
            while (lastIdx < text.length()) {
                int curr = text.indexOf(word,lastIdx);
                if(curr < 0) {
                    break;
                }
                lastIdx = curr+word.length()-1;
                res.add(Arrays.asList(curr,lastIdx));
            }
        }
        return res.stream().sorted(Comparator.comparing(l -> l.get(0))).collect(toList());
    }
}
