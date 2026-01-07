package com.algomonster.problems.twopointers;

import java.util.Arrays;
import java.util.List;

//TODO: [revise]
// refer C:\Users\ashish\OneDrive\Documents\dev-notes\java-class-template - flexible size sliding window template - shortest
// for template used to solve this problem
public class SubarraySumLongest {
    public static void main(String[] args) {
        //1, 6, 3, 1, 2, 4, 5 | 10
        System.out.println(subarraySumLongest(Arrays.asList(1, 6, 3, 1, 2, 4, 5),10));
    }

    //1, 6, 3, 1, 2, 4, 5 | 10
    //f=0,s=1,cnt=0 sum=l[f]+l[s] == t ? cnt++; else if sum < t ? s++ else f++
    public static int subarraySumLongest(List<Integer> l, int t) {
        int maxLen = Integer.MIN_VALUE;
        if(l.isEmpty())return 0;
        int f=0,s,sum = 0;
        for(s=0;s<l.size();s++) {
            sum += l.get(s);
            if(sum <= t){
                maxLen = Math.max(maxLen,s-f+1);
            } else {
                sum -= l.get(f);
                f++;
            }
        }
        return maxLen;
    }
}
