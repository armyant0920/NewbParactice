package Traffic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TestSampleA {
    private static final String dir = "";
    private final Color ROADCOLOR = Color.DARK_GRAY,//道路
            BLOCKCOLOR = Color.ORANGE;//建築?
    private final int DEFAULT_WIDTH = 400, DEFAULT_HEIGHT = 400;
    JPanel panel;
    private ActionListener actionListener;
    int delay = 500;//延遲時間(毫秒)
    int counter = 0;
    int row = 4, height = 4;
    private final String hintText = "delay:";
    private static JLabel speedText;
    static int[][] mapData;


    Timer timer;
    JFrame frame;

    TestSampleA() {
        Random rnd = new Random();

        mapData = new int[8][4];
        for (int i = 0; i < mapData.length; i++) {
            for (int j = 0; j < mapData[i].length; j++) {
                mapData[i][j] = rnd.nextInt(2);
                System.out.print(mapData[i][j]);
                if(j==mapData[i].length-1){
                    System.out.println();
                }
            }

        }


        frame = new JFrame("十字路口");
        frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT + 26);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int result = JOptionPane.showConfirmDialog(
                        frame, "EXIT?", "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (result == JOptionPane.YES_NO_OPTION) {
                    System.exit(0);
                }
            }
        });
        /*frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key=e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_UP:
                        if (delay >= 100) {
                            delay -= 100;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if(delay<=2000){
                            delay+=100;
                        }
                        break;
                }
                System.out.printf("delay:%d\n",delay);
            }
        });*/
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_UP:
                        if (delay > 100) {
                            delay -= 100;
                        } else if (delay <= 100 && delay > 10) {
                            delay -= 10;
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        if (delay < 2000) {
                            if (delay >= 100) {
                                delay += 100;
                            } else {
                                delay += 10;
                            }
                        }
                        break;
                }
                timer.setDelay(delay);
                speedText.setText(hintText + delay);
                System.out.printf("delay:%d\n", delay);

            }


            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("timer");
                if (e.getSource() == timer) {
                    counter++;
                    counter %= 8;
                    panel.repaint();
//                    System.out.printf("counter=%d\n", counter);

                }
            }
        };
        timer = new Timer(delay, actionListener);
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
//                System.out.println("paintComponent");

                //如果用左右橫邊的方式畫,就是4->3->2->1->0->1->2->3->4,

                /*if (counter <= 4) {
                    for (int i = 0; i < counter; i++) {
                        g.setColor(BLOCKCOLOR);
                        g.fillRect(0, i * 100, 100, 100);//一次劃一格

                        g.fillRect(300, i * 100, 100, 100);//一次劃一格
                        g.setColor(Color.BLACK);
                        g.drawString("L", 50, 50 + i * 100);
                        g.drawString("R", 350, 50 + i * 100);

                    }

                } else {

                    for (int i = 3; i >= (counter - 4); i--) {
                        g.setColor(BLOCKCOLOR);
                        g.fillRect(0, i * 100, 100, 100);//一次劃一格
                        g.fillRect(300, i * 100, 100, 100);//一次劃一格
                        g.setColor(Color.BLACK);
                        g.drawString("L", 50, 50 + i * 100);
                        g.drawString("R", 350, 50 + i * 100);
                    }

                }*/
                int current=counter;

                for (int i = 0; i < 4; i++) {

                    System.out.println("current:"+current);
                    for (int j = 0; j < mapData[current].length; j++) {
                        if (mapData[current][j] == 0) {
                            g.setColor(Color.BLACK);

                        } else {
                            g.setColor(Color.WHITE);
                        }
                        g.fillRect(j*100,i*100,100,100);
                    }
                    current += 1;
                    current %= 8;



                }





        }
    }

    ;

        panel.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        panel.setLayout(null);//取消預設排版方式
    speedText=new

    JLabel(hintText+delay);
        speedText.setForeground(Color.RED);
        speedText.setBounds(300,0,100,100);

        panel.add(speedText);
        panel.setBackground(ROADCOLOR);
        frame.add(panel);
        frame.setVisible(true);


}

    public void reset() {
        delay = 1;
        counter = 0;
        timer = new Timer(delay, actionListener);

    }

    public void start() {
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void timerSet() {
        if (timer.isRunning()) {
            timer.stop();


        } else {
            timer.start();
        }
        System.out.printf("timer is running:%b\n", timer.isRunning());
    }

    /**
     * 之後可能藉此調整參數
     */
    public void setParam() {


    }


}
