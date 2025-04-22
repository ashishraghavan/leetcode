package com.leetcode.premium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//problem # 2229
//check https://github.com/doocs/leetcode/tree/main/solution/2200-2299/2229.Check%20if%20an%20Array%20Is%20Consecutive
//for
//more
//details
//TODO: review
public class ConsecutiveArray_L2229 {
    public static void main(String[] args) {
        //1,3,4,2
        //1,3
        //3,5,4
        //4,8,6,9,3,5,7
        //4,8,6,9,3,7
        System.out.println(isConsecutive(new int[]{4,8,6,9,3,7}));
    }

    //solution #1 with O(nlogn) runtime, O(n) space no optimization
    public static boolean isConsecutive(int[] A) {
        //O(nlogn)
        Arrays.sort(A);
        int[] _A = new int[A[A.length-1]+1];
        //O(n)
        for(int val:A) {
            ++_A[val];
        }
        //O(n)
        for(int i=A[0];i<A[A.length-1];i++) {
            if(_A[i] != 1) {
                return false;
            }
        }
        return true;
    }

    //solution #2 with O(n) runtime, O(n) space
    public static boolean isConsecutiveII(int[] A) {
        //O(n)
//        int min = getMin(A);
        //O(n)
//        int max = getMax(A);
        //O(n)
        //int[] _A = new int[max+1];
//        for(int val:A) {
//            ++_A[val];
//        }
        //O(n)
//        for(int i=min;i<=max;i++) {
//            if(_A[i] != 1) {
//                return false;
//            }
//        }
//        return true;
        return false;
    }

    //TODO: check better solution in given link
    public static boolean isConsecutiveIII(int[] A) {
        return false;
    }
}
