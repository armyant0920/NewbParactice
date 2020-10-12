package Simulatuon;

import java.awt.*;

public class Collision {


    Point point1;
    Point point2;
    int r1;
    int r2;


    public static boolean check(Point p1, int r1, Point p2, int r2) {

        double diff = Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
        return diff < (r1 + r2) ? true : false;




    }


}