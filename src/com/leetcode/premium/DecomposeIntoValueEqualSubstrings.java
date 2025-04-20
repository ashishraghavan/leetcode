package com.leetcode.premium;

//problem # 1933
//check https://github.com/doocs/leetcode/blob/main/solution/1900-1999/1933.Check%20if%20String%20Is%20Decomposable%20Into%20Value-Equal%20Substrings/README_EN.md
//for
//answer
public class DecomposeIntoValueEqualSubstrings {
    public static void main(String[] args) {
        //000111000 -> 000, 111, 000
        //00011111222 -> 000, 111, 11, 222
        //011100022233 -> 0, 111, 000, 222, 33

        //0001111111111222 -> 000, (111, 111, 111, 1) || (11, 11, 11, 11, 11) || (111, 111, 11, 11)
        //11111111111111111111
        System.out.println(isDecomposableII("11111111111111111111"));
    }

    public static boolean isDecomposable(String str) {
        //000111000
        //int[3] result = {-1,-1,0,3} where result[0] = -1, result[1] = -1, result[1] * 2 + result[2] * 3 != str.length() return false

        //00011111222
        //int[3] result = {-1,-1,1,3} where result[0] = -1, result[1] = -1, result[1] * 2 + result[2] * 3 = 1*2 + 3*3 = 11 == str.length() return true

        //011100022233
        //int[3] result = {-1,1,1,3} 2*1 + 3*3 != str.length() return false

//        if(ct%2 == 0) {
//            result[ct] += (result[ct]*(ct/2));
//        }
//        ct = 1;

//        if(ct==2 || ct == 3) {
//            ++result[ct];
//        } else if(ct == 5) {
//            //if result[2] == 0 ? ++result[2], ++result[3]
//            // else
//        }
        //00011111222
        //int[] result = new int[]{-1,-1,0,0};
        char[] chArr = str.toCharArray();
        int ct3 = 0, ct2 = 0, ct = 0;
        for(int i=1; i<chArr.length; i++) {
            if (chArr[i] == chArr[i-1]) {
                ct++;
            } else {
                //ct == 1? return false
                //ct%2 == 0?
                    //ct != 2? return false;
                    //else ct2++;
                //ct%3 == 0?
                    //ct3++;
                //ct%5 == 0?
                //ct != 5?
                    //

            }
        }
        //return (result[2]*2 + result[3]*3) == str.length();
        return false;
    }


    //000111000
    //00011111222
    //011100022233
    //0001111111111222
    //11111111111111111111
    public static boolean isDecomposableII(String S) {
        //if S.length == 1 return false
        //i=0,j=i+1, if S[i] == S[j] ct++; else if (j-i+1)%3 == 1? return false, else if (j-i+1)%3 == 2? ct2++; if ct2 > 1 return false
        if (S.length() == 1) return false;
        int i = 0, j = i + 1;
        int ct = 1, ct2 = 0;
        while(j < S.length()) {
            if (S.charAt(i) == S.charAt(j)) {
                ct++;
                i++;
                j++;
            } else {
                if (ct % 3 == 1) {
                    return false;
                } else if(ct % 3 == 2) {
                    ct2++;
                    if (ct2 > 1) {
                        return false;
                    }
                }
                i = j;
                j = i + 1;
                ct = 1;
            }
        }
        return true;
    }
}
