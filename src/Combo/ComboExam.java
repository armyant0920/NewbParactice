package Combo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.Scanner;
import java.util.TimerTask;

public class ComboExam implements KeyListener {
    private static Queue<String>orders;
    private int x;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        while(true){


        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode=e.getKeyCode();
        String keyText=e.getKeyText(e.getKeyCode());
        orders.add(keyText);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    class ComboTask extends TimerTask{
      @Override
      public void run() {

          System.out.println(orders.poll());
          System.out.println(orders);

      }
  }
}
