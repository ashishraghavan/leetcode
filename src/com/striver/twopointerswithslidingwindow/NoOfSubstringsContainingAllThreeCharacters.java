package com.striver.twopointerswithslidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        //abcabc
        //bbacba
        //aaabbbccc
        System.out.println(numberOfSubstringsIII("aaabbbccc"));
        //System.out.println(numberOfSubstringsII("abcabc",2));
    }

    //abcabc
    //(abc),(bca),(cab),(abc),(abca),(abcab),(abcabc),(bcab),(bcabc),(cabc)
    //(abc),(abca),(abcab),(abcabc)
    //aaacb
    //(aaacb),(aacb),(acb),(),(),(),()
//    public static int numberOfSubstrings(String s) {
//        int cnt=0,i,j;
//        int[] chars = new int[3];
//        for(j=0;j<s.length();j++){
//            chars[s.charAt(j) - 'a']++;
//            if(isValid(chars)) {
//                cnt++;
//            }
//        }
//    }

    //goal >= 3
    public static int numberOfSubstringsII(String s,int g) {
        if(g < 0)return 0;
        int i=0,j=0,cnt=0,sum=0;
        while(j < s.length()) {
            sum+=mapChar(s.charAt(j));
            while(sum >= g) {
                sum-=mapChar(s.charAt(j));
                i++;
            }
            cnt += (j-i+1);
            j++;
        }
        return cnt;
    }

    public static int mapChar(char ch) {
        return (ch=='a') ? 0 : ((ch=='b') ? 1 : 2);
    }

    //abcabc
    //"abc","abca","abcab","abcabc","bca","bcab","bcabc","cab","cabc","abc"
    //"abc","abca","abcab","abcabc","bcabc","bca"
    public static int numberOfSubstringsIII(String s) {
        int a=-1,b=-1,c=-1,cnt=0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            switch(ch) {
                case 'a':
                    a=i;
                    break;
                case 'b':
                    b=i;
                    break;
                case 'c':
                    c=i;
                    break;
            }
            if(a==-1 || b==-1 || c==-1) {
                continue;
            }
            int minIdx = Math.min(Math.min(a,b),c);
            //bbacba
            if(i-minIdx+1 >= 3) {
                cnt++;
                cnt+=(minIdx);
            }
        }
        return cnt;
    }

    public static boolean isValid(int[] chars) {
        return chars[0] >= 1 && chars[1] >= 1 && chars[2] >= 1;
    }

    public static boolean isValid(Map<Character,Integer> map) {
        return map.containsKey('a') && map.get('a') >= 1 &&
                map.containsKey('b') && map.get('b') >= 1 &&
                map.containsKey('c') && map.get('c') >= 1;
    }
}
