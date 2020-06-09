package TestOfThread;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ShowText {


    static Thread t;
    public static void main(String[] args) {
//        ExecutorService es=Executors.newCachedThreadPool();
//        es.execute(new PrintText());
        t=createThread();

//        Runnable print = new PrintText();
//        Thread t = new Thread(print);
//        t.start();
        while(true) {
            try {
                Thread.sleep(1000);
                if (t.isAlive()) {
                    System.out.println("running...");

                } else {
                    t=null;
                    System.out.println("Create new Thread");
                    t=createThread();
                    continue;

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    static Thread createThread(){
        Runnable print=new PrintText();
        Thread t=new Thread(print);
        t.start();
        return t;
    }
}

    class PrintText implements Runnable{
        private int MaxTimes = 100;



        @Override
        public void run() {
            while(MaxTimes>0){

                System.out.println(MaxTimes);
                MaxTimes--;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

