package com.leetcode.premium;

import java.util.HashMap;
import java.util.Map;

//TODO: review, IMPORTANT!
//check https://github.com/doocs/leetcode/tree/main/solution/0200-0299/0243.Shortest%20Word%20Distance
//for
//more
//details
public class ShortestWordDistance_L243 {
    public static void main(String[] args) {
        //shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"},"coding","practice")
        //{"practice", "makes", "perfect", "coding", "makes"}, "makes","coding"
        //{"practice", "ashish", "perfect", "coding", "minu","perfect","minu","perfect","ashish","minu"}, "ashish","minu"
        System.out.println(shortestWordDistance(new String[]{"practice", "ashish", "perfect", "coding", "minu","perfect","minu","perfect","ashish","minu"}, "ashish","minu"));
    }

    //incorrect solution!!! doesn't work for all test cases
    public static int shortestWordDistance(String[] W,String w1,String w2) {
        //i = 0, j = W.length-1
        //if W[i].equals(w1) && W[j].equals(w2) || W[i].equals(w2) && W[j].equals(w1) -> dist = abs(j-i+1)
        //else if W[i].equals(w1) && !W[j].equals(w2) j--
        //else if !W[i].equals(w1) && W[j].equals(w2) i++
        //else if neither equals w1 or w2, i++, j-- continue
        //dry run ->


        //{-1,1,-1,2,1}

        //map = {practice:0,makes:1,perfect:2,coding:3,makes:4}
        //{makes:1}
        //{makes:1,}
        //{makes:1,coding:3}
        //{makes:1,coding:3}
        //for each word in W
        //          if(!word.equals(w1) && !word.equals(w2)) continue;
        //          if word not in map {
        //              map.put(word,indexOf(word))
        //          }
        //          String curr = word;
        //          other = word.equals(w1) ? w2:w1;
        //          if(map.contains(other)) {
        //              int curDist = abs(map.get(other)-map.get(curr);
        //              if curDist < dist {
        //                  dist = curDist;
        //                  //update
        //                  map.put(curr,indexOf(curr));
        //              }
        //          }

        //"practice", "makes", "perfect", "coding", "makes"}, "makes","coding"
        //{makes:1,coding:3}
        Map<String,Integer> map = new HashMap<>();
        int curDist,dist = Integer.MAX_VALUE;
        for(int i=0;i<W.length;i++) {
            if (!W[i].equals(w1) && !W[i].equals(w2)) {
                continue;
            }
            if (!map.containsKey(W[i])) {
                map.put(W[i],i);
            }
            String curr = W[i];
            String other = curr.equals(w1) ? w2 : w1;
            if(map.containsKey(other)) {
                curDist = Math.abs(map.get(other) - i);
                if(curDist < dist) {
                    dist = curDist;
                    map.put(curr,i);
                }
            }
        }
        return dist;
    }

    //inefficient
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
