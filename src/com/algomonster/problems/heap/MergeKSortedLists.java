package com.algomonster.problems.heap;

import java.util.*;

//https://algo.monster/problems/merge_k_sorted_lists
//TODO: [revise], referred solution!
public class MergeKSortedLists {
    public static void main(String[] args) {
        //Arrays.asList(Arrays.asList(1,2),Arrays.asList(3,3),Arrays.asList(2,2)
        //                ,Arrays.asList(-4,0),Arrays.asList(-2,-4),Arrays.asList(3,1),Arrays.asList(0,4),Arrays.asList(5,7),Arrays.asList(-1,-1))
        //[1, 3, 5],[2,4,6],[7,10]
        List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 3, 5),Arrays.asList(2,4,6),Arrays.asList(7,10));
        System.out.println(mergeKSortedListsII(list));
    }

    //unoptimized version!!
    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(List<Integer> list : lists) {
            for(Integer elem : list) {
                pq.offer(elem);
            }
        }
        while(!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }

    //[1, 3, 5],[2,4,6],[7,10]
    //pq = {1,2,7}
    //pq = {[1,{1,3,5},0],[2,{2,4,6},0],[7,{7,10},0]}
    //pq = {[2,{2,4,6},0],[1,{3,5},1],[7,{7,10},0]}, res={1,}
    //pq = {[1,{3,5},1],[2,{4,6},1],[7,{7,10},0]}, res={1,2,}
    //pq = {[2,{4,6},1],[1,{5},2],[7,{7,10},0]}, res={1,2,3,}
    //pq = {[5,{},3],[6,{6},2],[7,{7,10},0]}, res={1,2,3,4,5,}
    //pq = {[7,{7,10},0]}, res={1,2,3,4,5,6,}
    //[1, 3, 5],[2,4,6],[7,10]
    //optimized version after referring solution!
    public static List<Integer> mergeKSortedListsII(List<List<Integer>> lists) {
        PriorityQueue<Element> pq = new PriorityQueue<>(elementComparator);
        List<Integer> res = new ArrayList<>();
        for(List<Integer> list : lists) {
            Element element = new Element(list,0);
            pq.offer(element);
        }
        while(!pq.isEmpty()) {
            Element element = pq.poll();
            res.add(element.getCurrList().get(element.getIdx()));
            int next = element.getIdx() + 1;
            if(next < element.getCurrList().size()) {
                element.setIdx(next);
                pq.offer(new Element(element.getCurrList(),next));
            }
        }
        return res;
    }

    static Comparator<Element> elementComparator = Comparator.comparing(e -> e.getCurrList().get(e.getIdx()));

    static class Element {
        int idx;
        List<Integer> currList;

        public Element(List<Integer> currList, int idx) {
            this.currList = currList;
            this.idx = idx;
        }

        public List<Integer> getCurrList() {
            return currList;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }
    }
}
