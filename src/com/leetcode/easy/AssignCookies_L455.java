package com.leetcode.easy;

import java.util.Arrays;

//problem # 455 - assign cookies
//check https://github.com/doocs/leetcode/tree/main/solution/0400-0499/0455.Assign%20Cookies for slightly better solution
public class AssignCookies_L455 {
    public static void main(String[] args) {
        //g = [1,2,3], s = [1,1]
        //g = [1,2], s = [1,2,3]
        //g = [3,1,5,2], s = [4,1,2,5,7]
        //g = 29339, 735, 3929, 27822, 23831, 774, 29998, 8061 | s = 29584, 9986, 4223, 324
        //g = 173, 99, 299, 232, 234, 198, 16, 2 | s = 198, 11, 164, 59, 13
        System.out.println(findContentChildren(new int[]{1,2},new int[]{1,2,3}));
    }

    //g = [3,1,5,2], s = [4,1,2,5,7]
    //sort array g,s -> g = [1,2,3,5], s = [1,2,4,5,7]
    //g = [3,1,5,2], s = [4,1,2,1,1]
    //sort array g,s -> g = [1,2,3,5], s = [1,1,1,2,4]

    //why sort g,s? if g[i] > s[i], we don't have to check indexes [0...i]
    // such that s[i] >= g[i] because all values s[0],s[1]...s[i] will be < g[i].
    //j = 0, res = 0;
    //for i in g,
    // if j == s.length-1 && s[j] < g[i] return res;
    //  if s[j++] >= g[i] res++;
    public static int findContentChildren(int[] greed, int[] cookies) {
        if(cookies.length == 0)return 0;
        Arrays.sort(greed);
        Arrays.sort(cookies);
        int j=0,res=0;
        for (int k : greed) {
            while (j < cookies.length) {
                if (cookies[j++] >= k) {
                    res++;
                    break;
                }
            }
            if(j >= cookies.length) {
                return res;
            }
        }
        return res;
    }
}
