package com.leetcode.medium.heap_topk;

import java.util.PriorityQueue;

//#973
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        //[3,3],[5,-1],[-2,4]|2
        //new int[][]{{2, 2}, {-2, -2}, {2, -2}, {-2, 2}}|2
        //new int[][]{{1, 1}, {1, 1}, {2, 2}}|2
        //new int[][]{{0, 5}, {0, -2}, {3, 0}, {-1, 0}}|2
        //new int[][]{{10, 10}, {5, 5}, {1, 1}, {8, 8}}|1 -> is correct but result array formation is incorrect!!
        //new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}}|2
        //new int[][]{{5, 5}, {4, 4}, {3, 3}, {2, 2}}|2
        //new int[][]{{10, 10}, {5, 5}, {1, 1}, {8, 8}}|1
        int[][] result = kClosestOptimized(new int[][]{{10, 10}, {5, 5}, {1, 1}, {8, 8}},1);
        System.out.println(result[0][0] + "," + result[0][1]);
    }

    //check https://share.gemini.google/d2RDSMTbbI0J
    public static int[][] kClosestOptimized(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1,a2)->
                Integer.compare(a2[0]*a2[0] + a2[0]*a2[0],a1[0]*a1[0] + a1[0]*a1[0]));
        for(int[] point : points) {
            pq.offer(point);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        for(int i=0;i<k;i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((p1,p2)-> Double.compare(p2.distanceToOrigin(),p1.distanceToOrigin()));
        for(int[] point : points) {
            Point p = new Point(point[0],point[1]);
            pq.offer(p);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        int[][] res = new int[k][];
        for(int i=0;i<k;i++) {
            Point p = pq.poll();
            res[i] = new int[2];
            res[i][0] = p.getX();
            res[i][1] = p.getY();
        }
        return res;
    }

    static class Point {
        int x;
        int y;
        double distanceToOrigin;

        public Point(int x,int y) {
            this.x = x;
            this.y = y;
            distanceToOrigin = Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
        }

        public double distanceToOrigin() {
            return this.distanceToOrigin;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }
}
