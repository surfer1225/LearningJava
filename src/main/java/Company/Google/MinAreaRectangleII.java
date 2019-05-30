package main.java.Company.Google;

import java.util.*;
​
/*
963. Minimum Area Rectangle II
​
Given a set of points in the xy-plane, determine the minimum area of any rectangle formed from these points,
with sides not necessarily parallel to the x and y axes.
If there isn't any rectangle, return 0.
​
Input: [[1,2],[2,1],[1,0],[0,1]]
Output: 2.00000
Explanation: The minimum area rectangle occurs at [1,2],[2,1],[1,0],[0,1], with an area of 2.
​
Input: [[0,1],[2,1],[1,1],[1,0],[2,0]]
Output: 1.00000
Explanation: The minimum area rectangle occurs at [1,0],[1,1],[2,1],[2,0], with an area of 1.
​
Input: [[0,3],[1,2],[3,1],[1,3],[2,1]]
Output: 0
Explanation: There is no possible rectangle to form from these points.
 */
public class MinAreaRectangleII {
    /*
    1. backtrack to traverse
    2. when there are 3, check if it is possible
     */
    private double min = 0;
​
    class Pair {
        int x;
        int y;
​
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
​
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Pair)) return false;
            if (o == this) return true;
​
            Pair another = (Pair) o;
            return another.x == this.x && another.y == this.y;
        }
​
        @Override
        public int hashCode() {
            return this.x * 4001 + this.y * 31;
        }
    }
​
    class AreaPairHelper {
        Pair pair;
        double area;
​
        public AreaPairHelper(Pair pair, double area) {
            this.pair = pair;
            this.area = area;
        }
    }
​
    public double minAreaFreeRect(int[][] points) {
        Set<Pair> pointSet = new HashSet<>();
        for (int[] point : points) {
            pointSet.add(new Pair(point[0],point[1]));
        }
​
        backtrack(points, 0, pointSet, new ArrayList<>());
​
        return min;
    }
​
    private void backtrack(int[][] points, int start, Set<Pair> pointSet, List<Pair> acc) {
        //base condition
        if (acc.size()>2) return;
        if (acc.size() == 2) {
            Pair a = acc.get(0);
            Pair b = acc.get(1);
            for (int i = start; i < points.length; i++) {
                Optional<AreaPairHelper> d = getLastPairAndAreaInRectangle(a, b, new Pair(points[i][0],points[i][1]));
                if (d.isPresent() && pointSet.contains(d.get().pair)) min = (min==0?d.get().area:Math.min(min, d.get().area));
            }
        }
        else {
            for (int i = start; i < points.length; i++) {
                acc.add(new Pair(points[i][0],points[i][1]));
                backtrack(points,i+1,pointSet,new ArrayList<>(acc));
                acc.remove(acc.size()-1);
            }
        }
    }
​
    private Optional<AreaPairHelper> getLastPairAndAreaInRectangle(Pair a, Pair b, Pair c) {
        Optional<AreaPairHelper> areaPairHelper = getLastPairAndAreaInRectangleHelper(a,b,c);
        if (areaPairHelper.isPresent()) return areaPairHelper;
​
        areaPairHelper = getLastPairAndAreaInRectangleHelper(b,a,c);
        if (areaPairHelper.isPresent()) return areaPairHelper;
​
        areaPairHelper = getLastPairAndAreaInRectangleHelper(c,a,b);
        if (areaPairHelper.isPresent()) return areaPairHelper;
​
        return Optional.empty();
    }
​
    /**
     *
     * @param a: point a
     * @param b: point b
     * @param c: point c
     * @return null is invalid, pair if valid
     */
    private Optional<AreaPairHelper> getLastPairAndAreaInRectangleHelper(Pair a, Pair b, Pair c) {
        if (Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2)+Math.pow(a.x-c.x,2)+Math.pow(a.y-c.y,2)==
                Math.pow(c.x-b.x,2)+Math.pow(c.y-b.y,2)) {
            //a is the right angle in the triangle
            double area = Math.sqrt((Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2))*(Math.pow(a.x-c.x,2)+Math.pow(a.y-c.y,2)));
            Pair d = new Pair(c.x - a.x + b.x, c.y - a.y + b.y);
            return Optional.of(new AreaPairHelper(d, area));
        }
​
        return Optional.empty();
    }
​
    public static void main(String[] args) {
        MinAreaRectangleII m = new MinAreaRectangleII();
        System.out.println(m.minAreaFreeRect(new int[][]{{1,2},{2,1},{1,0},{0,1}}));
        m = new MinAreaRectangleII();
        System.out.println(m.minAreaFreeRect(new int[][]{{0,1},{2,1},{1,1},{1,0},{2,0}}));
        m = new MinAreaRectangleII();
        System.out.println(m.minAreaFreeRect(new int[][]{{0,3},{1,2},{3,1},{1,3},{2,1}}));
    }
}
