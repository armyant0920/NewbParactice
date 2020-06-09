package TestOfThread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShowTextB {

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();

        executorService.execute(new PrintTextB());
        executorService.execute(new PrintTextB());
        executorService.execute(new PrintTextB());
        Thread t1=new Thread(new PrintTextB());
        Thread t2=new Thread(new PrintTextB());
        Thread t3=new Thread(new PrintTextB());
        executorService.execute(t1);
        executorService.execute(t2);
        executorService.execute(t3);



        }

    }


     class PrintTextB implements Runnable {

    private int maxCount = 10;

    @Override
    synchronized

    public void run() {

        while (maxCount > 0) {

            System.out.println(Thread.currentThread().getName()+":"+maxCount);
            maxCount--;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
