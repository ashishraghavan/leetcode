package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

//prob # 1496 - path crossing
public class PathCrossing_L1496 {
    public static void main(String[] args) {
        //NES
        //NESWW
        //NNSWWEWSSESSWENNW
        System.out.println(isPathCrossing("NNSWWEWSSESSWENNW"));
    }

    //initial : x=0,y=0
    //north - x,y++
    //east - x++,y
    //south - x,y--
    //west - x--,y
    public static boolean isPathCrossing(String path) {
        int i=0;
        Point point = new Point(0,0);
        Set<Point> s = new HashSet<>();
        s.add(point);
        while(i < path.length()) {
            char ch = path.charAt(i);
            switch(ch) {
                case 'N':
                    point.setX(point.getX());
                    point.setY(point.getY()+1);
                    break;
                case 'E':
                    point.setX(point.getX()+1);
                    point.setY(point.getY());
                    break;
                case 'S':
                    point.setX(point.getX());
                    point.setY(point.getY()-1);
                    break;
                case 'W':
                    point.setX(point.getX()-1);
                    point.setY(point.getY());
                    break;
            }
            if(s.contains(point))return true;
            s.add(point);
            i++;
        }
        return false;
    }
}
