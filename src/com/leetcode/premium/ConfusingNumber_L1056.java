package com.leetcode.premium;

//Practicing problem #1056 Confusing Number
public class ConfusingNumber_L1056 {
    public static void main(String[] args) {
        //System.out.println(isConfusingIII(9999));
        System.out.println(reverseInteger(9000));
    }

    //A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.
    //When 0, 1, 6, 8, and 9 are rotated 180 degrees, they become 0, 1, 9, 8, and 6 respectively.
    //When 2, 3, 4, 5, and 7 are rotated 180 degrees, they become invalid.
    public static boolean isConfusing(String str) {
        if(str.isEmpty()) {
            return false;
        }
        int[] conArr = new int[]{0,1,-1,-1,-1,-1,9,-1,8,6};
        //if str consists of only 0/8 then reverse will be equal to original || conArr[Character.getNumericValue(str.charAt(i))] == -1 -> return false
        //reverse str using StringBuilder#reverse
        String reverseStr = new StringBuilder(str).reverse().toString();
        if(str.length() > 1 && reverseStr.equals(str)) {
            return false;
        }
        int i=0;
        if(reverseStr.startsWith("0")) {
            i=1;
            while(reverseStr.charAt(i) == '0') {
                i++;
            }
        }
        for(;i<reverseStr.length();i++) {
            if(conArr[Character.getNumericValue(reverseStr.charAt(i))] == -1) {
                return false;
            }
        }
        return true;
    }

    //INCORRECT SOLUTION - boolean isAllZeroEight will flag 0008 as incorrect
    public static boolean isConfusingII(String str) {
        if(str.isEmpty()) {
            return false;
        }
        int[] conArr = new int[]{0,1,-1,-1,-1,-1,9,-1,8,6};
        //if str consists of only 0/8 then reverse will be equal to original || conArr[Character.getNumericValue(str.charAt(i))] == -1 -> return false
        boolean isAllZeroEight = Character.getNumericValue(str.charAt(0)) == '0' || Character.getNumericValue(str.charAt(0)) == '8';
        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            if(conArr[Character.getNumericValue(ch)] == -1) {
                return false;
            }
            isAllZeroEight = ch == '0' || ch == '8';
        }
        return !isAllZeroEight;
    }

    //SOLUTION FROM https://github.com/doocs/leetcode/blob/main/solution/1000-1099/1056.Confusing%20Number/README_EN.md
    public static boolean isConfusingIII(int n) {
        int[] conArr = new int[]{0,1,-1,-1,-1,-1,9,-1,8,6};
        int x = n, y = 0;
        //reversing n & storing it in y
        while(x > 0) {
            int dv = x % 10;
            if(conArr[dv] == -1) {
                return false;
            }
            y = y * 10 + conArr[dv];
            x = x/10;
        }
        return n!=y;
    }

    //TODO; reverse integer n (in Integer range) without converting it into string - this uses logic from confusingNumber(int n)
    public static int reverseInteger(int n) {
        int x = n, y = 0;
        while (x > 0) {
            y = y * 10 + (x % 10);
            x = x/10;
        }
        return y;
    }
}
