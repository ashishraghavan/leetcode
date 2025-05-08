package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//problem # 1346 check if number & its double exists
//TODO: pending (check github easier & efficient solution)
//check https://github.com/doocs/leetcode/tree/main/solution/1300-1399/1346.Check%20If%20N%20and%20Its%20Double%20Exist
//for github solution
public class CheckIfNAndItsDoubleExists_L1346 {
    public static void main(String[] args) {
        //10,2,5,3
        //3,1,7,11
        //7,25,8,-12,1,50,2,0,17,7
        //7,0,8,-12,1,50,2,0,17,7
        //7,1,14,11
        //-10,12,-20,-8,15 -sort-> -20,-10,-8,12,15
        System.out.println(checkIfExistII(new int[]{-10,12,-20,-8,15}));
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

    //int[] res = new int[500], initialize with -1
    //-7,25,8,14,1,50,2,0,17 -sort-> -7,0,1,2,8,14,17,25,50
    //-10,12,-20,-8,15 -sort-> -20,-10,-8,12,15
    public static boolean checkIfExistII(int[] arr) {
        //if arr[i] = +ve, Arrays.binarySearch(arr,i+1,arr.length,arr[i]*2)
        //else Arrays.binarySearch(arr,0,i-1,arr[i]*2)
        Arrays.sort(arr);
        int idx;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] < 0) {
                idx = i-1 >= 0 ? Arrays.binarySearch(arr,0,i+1,arr[i]*2):-1;
            } else {
                idx = Arrays.binarySearch(arr,i+1,arr.length,arr[i]*2);
            }
            if(idx >= 0) return true;
        }
        return false;
    }
}
