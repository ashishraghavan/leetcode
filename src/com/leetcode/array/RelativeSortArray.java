package com.leetcode.array;

import java.util.*;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 * TODO : Make this run faster. numberIndexList can be removed.
 */
public class RelativeSortArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }

    static int[] relativeSortArray(int[] arr1, int[] arr2) {
        //We need to preserve its order.
        Map<Integer, List<Integer>> numberIndexList = new HashMap<>();
        List<Integer> arr1List = new ArrayList<>();
        List<Integer> arr2List = new ArrayList<>(arr2.length);
        //all elements in arr1 not present in arr2
        List<Integer> arr1RemainingList = new ArrayList<>();
        List<Integer> sortedList = new ArrayList<>();
        //Copy all elements of arr1 to a list
        for (int item : arr1) {
            arr1List.add(item);
        }
        //copy all elements of arr2 to list
        for (int value : arr2) {
            arr2List.add(value);
        }
        //Remove all elements not present in arr2 and put in arr1RemainingList
        ListIterator<Integer> arr1Iterator = arr1List.listIterator();
        while (arr1Iterator.hasNext()) {
            Integer arr1Number = arr1Iterator.next();
            if (arr2List.contains(arr1Number)) {
                //update index list against number
                List<Integer> indexList;
                if (numberIndexList.containsKey(arr1Number)) {
                    indexList = numberIndexList.get(arr1Number);
                } else {
                    //put in map with arr1Number -> index
                    indexList = new ArrayList<>();
                }
                indexList.add(arr1Number);
                numberIndexList.put(arr1Number, indexList);
            } else {
                arr1RemainingList.add(arr1Number);
                arr1Iterator.remove();
            }
        }
        //arr1List now contains all elements present in arr2
        //arr1RemainingList contains all elements present in arr1 but not in arr2
        for (Integer number : arr2List) {
            if (numberIndexList.containsKey(number)) {
                sortedList.addAll(numberIndexList.get(number));
            }
        }
        Collections.sort(arr1RemainingList);
        sortedList.addAll(arr1RemainingList);
        int[] sortedArray = new int[sortedList.size()];
        int count = 0;
        for (Integer sortedNumber : sortedList) {
            sortedArray[count++] = sortedNumber;
        }
        return sortedArray;
    }
}

