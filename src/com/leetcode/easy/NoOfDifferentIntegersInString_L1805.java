package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

//problem # 1805
//check https://github.com/doocs/leetcode/tree/main/solution/1800-1899/1805.Number%20of%20Different%20Integers%20in%20a%20String
//for solution
public class NoOfDifferentIntegersInString_L1805 {
    public static void main(String[] args) {
        //a123bc34d8ef34
        //a1b01c001
        //leet1234code234
        //121890
        //a000000
        //190a000
        //167278959591294a167278959591294
        System.out.println(numDifferentIntegers("a1b01c001"));
    }

    //assuming digits are decimal - i.e. no a,b,d,e,f
    //0,1,2,3....9 -ascii-> 48,49,50....57
    //a,b,c,d....z -ascii-> 97,98,99....122
    //TODO: NO NEED TO CONVERT EACH INTEGER SUBSTRING INTO INTEGER USING parseInt(..)
    // just use Set<String>, remove leading zeroes & store the resulting string in the set
    public static int numDifferentIntegers(String word) {
        Set<String> distSet = new HashSet<>();
        int start = -1;
        int end = -1;
        for(int i=0;i<word.length();i++) {
            if(Character.isDigit(word.charAt(i))) {
                if(start > -1) {
                    end++;
                } else {
                    if(word.charAt(i) != '0') {
                        start = i;
                        end = i;
                    }
                }
            } else {
                if(start > -1) {
                    distSet.add(word.substring(start,end+1));
                    start = -1;
                    end = -1;
                }
            }
        }
        if(start > -1) {
            distSet.add(word.substring(start,end+1));
        }
        return distSet.size();
    }
}
