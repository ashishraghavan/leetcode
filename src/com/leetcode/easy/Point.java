package com.leetcode.easy;

//used in PathCrossing_L1496.java
public class Point {
    private int x;
    private int y;

    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object point) {
        if(!(point instanceof Point))return false;
        Point that = (Point)point;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
