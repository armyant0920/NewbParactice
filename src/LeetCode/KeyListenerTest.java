package LeetCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerTest extends JPanel implements KeyListener {

    public KeyListenerTest(){

        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();

        setPreferredSize(d);
        setFocusable(true);
        addKeyListener(this);

    }


    public static void main(String[] args) {
        KeyListenerTest test=new KeyListenerTest();
        while (true){

        }



    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
            System.out.println(e.getKeyCode());
            System.out.println(e.getWhen());
            System.out.println(e.paramString());
            System.out.println(e.toString());
            System.out.println(e.getKeyText(keyCode));
        // 通過轉換器匹配事件

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
