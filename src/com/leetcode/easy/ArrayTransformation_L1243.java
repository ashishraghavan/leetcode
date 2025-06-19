package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

//problem # 1243 - PREMIUM, check https://github.com/doocs/leetcode/tree/main/solution/1200-1299/1243.Array%20Transformation
//for question & solution
//Maybe search for solution better than simulation
public class ArrayTransformation_L1243 {
    public static void main(String[] args) {
        //[6,2,3,4] exp. [6,3,3,4]
        //[1,6,3,4,3,5] exp. [1,4,4,4,4,5]
        //System.out.println(Arrays.toString(transformArrayII(new int[]{1,6,3,4,3,5})));
        System.out.println(transformArrayII(new int[]{6,2,3,4}));
    }

    //[1,6,3,4,3,5] -> [1,5,4,3,4,5] -> [1,4,4,4,4,5] avg(6+3+4+3) = 16/4 = 4
    //[6,2,3,4] -> avg(5/2) = 2.5 =roundoff = 3?
    //[1,5,4,8,2,10,7,3] -> 36/6 = 6 exp. [1,6,6,6,6,6,6,3], [1,4,5,7,3,9,7,3], [1,4,5,6,4,8,7,3], [1,4,5,5,5,6,7,3], [1,4,5,5,5,6,6,3]

    //github solution uses simulation i.e. performing operations each day until array can't be changed anymore
    //idea very similar to github solution
    public static int[] transformArray(int[] A) {
        int ops = 1;
        List<Integer> tempList = Arrays.stream(A).boxed().collect(toList());
        List<Integer> res = new ArrayList<>();
        res.set(0,A[0]);
        res.set(res.size()-1,A[A.length-1]);
        while(ops >= 1) {
            for(int i=1;i<=tempList.size()-2;i++) {
                int curr = tempList.get(i);
                int prev = tempList.get(i-1);
                int next = tempList.get(i+1);
                if(curr < prev && curr < next) {
                    ops++;
                    res.add(i,++curr);
                } else if(curr > prev && curr > next) {
                    ops++;
                    res.add(i,--curr);
                }
            }
            tempList = res;
        }
        return new int[]{};
    }

    public static List<Integer> transformArrayII(int[] A) {
        boolean ops = true;
        List<Integer> res = new ArrayList<>();
        int[] temp;
        while(ops) {
            ops=false;
            temp = A.clone();
            for(int i=1;i<temp.length-1;i++) {
                int curr = temp[i];
                int prev = temp[i-1];
                int next = temp[i+1];
                if(curr > prev && curr > next) {
                    ops = true;
                    --A[i];
                } else if(curr < prev && curr < next) {
                    ops = true;
                    ++A[i];
                }
            }
        }
        for (int j : A) {
            res.add(j);
        }
        return res;
    }
}
