package com.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

//TODO: pending
public class LongPressedName_L925 {
    public static void main(String[] args) {
        //name = "alex", typed = "aaleex"
        //name = "saeed", typed = "ssaaedd"
        //ashish, asshhhishh
        //rick, kric
        System.out.println(isLongPressedNameII("alex","aaleex"));
    }

    //ashish -> a1s2h2i1, asshhhishh -> a1s3h5i1
    //ashish, aaashhhisshh -> a3s1h3i1s2h2
    public static boolean isLongPressedName(String name, String typed) {
        //name = "alex", typed = "aaleex"
        //a=2,l=1,e=2.x=1 should also be in the same order as name

        //name = "alex", typed = "aaleex", return true
        //name = "xela", typed = "aaleex", return false
        //how to make sure if order is maintained?
        return false;
    }

    public static boolean isLongPressedNameIII(String name, String typed) {
        LinkedHashMap<Character,Long> typedFreq = typed.chars().mapToObj(ch->(char)ch).collect(groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Long> entry : typedFreq.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue());
        }
        System.out.println(sb);
        System.out.println(typedFreq);
        for(int i = 0,j=0; i < name.length(); i++,j+=2) {
            if(name.charAt(i) != sb.charAt(j) && (j+1 < sb.length() && sb.charAt(j+1) < name.charAt(i)))return false;
        }
        return true;
    }

    //ashish -> a=1,s=2,h=2,i=1, asshhhishh -> a=1,s=3,h=5,i=1
    public static boolean isLongPressedNameII(String name,String typed) {
        LinkedHashMap<Character,Long> nameFreq = name.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        LinkedHashMap<Character,Long> typedFreq = typed.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));
        if(nameFreq.size() != typedFreq.size()) return false;
        Object[] typedKeyArray = typedFreq.entrySet().toArray();
        System.out.println(Arrays.toString(typedKeyArray));
        System.out.println(nameFreq);
        for(int i=0;i<name.length();i++) {
            Character ch = name.charAt(i);
            if(ch != typedKeyArray[i] || (!typedFreq.containsKey(ch)) || (typedFreq.get(ch) < nameFreq.get(ch)))return false;
        }
        return true;
        //        for(Character ch : nameFreq.keySet()) {
//            if(!typedFreq.containsKey(ch) || typedFreq.get(ch) < nameFreq.get(ch))return false;
//        }
    }
}
