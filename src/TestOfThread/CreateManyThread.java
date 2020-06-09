package TestOfThread;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class CreateManyThread {
    private static final int MAX_SIZE = 10;//最大檢查數,超過這個值不新增
    private static final int MAX_ADD = 2;//一次最大增加數
    private static final int MAX_LIFE = 10;//最長存活時間
    private static final int MAX_RADIUS = 100;
    private static final int MAX_DELAY = 5;
    private static int circleID = 0;
    private static ArrayList<Circle> circles = new ArrayList<>();
    private static Thread myThread;
    private static CreateCircle createCircle;


    public static void main(String[] args) {
//        int increase = getNum();
//        while (increase < MAX_ADD) {
//            System.out.println(increase + "!=");
//            increase = getNum();
//        }
//        System.out.println(increase);
        createCircle = new CreateCircle();
        myThread = new Thread(createCircle);
        myThread.start();


    }


    static class CreateCircle implements Runnable {
        @Override
        public void run() {


            while (true) {
                try {

                    SimpleDateFormat sd = new SimpleDateFormat("hh:mm:ss");
                    Date date = new Date();
                    System.out.println(sd.format(date));

                    if (circles.size() <= MAX_SIZE) {
                        int increase = 1 + (int) (Math.random() * MAX_ADD);
                        while (increase > 0) {

                            Random rnd = new Random();
                            increase--;

                            int radius = 1 + rnd.nextInt(MAX_RADIUS);
                            Color color = new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                            int lifetime = 1 + rnd.nextInt(MAX_LIFE);
                            circleID++;
                            Circle c = new Circle(radius, color, lifetime);
                            circles.add(c);

                        }
                        System.out.println("Create circle,sizeNow=" + circles.size());
                        System.out.println();
                    }

                    Thread.sleep((1 + (int) (Math.random() * MAX_DELAY)) * 1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class Circle {
        private int circleName;
        private int radius;
        private Color color;
        private int lifeTime;
        private CircleRun circlerun = new CircleRun();

        private Thread lifeThread = new Thread(circlerun);

        public Circle(int radius, Color color, int lifeTime) {
            this.circleName = circleID;
            this.radius = radius;
            this.color = color;
            this.lifeTime = lifeTime;
            lifeThread.start();

        }

        public void removeFromGroup() {
            circles.remove(this);
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "circleID=" + circleName +
                    ", Color=" + color +
                    ", lifeTime=" + lifeTime +
                    ", lifeThread=" + lifeThread +
                    '}';
        }

        public double getArea() {
            return radius * radius * Math.PI;

        }

        class CircleRun implements Runnable {
            @Override
            public void run() {


                while (lifeTime > 0) {
                    try {
                        lifeTime--;
                        if (lifeTime <= 0) {


                        }
                        System.out.println(Circle.this.toString());
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                removeFromGroup();
                System.out.println("removeCircle,sizeNow=" + circles.size());
            }
        }
    }
    String select="select * from exam3";
    Connection conn;



}



