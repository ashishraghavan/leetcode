package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

//problem # 1232
//check https://github.com/doocs/leetcode/tree/main/solution/1200-1299/1232.Check%20If%20It%20Is%20a%20Straight%20Line
//for github solution
public class CheckIfItIsAStraightLine_L1232 {
    public static void main(String[] args) {
        //{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}
        //{6,7},{4,5},{3,4},{1,2},{5,6},{2,3}
        //{7,7},{4,5},{5,6},{2,2},{1,1},{3,4}
        //{2, 5}, {6, 10}, {10, 15}
        //{1, 2}, {3, 5}, {6, 9}
        //{7,7},{4,5},{5,6},{2,2},{1,1},{3,4}
        System.out.println(checkStraightLineII(new int[][]{{6,7},{4,5},{3,4},{1,2},{5,6},{2,3}}));
        //System.out.println(findSlope(6,10,10,15));
    }

    //{1,2},{2,3},{3,4},{4,5},{5,6},{6,7} -> all slopes have equal value = 1
    //{1,1},{2,2},{3,4},{4,5},{5,6},{7,7} -> unequal slopes
    //{1,1},{2,2},{4,4},{6,6},{8,8},{10,10} -> equal slope of 1
    //inefficient
    public static boolean checkStraightLine(int[][] coordinates) {
        double slope = findSlope(coordinates[0][0],coordinates[0][1],coordinates[1][0],coordinates[1][1]);
        for(int i = 0; i < coordinates.length; i++) {
            for(int j = i+1; j < coordinates.length; j++) {
                if(findSlope(coordinates[i][0],coordinates[i][1],coordinates[j][0],coordinates[j][1]) != slope) {
                    return false;
                }
            }
        }
        return true;
    }

    //TODO: doesn't work for case - [0,0],[0,1],[0,-1] all x coords are equal!
    public static boolean checkStraightLineII(int[][] coordinates) {
        List<List<Integer>> points = new ArrayList<>();
        for(int i =0; i < coordinates.length; i++) {
            List<Integer> point = new ArrayList<>();
            point.add(coordinates[i][0]);
            point.add(coordinates[i][1]);
            points.add(point);
        }
        List<List<Integer>> sortedPoints = points.stream().sorted(Comparator.comparing(l -> l.get(0))).collect(toList());
        double slope = findSlope(sortedPoints.get(0).get(0),sortedPoints.get(0).get(1),sortedPoints.get(1).get(0),sortedPoints.get(1).get(1));
        if(slope == -1) return false;
        for(int i = 0; i < sortedPoints.size()-1;i++) {
            if(findSlope(sortedPoints.get(i).get(0),sortedPoints.get(i).get(1),
                    sortedPoints.get(i+1).get(0),sortedPoints.get(i+1).get(1)) != slope) {
                return false;
            }
        }
        return true;
    }

    static double findSlope(int x1,int y1,int x2,int y2) {
        if(x2-x1 != 0) {
            return (double)(y2-y1)/(x2-x1);
        }
        return -1;
    }

}
