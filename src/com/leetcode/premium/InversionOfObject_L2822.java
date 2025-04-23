package com.leetcode.premium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//problem # 2822 - !! IGNORE !!
//check https://github.com/doocs/leetcode/tree/main/solution/2800-2899/2822.Inversion%20of%20Object
//for
//more
//details
public class InversionOfObject_L2822 {
    public static void main(String[] args) {
        //System.out.println(invertArray(new String[]{"1", "2", "3", "4"}));
        Map<String,String> map = new HashMap<>();
//        map.put("a","1");
//        map.put("b","2");
//        map.put("c","2");
//        map.put("d","4");

        map.put("a","1");
        map.put("b","2");
        map.put("c","3");
        map.put("d","4");
        System.out.println(invertObj(map));
    }

    public static String[] invertArray(String[] S) {
        return S;
    }

    public static Map<String,Set<String>> invertObj(Map<String,String> map) {
        Map<String, Set<String>> result = new HashMap<>();
        for(String key:map.keySet()) {
            if(result.containsKey(map.get(key))) {
                Set<String> value = result.get(map.get(key));
                value.add(key);
                result.put(map.get(key),value);
            } else {
                Set<String> value = new HashSet<>();
                value.add(key);
                result.put(map.get(key),value);
            }
        }
        return result;
    }
}
