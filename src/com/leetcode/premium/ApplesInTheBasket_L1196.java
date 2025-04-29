package com.leetcode.premium;

import java.util.Arrays;

//problem # 1196 - apples in the basket
//check https://github.com/doocs/leetcode/tree/main/solution/1100-1199/1196.How%20Many%20Apples%20Can%20You%20Put%20into%20the%20Basket
//for
//more
//details
public class ApplesInTheBasket_L1196 {
    public static void main(String[] args) {
        //100,200,150,1000
        //900,950,800,1000,700,800 -sort-> 700,800,800,900,950,1000
        //250,50,100,300,210,1200,10 -sort-> 10,50,100,210,250,300,1200
        System.out.println(applesInBasket(new int[]{4000,50,2000,300,210,1500,3000}));
    }

    public static int applesInBasket(int[] A) {
        int apples = 0;
        int total = 0;
        int max = 5000;
        Arrays.sort(A);
        for (int j : A) {
            if (total + j > max) {
                break;
            }
            total += j;
            ++apples;
        }
        return apples;
    }
}
