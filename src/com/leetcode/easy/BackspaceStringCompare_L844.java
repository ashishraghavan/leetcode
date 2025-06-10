package com.leetcode.easy;

//problem #844 - backspace string compare
public class BackspaceStringCompare_L844 {
    public static void main(String[] args) {
        //s = "ab#c", t = "ad#c"
        //s = "ab##", t = "c#d#"
        //s = "a#c", t = "b"
        //shit####bag, baghouse#####
        //basedoll####p#er##ti#n#ent, basel#ine###sen###ti#m#ent
        //h##u###ma#noid, h####um##a#nodi
        System.out.println(backspaceCompare("h##u###ma#noid","h####um##a#noid"));
    }

    //start from end for s,t. If either runs out of characters, return false
    //if curr. char = # for s or t, increment count
    public static boolean backspaceCompare(String s, String t) {
        StringBuilder sbS = new StringBuilder();
        StringBuilder stS = new StringBuilder();
        int hashCt = 0;
        for(int i=s.length()-1;i>=0;i--) {
            if(s.charAt(i) == '#') {
                hashCt++;
                continue;
            }
            if(hashCt > 0) {
                --hashCt;
                continue;
            }
            sbS.append(s.charAt(i));
        }

        hashCt = 0;
        for(int j=t.length()-1;j>=0;j--) {
            if(t.charAt(j) == '#') {
                hashCt++;
                continue;
            }
            if(hashCt > 0) {
                --hashCt;
                continue;
            }
            stS.append(t.charAt(j));
        }
        System.out.println(sbS);
        System.out.println(stS);
        return sbS.toString().contentEquals(stS.toString());
    }
}
