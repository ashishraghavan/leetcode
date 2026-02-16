package com.algomonster.problems.heap;

import java.util.*;

//TODO: https://algo.monster/problems/kth_smallest_element_in_a_sorted_matrix,
// solution similar to merge k sorted lists under section priority queue. CHECK LAST SOLUTION IN THE GIVEN LINK FOR MOST OPTIMIZED SOLUTION
public class KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        //[ 1,  5,  9], [10, 11, 13], [12, 13, 15]
        //[[1, 2], [1, 3]]  ,Arrays.asList(12, 13, 15))
        //[[-10, -5, 0], [1, 2, 3], [4, 5, 6]]
        //[[1, 2, 3], [4, 5, 6], [7, 8, 9]]
        //3, 3 5 6 , 5 7 8, 8 9 10
        //5, 1 2 4 7 11, 3 5 8 12 16, 6 9 13 17 20, 10 14 18 21 23, 15 19 22 24 25
        //1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25
        //Arrays.asList(Arrays.asList(1,2,4,7,11),Arrays.asList(3,5,8,12,16),Arrays.asList(6,9,13,17,20),Arrays.asList(10,14,18,21,23),Arrays.asList(15,19,22,24,25)),17)
        //Arrays.asList(Arrays.asList(1,5,9),Arrays.asList(10,11,13),Arrays.asList(12,13,15)),6)
        //Arrays.asList(Arrays.asList(3,5,6),Arrays.asList(5,7,8),Arrays.asList(8,9,10)),3)
        //Arrays.asList(Arrays.asList(2,3,5,19,47),Arrays.asList(7,13,17,37,61),Arrays.asList(11,23,29,67,83),Arrays.asList(31,43,53,73,89),Arrays.asList(41,59,79,93,97)),11)
        System.out.println(kthSmallestII(Arrays.asList(Arrays.asList(2,3,5,19,47),Arrays.asList(7,13,17,37,61),Arrays.asList(11,23,29,67,83),Arrays.asList(31,43,53,73,89),Arrays.asList(41,59,79,93,97)),11));
    }

    //priority queue with reverse order comparator & size limited to k, return first element as result
    //pq- {1,5,9,10,11,12,13,13}
    public static int kthSmallest(List<List<Integer>> matrix, int k) {
        SizeLimitedPriorityQueue spq = new SizeLimitedPriorityQueue(Comparator.naturalOrder(),k);
        int cnt = 0;
        for (int i=0;i<matrix.size();i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                spq.add(matrix.get(i).get(j));
                //if (cnt == k) {
                    //break;
                //}
                //spq.add(matrix.get(i).get(j));
                //cnt++;
            }
        }
        while(!spq.isEmpty()) {
            System.out.print(spq.poll() + " ");
        }
        return -1;
    }


    //5
    //1 2 4 7 11
    //3 5 8 12 16
    //6 9 13 17 20
    //10 14 18 21 23
    //15 19 22 24 25

    //somewhat better solution using priority queue of size limited to matrix.size() i.e. size of a row
    public static int kthSmallestII(List<List<Integer>> matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(comparator);
        for(int i=0;i<matrix.size();i++) {
            Tuple tuple = new Tuple(i,0,matrix.get(i).get(0));
            pq.offer(tuple);
        }
        int l=1;
        int size = matrix.size();
        int res=-1;
        while(!pq.isEmpty() && l <= k) {
            Tuple tuple = pq.poll();
            res = tuple.val;
            int next = tuple.getCol()+1;
            if(next < size) {
                //increment column in tuple
                tuple.setCol(next);
                tuple.setVal(matrix.get(tuple.row).get(tuple.col));
                pq.offer(tuple);
            }
            l++;
        }
        //pq should never be empty at this point
        return res;
    }

    static Comparator<Tuple> comparator = Comparator.comparingInt(tpq -> tpq.val);

    //TODO: this is not needed!
    static class SizeLimitedPriorityQueue {
        final PriorityQueue<Integer> pq;
        final int limit;

        public SizeLimitedPriorityQueue(Comparator<? super Integer> comparator,int limit) {
            this.pq = new PriorityQueue<>(comparator);
            this.limit = limit;
        }

        public void add(Integer element) {
            if(this.pq.size() < limit) {
                this.pq.offer(element);
            } else if(this.pq.comparator().compare(element,this.pq.peek()) > 0) {
                this.pq.poll();
                this.pq.offer(element);
            }
        }

        public int size() {
            return this.pq.size();
        }

        public Integer poll() {
            return this.pq.poll();
        }

        public boolean isEmpty() {
            return this.pq.isEmpty();
        }
    }

    static class Tuple {
        int row;
        int col;
        int val;

        public Tuple() {}

        public Tuple(int row,int col,int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
