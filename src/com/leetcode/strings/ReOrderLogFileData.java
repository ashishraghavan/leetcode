package com.leetcode.strings;

import java.util.*;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 *
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 *
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 *
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 *
 * Return the final order of the logs.
 *
 * USE COMPARATOR CLASS : Comparator strComparator = new Comparator<String> {
 *      @Override
 *      public int compare(String s1,String s2) {
 *
 *      }
 * }
 */
public class ReOrderLogFileData {
    public static void main(String[] args) {
        //"let1 art can"
        //"let2 own kit dig",
        //"let3 art zero"
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{
                "dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"
        })));//=> [let1 art can,let3 art can,dig1 8 1 5 1,dig2 3 6]
    }

    static String[] reorderLogFiles(String[] logs) {
        List<String> digitLogList = new ArrayList<>();
        List<String> letterLogList = new ArrayList<>();
        Map<String,String> letterMap = new HashMap<>();
        for(String log : logs) {
            String[] splitLogs = log.split(" ");
            //decide if subsequent characters are digits or letters.
            //at least one word after identifier.
            //splitLogs[0] is the identifier
            //splitLogs[1].charAt(0) will tell us if subsequent characters
            //are letters or numbers
            if(Character.isDigit(splitLogs[1].charAt(0))) {
                //digit-log
                digitLogList.add(log);
            } else if(Character.isLetter(splitLogs[1].charAt(0))) {
                //letter-log
                if(letterMap.containsKey(log.substring(log.indexOf(" ")))) {
                    //probably not going to be just one duplicate string
                    String value = letterMap.get(log.substring(log.indexOf(" ")));
                    //sort identifiers lexicographically, then copy entire string
                    //past the identifier.
                    String value2 = splitLogs[0];
                    final String e = value2 + log.substring(log.indexOf(" "));
                    final String e1 = value + log.substring(log.indexOf(" "));
                    if(value.compareTo(value2) < 0) {
                        letterLogList.add(e1);
                        letterLogList.add(e);
                    } else {
                        letterLogList.add(e);
                        letterLogList.add(e1);
                    }
                } else {
                    //put string after identifier as key and identifier as value.
                    //because we did not find any duplicate.
                    letterMap.put(log.substring(log.indexOf(" ")),splitLogs[0]);
                }

            }
        }
        //Sort letterMap values lexicographically

        //list to array
        String[] logArray = new String[letterLogList.size() + digitLogList.size()];
        int count = 0;
        for(String word : letterLogList) {
            logArray[count++] = word;
        }
        for(String word : digitLogList) {
            logArray[count++] = word;
        }
        return logArray;
    }
}
