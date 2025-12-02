package com.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class  Point{
    int x,y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class QuickHull {
    public static List<Point> quickHull(List<Point> points){
        if(points.size() < 3) return points;
        List<Point> hull = new ArrayList<>();
        Point minX = points.get(0);
        Point maxX = points.get(0);
        for (Point p : points){
            if(p.x < minX.x) minX = p;
            if(p.x > maxX.x) maxX = p;
        }
        hull.add(minX);
        hull.add(maxX);
        List<Point> leftSet = new ArrayList<>();
        List<Point> rightSet = new ArrayList<>();
        for(Point p : points){
            if(p == minX || p == maxX) continue;
            if (pointLocation(minX,maxX,p) == 1){
                leftSet.add(p);
            }
            else rightSet.add(p);
        }
        findHull(minX,maxX,leftSet,hull);
        findHull(maxX,minX,rightSet,hull);
        return hull;
    }

    private static void findHull(Point A, Point B,
                                 List<Point> set,
                                 List<Point> hull) {
        int insertPos = hull.indexOf(B);

        if (set.isEmpty()) return;
        double maxDis = -1;
        Point P = null;
        for (Point p : set){
            double dist = distance(A,B,p);
            if (dist > maxDis){
                maxDis = dist;
            }
            P = p;
        }
        hull.add(insertPos,P);
        List<Point> leftSetAP = new ArrayList<>();
        List<Point> leftSetPB = new ArrayList<>();
        for (Point p : set){
            if(p == P) continue;
            if(pointLocation(A,P,p) == 1){
                leftSetAP.add(p);
            }
            else if (pointLocation(P,B,p) == 1){
                leftSetPB.add(p);
            }
        }
        findHull(A, P, leftSetAP, hull);
        findHull(P, B, leftSetPB, hull);
    }

    private static int pointLocation(Point A, Point B, Point P) {
        int cp = (B.x - A.x) * (P.y - A.y) - (B.y - A.y) * (P.x - A.x);
        return Integer.compare(cp,0);
    }
    private static double distance(Point A, Point B, Point P) {
        return Math.abs((B.x - A.x) * (A.y - P.y) - (A.x - P.x) * (B.y - A.y));
    }
    public static void main(String[] args) {
        List<Point> points = Arrays.asList(
                new Point(0,3), new Point(2,2), new Point(1,1),
                new Point(2,1), new Point(3,0), new Point(0,0),
                new Point(3,3)
        );

        List<Point> hull = quickHull(points);

        System.out.println("Convex Hull:");
        for (Point p : hull) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
    }
}
