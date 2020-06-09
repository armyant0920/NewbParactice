package TestOfThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

//不斷產生隨機數量,不同顏色的正方,並隨時間移動及縮小,移動範圍不能超過邊框
//同樣默認是在Jpanel的基礎下做這個嘗試
//深深感覺到基礎功還不夠,抄別人的架構改很快,自己要完全新創花的時間也太長


public class BubblePanel extends JPanel implements KeyListener {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBubble(g, bubbles);
    }

    private Random rnd = new Random();
    private static final int WIDTH = 540;
    private static final int HEIGHT = 540;
    private static final int MAX_CREATE = 10;
    private static final int MAX_NUMS = 20;
    private static final int SPEED = 5;
    private ArrayList<Bubble> bubbles;

    private Canvas canvas;
    private Thread createBubble;

    public BubblePanel() {
        // createBubble = new Thread(new);

    }


    private void drawBubble(Graphics g, ArrayList<Bubble> bubbles) {
        for (Bubble b : bubbles) {
            g.drawRect(rnd.nextInt(WIDTH), rnd.nextInt(HEIGHT), rnd.nextInt(11) * 10, rnd.nextInt(11) * 10);//畫個正方
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    private class CreateBubbleThread extends Thread {
        public void run() {
            while (true) {

                repaint();

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

            }
        }
    }

    private class BubbleLife extends Thread {

        public void run() {


        }
    }

    private class Bubble {
        private int size;//大小
        private double positionX, positionY;//位置
        private int sleepTime;
        private double angle;
        private Color color;

        public Color getColor() {
            return color;
        }

        private Thread lifeThread;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public double getPositionX() {
            return positionX;
        }

        public void setPositionX(double positionX) {
            this.positionX = positionX;
        }

        public double getPositionY() {
            return positionY;
        }

        public void setPositionY(double positionY) {
            this.positionY = positionY;
        }

        public int getSleepTime() {
            return sleepTime;
        }

        public void setSleepTime(int sleepTime) {
            this.sleepTime = sleepTime;
        }

        public double getAngle() {
            return angle;
        }

        public void setAngle(double angle) {
            this.angle = angle;
        }

        public Bubble(int size, int positionX, int positionY, double angle, Color color) {
            this.size = size;
            this.positionX = positionX;
            this.positionY = positionY;
            this.angle = angle;
            this.color = color;
            lifeThread = new Thread(new LifeThread());

        }

        public void drawObject(Graphics g) {

        }

        private class LifeThread extends Thread {

            public void run() {
                if (size > 0) {
                    size = Math.max(size - 10, 0);
                    angle = (angle + rnd.nextInt(360)) % 360;
                    double moveX = SPEED * Math.cos(angle);
                    double moveY = SPEED * Math.sin(angle);
                    positionX += moveX;
                    positionY += moveY;


                }
                lifeThread.interrupt();


            }
        }


    }
}
