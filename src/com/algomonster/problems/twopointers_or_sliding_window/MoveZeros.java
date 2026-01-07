package com.algomonster.problems.twopointers_or_sliding_window;

import java.util.Arrays;
import java.util.List;

//TODO: good problem, definitely [revise]
public class MoveZeros {
    public static void main(String[] args) {
        //1, 0, 2, 0, 0, 7
        //0,5,0,0,7,0
        //1,2,3
        //[1, 0, 2, 0, 3]
        //[0, 2, 0, 0, 5]
        //[9, 0, 8, 0, 7, 0]
        //[0, 0, 1, 0, 2, 0, 3]
        //[0, 0, 0, 1]
        //[0, 1, 0, 0, 2, 0, 0, 3]
        //[7, 6, 5, 0, 0, 0, 4, 3, 2, 1]
        List<Integer> list = Arrays.asList(7, 6, 5, 0, 0, 0, 4, 3, 2, 1);
        moveZerosV(list);
        System.out.println(list);
    }

    //1, 0, 2, 0, 0, 7
    //f=0,s=0 f shld be first zero, s shld be first non-zero
    //while(s < l.size())
    //if l[f]!=0 ? f++
    //if l[s]==0 ? s++
    //swap(l,f,s) -> 1,2,0,0,0,7, f++,s++
    //

    //0,5,0,0,7,0
    //f=0,s=0
    //1, 0, 2, 0, 0, 7
    public static void moveZeros(List<Integer> l) {
        int f=0,s=0;
        while(s < l.size()) {
            while(f < l.size() && l.get(f) != 0) f++;
            while(s < l.size() && l.get(s) == 0) s++;
            if(f < l.size() && s < l.size()) {
                swap(l,f,s);
                s=f+1;
            }
        }
    }

    //1, 0, 2, 0, 0, 7
    //0,5,0,0,7,0
    public static void moveZerosII(List<Integer> l) {
        int f=0,s=0;
        while(true) {
            while(f < l.size() && s < l.size() && l.get(f) != 0) {
                f++;
                s=f+1;
            }
            if(f >= l.size() || s >= l.size())break;
            swap(l,f,s);
            s=f+1;
        }
    }

    //1, 0, 2, 0, 0, 7
    //0,5,0,0,7,0
    public static void moveZerosIII(List<Integer> l) {
        int f=0,s=0;
        while(f++ < l.size()) {
            if(f < l.size() && l.get(f) != 0){
                swap(l,f,s);
                s++;
            }
            //f++;
        }
    }

    //1, 0, 2, 0, 0, 7
    //0,5,0,0,7,0
    public static void moveZerosIV(List<Integer> nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.size(); fast++) {
            if (nums.get(fast) != 0) {
                int slowNum = nums.get(slow);
                nums.set(slow, nums.get(fast));
                nums.set(fast, slowNum);
                slow++;
            }
        }
    }

    public static void moveZerosV(List<Integer> nums) {
        int fast = 0, slow = 0;
        for(;fast < nums.size();fast++) {
            //slow should be pointing to first zero
            //fast should be pointing to first non-zero
            if(nums.get(fast) != 0) {
                //swap slow, fast when this happens
                int slowNum = nums.get(slow);
                nums.set(slow,nums.get(fast));
                nums.set(fast,slowNum);
                slow++;
            }
        }
    }

    public static void swap(List<Integer> l,int x, int y) {
        Integer temp = l.get(x);
        l.set(x,y);
        l.set(y,temp);
    }
}
