package LeetCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EnumTest extends JFrame  {

    public  EnumTest() {
            setTitle("GameMap Test");
            MyPanel panel = new MyPanel();

            Container contentPane = getContentPane();

            contentPane.add(panel);
            pack();
        }
    public static void main(String[] args) {



        EnumTest test = new EnumTest();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.setVisible(true);
//     Scanner input=new Scanner(System.in);
//
//        playAction(Action.left);

    }



    static void playAction(Action action) {

        String s = "";
        switch (action) {
            case up:
                s = "up";
                break;
            case right:
                s = "right";
                break;
            case down:
                s = "down";
                break;
            case left:
                s = "left";
                break;

        }
        System.out.println(s);

    }





    public enum Action {

        up, right, down, left
    }

    static class MyPanel extends JPanel implements KeyListener {
        public MyPanel(){
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();

        setPreferredSize(d);
        setFocusable(true);
        addKeyListener(this);
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            // 獲得按鍵編號

            int keyCode = e.getKeyCode();
           /* System.out.println(e.getKeyCode());
            System.out.println(e.getWhen());
            System.out.println(e.paramString());
            System.out.println(e.toString());
            System.out.println(e.getKeyText(keyCode));*/
            // 通過轉換器匹配事件

            switch (keyCode) {

                // 當觸發Left 時

                case KeyEvent.VK_LEFT:
                    // 進行left 操作，僅符合move() 中[ 規範] 時執行，以下相同
                    playAction(Action.left);
                    break;
                // 當觸發Right 時
                case KeyEvent.VK_RIGHT:
                    playAction(Action.right);
                    break;
                // 當觸發Up 時
                case KeyEvent.VK_UP:
                    playAction(Action.up);
                    break;
                // 當觸發Down 時
                case KeyEvent.VK_DOWN:
                    playAction(Action.down);
                    break;
                // case KeyEvent.VK_X:
            }

        }
    }
}

