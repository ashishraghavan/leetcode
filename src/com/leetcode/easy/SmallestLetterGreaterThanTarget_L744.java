package com.leetcode.easy;

//problem # 744 - smallest letter greater than target
public class SmallestLetterGreaterThanTarget_L744 {
    public static void main(String[] args) {
        //'c','f','j' | 'a'
        //'c','f','j' | 'c'
        //'x','x','y','y' | 'z'
        System.out.println(nextGreatestLetter(new char[]{'x','x','y','y'},'z'));
    }

    //"c","f","j" | a
    //99, 102, 106 | 97
    //letters sorted in lexicographically asc. order
    //if 122 - letters[letters.length-1] < 122 - target ? return letters[0]
    //for i in (0:letters.length-1), if 122 - letters[i] > 122 - target return letters[i]
    public static char nextGreatestLetter(char[] letters, char target) {
        int targetCh = target - 'a';
        if(letters[letters.length-1] - 'a' < targetCh)return letters[0];
        for (char letter : letters) {
            if (letter - 'a' > targetCh) return letter;
        }
        return letters[0];
    }
}
