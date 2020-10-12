package Traffic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller {


    public static void main(String[] args) {

        TestSampleA test=new TestSampleA();
        test.start();
        JFrame mainFrame=new JFrame("主視窗");

        mainFrame.setSize(200,200);
        mainFrame.setResizable(false);
        JPanel panel=new JPanel();
        panel.setSize(mainFrame.getSize());
        panel.setBackground(Color.YELLOW);
        panel.setLayout(null);//如果沒改掉配置器,就無法隨意設定label
        System.out.println("Panel size:"+panel.getSize());

        JLabel label=new JLabel("點我",SwingConstants.CENTER);

        label.setOpaque(true);
        label.setBackground(Color.GREEN);
        label.setSize(panel.getSize());
        System.out.println("Label size:"+label.getSize());


        panel.add(label);
        mainFrame.add(panel);




        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

                test.timerSet();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {


            }
        });
        mainFrame.setVisible(true);
        System.out.println("real label size:"+label.getSize());
    }



}

