package com.leetcode.premium;

import java.util.HashMap;
import java.util.Map;

//problem # 734
//Check
// https://github.com/doocs/leetcode/blob/main/solution/0700-0799/0734.Sentence%20Similarity/README_EN.md
// for more details
public class SentenceSimilarity_L734 {
    public static void main(String[] args) {
        String[] sen1 = new String[]{"great","acting","skills"};
        String[] sen2 = new String[]{"fine","drama","talent"};
        //String[][] pairs = {{"great","fine"},{"drama","acting"},{"skills","talent"}};
        String[][] pairs = {{"great","fine"},{"drama","acting"},{"skills","talent"}};
        System.out.println(isSimilar(sen1,sen2,pairs));
    }

    public static boolean isSimilar(String[] sen1,String[] sen2,String[][] pairs) {
        return sen1.length == sen2.length && helpMe(sen1,sen2,pairs);
    }

    public static boolean helpMe(String[] sen1,String[] sen2,String[][] pairs) {
        //sen1[0] == sen2[0]
        //sen1[1] == sen2[1]
        //sen1[2] == sen2[2]
        //sen1[0] == sen2[0]
        //sen1[0] == sen2[0]
        int ct = 0;
        for(;ct<sen1.length;ct++) {
            if(!sen1[ct].contentEquals(sen2[ct])) {
                break;
            }
        }
        if(ct >= sen1.length) {
            //all words in sen1, sen2 are same
            return true;
        }
        //Map<String,Integer> {great:1,acting:1,skills:1,fine:1,drama:1,talent:1}
        //Map<String,String> : {great:fine, acting:drama, skills:talent}
        Map<String,String> mp = new HashMap<>();
        for(int i=0;i<sen1.length;i++) {
            mp.put(sen1[i],sen2[i]);
        }
        //Set<Map.Entry<String,String>> entrySet = mp.entrySet();
        for(int i = 0; i < pairs.length; i++) {
            for(int j = 0; j < pairs[i].length; j++) {
                if((mp.containsKey(pairs[i][0]) && !mp.get(pairs[i][0]).contentEquals(pairs[i][1])) ||
                        (mp.containsKey(pairs[i][1]) && !mp.get(pairs[i][1]).contentEquals(pairs[i][0]))) {
                    return false;
                }
            }
        }
        return true;
    }
}
