package com.leetcode.premium;

public class ValidWordSquare {
    public static void main(String[] args) {
        //new String[]{"abcd","bnrt","crmy","dtye"}
        //new String[]{"ball","area","read","lady"}
        //new String[]{"abcd","bnrt","crm","dt"}
        //new String[]{"abcd","boya","cy","da"}
        //new String[]{"abd","boya","cy","d"}
        //new String[]{"a","b","c","d"}
        System.out.println(isValidWordSquare(new String[]{"a","b","c","d"}));
    }

    //    1 <= words.length <= 500
//    1 <= words[i].length <= 500
//    words[i] consists of only lowercase English letters.
    public static boolean isValidWordSquare(String[] words) {
        int j;
        for (int i = 0; i < words.length; i++) {
            String hWord = words[i];
            j = i;
            for (int k = 0; k < hWord.length(); k++) {
                if (j >= words[k].length()) {
                    return false;
                }
                //0th char of hWord = 0th char of words[0]
                //1st char of hWord = 0th char of words[1]
                //2nd char of hWord = 0th char of words[2]
                //3rd char of hWord = 0th char of words[3]
                if (hWord.charAt(k) != words[k].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
