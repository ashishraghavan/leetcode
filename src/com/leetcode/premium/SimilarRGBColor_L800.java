package com.leetcode.premium;

//TODO: review usage of Integer.parseInt(String,int radix) where radix = 2(binary), 8(octal), 10(decimal), 16(hexadecimal)..max of 36 (not all intermediate values might be correct)
// and String.format(String,Object...args)
// is mainly concerned with character manipulation -- need to know Character class thoroughly
//problem # 800
//check https://github.com/doocs/leetcode/tree/main/solution/0800-0899/0800.Similar%20RGB%20Color
//for
//more
//details
public class SimilarRGBColor_L800 {
    public static void main(String[] args) {
        //#09f166
        //#4e3fe1
        //System.out.println(similarRGBColor(""));
        System.out.println(Integer.parseInt("09",16));
    }

    //ascii a = 97, b = 98, c = 99, d = 100, e = 101, f = 102 ....z = 122
    public static String similarRGBColor(String S) {
        //#09f166 -> 09f166
        //hexadecimal digits, radix = 16
        //StringBuilder sb = ""
        //for i=1;i<S.length;i=i+2
        //  if Character.isDigit(S.charAt(i))
        //      if '9' ch = Character.digit(S.charAt(i),10) else ch = sb.append("11") else
        return "";
    }
}
