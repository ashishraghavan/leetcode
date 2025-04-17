package com.leetcode.premium;

//problem # 1933
//TODO: pending, almost came up with solution
public class DecomposeIntoValueEqualSubstrings {
    public static void main(String[] args) {
        //000111000 -> 000, 111, 000
        //00011111222 -> 000, 111, 11, 222
        //011100022233 -> 0, 111, 000, 222, 33

        //0001111111111222 -> 000, (111, 111, 111, 1) || (11, 11, 11, 11, 11) || (111, 111, 11, 11)
        System.out.println(isDecomposable("000111000"));
    }

    public static boolean isDecomposable(String str) {
        //000111000
        //int[3] result = {-1,-1,0,3} where result[0] = -1, result[1] = -1, result[1] * 2 + result[2] * 3 != str.length() return false

        //00011111222
        //int[3] result = {-1,-1,1,3} where result[0] = -1, result[1] = -1, result[1] * 2 + result[2] * 3 = 1*2 + 3*3 = 11 == str.length() return true

        //011100022233
        //int[3] result = {-1,1,1,3} 2*1 + 3*3 != str.length() return false

        int[] result = new int[]{-1,-1,0,0};
        char[] chArr = str.toCharArray();
        int ct = 1;
        for(int i=1; i<chArr.length; i++) {
            if (chArr[i] == chArr[i-1]) {
                ct++;
            } else {
                if(ct==2 || ct == 3) {
                    ++result[ct];
                } else if(ct == 5) {
                    //if result[2] == 0 ? ++result[2], ++result[3]
                    // else
                }
                ct = 1;
            }
        }
        return (result[2]*2 + result[3]*3) == str.length();
    }
}
