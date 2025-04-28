package com.leetcode.premium;

//TODO: pending
public class ShortestWordDistance_L243 {
    public static void main(String[] args) {
        //shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},"coding","practice")
        //{"practice", "makes", "perfect", "coding", "makes"}, "makes","coding"
        System.out.println(shortestWordDistanceBruteForce(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes","coding"));
    }

    public static int shortestWordDistance(String[] W,String w1,String w2) {
        //i = 0, j = W.length-1
        //if W[i].equals(w1) && W[j].equals(w2) || W[i].equals(w2) && W[j].equals(w1) -> dist = abs(j-i+1)
        //else if W[i].equals(w1) && !W[j].equals(w2) j--
        //else if !W[i].equals(w1) && W[j].equals(w2) i++
        //else if neither equals w1 or w2, i++, j-- continue
        //dry run ->


        //{-1,1,-1,2,1}

        //map = {practice:0,makes:1,perfect:2,coding:3,makes:4}
        //for each word in W, if not in map, map.put(word,idx)
        //          String curr = word;
        //          other = word.equals(w1) ? w2:w1;
        //          if(map.contains(other)) {
        //              dist = min(dist,abs(map.get(other)-map.get(curr)));
        //          }
        return -1;
    }

    public static int shortestWordDistanceBruteForce(String[] W,String w1, String w2) {
        int dist = Integer.MAX_VALUE;
        for(int i=0;i<W.length;i++) {
            if(W[i].equals(w1) || W[i].equals(w2)) {
                for(int j=i+1;j<W.length;j++) {
                    if(W[j].equals(w1) || W[j].equals(w2) && (!W[j].equals(W[i]))) {
                        dist = Math.min(dist, j-i);
                    }
                }
            }
        }
        return dist;
    }
}
