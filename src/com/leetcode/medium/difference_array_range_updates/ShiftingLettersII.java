package com.leetcode.medium.difference_array_range_updates;

//#2381
public class ShiftingLettersII {
    public static void main(String[] args) {
        //{{0,5,1}} -> ashish
        //{{0,0,0},{1,2,1},{3,3,0},{0,2,1},{0,2,1},{0,2,1},{0,2,1},{0,2,1}};
        String s = "zrghr";
        //{{0,0,0},{1,2,1},{3,3,0},{0,2,1}
        int[][] shifts = {{0,0,0},{1,2,1},{3,3,1},{4,4,1}};
        System.out.println(shiftingLetters(s,shifts));
    }

    //s=abc
    //{{0,1,0},{1,2,1},{0,2,1}}
    //abc -> zac -> zbd -> ace
    public static String shiftingLetters(String s, int[][] shifts) {
        int[] diff = new int[s.length() + 1];

        for(int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2] == 1 ? 1 : -1;

            diff[start]+=direction;
            diff[end+1]-=direction;
        }

        int currentShift = 0;
        char[] sCh = s.toCharArray();
        for(int i=0;i<diff.length-1;i++) {
            currentShift += diff[i];
            int netShift = ((currentShift % 26) + 26) % 26;
            //System.out.println("shift at "+i+" = "+shift);
            sCh[i] = (char)('a' + (s.charAt(i) - 'a' + netShift) % 26);
        }
        return new String(sCh);
    }
}
