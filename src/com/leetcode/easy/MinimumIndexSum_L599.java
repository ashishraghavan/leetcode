package com.leetcode.easy;

import java.util.*;

//TODO: pending optimized solution
//problem #599 - minimum index sum
public class MinimumIndexSum_L599 {
    public static void main(String[] args) {
        //list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
        //list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["KFC","Shogun","Burger King"]
        //list1 = ["Shogun","Tapioca Express","Burger King","KFC"], list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"]
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"})));
    }

    //INEFFICIENT SOLUTION
    //list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
    //map:{happy:0,sad:1,good:2} min = Integer.MAX_VALUE,String ans; for i in (0,list2.length) if(map.containsKey(list2[i]) && i+map.get(list2[i)) < min) {min = i+j;ans = list2[i]}
    //map: {happy:}
    //find min. index sum first, populate ans after comparing indexes of strings in list1, list2
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map1 = new HashMap<>(list1.length);
        Map<String,Integer> map2 = new HashMap<>(list2.length);
        List<String> ans = new ArrayList<>();
        for(int i=0;i<list1.length;i++) {
            map1.put(list1[i],i);
        }
        for(int j=0;j<list2.length;j++) {
            map2.put(list2[j],j);
        }
        int min = Integer.MAX_VALUE;
        for(String word:map1.keySet()) {
            if(!map2.containsKey(word))continue;
            min = Math.min(map1.get(word)+map2.get(word),min);
        }
        for(String word : map1.keySet()) {
            if(!map2.containsKey(word))continue;
            if(map1.get(word)+map2.get(word) == min) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[0]);
    }
}
