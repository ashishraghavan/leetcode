package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

//problem # 1346 check if number & its double exists
public class CheckIfNAndItsDoubleExists_L1346 {
    public static void main(String[] args) {
        //10,2,5,3
        //3,1,7,11
        //7,25,8,-12,1,50,2,0,17,7
        //7,0,8,-12,1,50,2,0,17,7
        //7,1,14,11
        System.out.println(checkIfExist(new int[]{3,1,7,11}));
    }

    //10,2,5,3
    //7,25,8,-12,1,50,2,0,17,7
    //two diff indexes with value = 0 - return true
    public static boolean checkIfExist(int[] arr) {
        //value%2 != 0 should be ignored but include if value%5==0
        //duplicate nos can be ignored
        //store arr[i] as key, i as value
        //value 0 should be ignored
        //map:{8:2,-12:3,50:5,2:6,25:1,1:4}
        Map<Integer,Integer> map = new HashMap<>();
        int zeroCt = 0;
        for(int i=0;i<arr.length;i++) {
            int value = arr[i];
            if(value == 0) {
                ++zeroCt;
                if(zeroCt > 1)return true;
            }
            if(value == 1) {
                map.put(value,i);
            }
            //(value % 2 != 0 && value % 5 != 0) ||
            if(value == 0 || (map.containsKey(value))) {
                continue;
            }
            map.put(value,i);
        }
        System.out.println(map);
        for(Integer key:map.keySet()) {
            if(map.containsKey(key*2)) {
                return true;
            }
        }
        return false;
    }
}
