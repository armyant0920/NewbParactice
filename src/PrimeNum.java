import org.w3c.dom.ranges.RangeException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeNum {


    public static void main(String[] args) {
        while (true) {
            try {
                Scanner input = new Scanner(System.in);

                System.out.println("請輸入範圍(>2)");
                if (!input.hasNextInt()) {
                    throw new InputMismatchException("輸入型別不正確");
                }
                int max = input.nextInt();

                if (max < 2) {
                    throw new InputMismatchException("範圍須大於2");

                }
                System.out.println("輸入1:原始方式\n輸入2.:改良方式");
                if (!input.hasNextInt()) {
                    throw new InputMismatchException("輸入型別不正確");
                }

                int mode = input.nextInt();
                if (mode < 1 || mode > 2) {
                    throw new InputMismatchException("Error");

                }


                Date start = new Date();
                if (mode == 1) {
                    countMethod1(max);
                } else if (mode == 2) {
                    countMethod2(max);
                }

                Date end = new Date();
                countTime("花費時間", start, end);

            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 直覺方法
     *
     * @param max
     */

    private static void countMethod1(int max) {
        boolean prime = true;
        int count = 0;
        int percentage=0;
        for (int i = 3; i < max; i++) {
            prime=true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
//                System.out.print(i + "\t");
                count++;
            }
            if(i*100/max>percentage){
                percentage+=2;
                System.out.printf("完成進度%d %%\n",percentage);
            }
        }
        System.out.println();
        System.out.printf("質數共有%d個\n", count);


    }

    /**
     * 改良方法
     *
     * @param max
     */
    private static void countMethod2(int max) {

        boolean prime = true;
        int count = 0;
        int percentage=0;
        for (int i = 3; i < max; i += 2) {

            prime = true;


            if (i % 2 == 0) {
                prime = false;
            } else {
                for (int j = 3; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        prime = false;
                        break;
                    }
                }
            }
            if (prime) {
//                System.out.print(i + " ");
                count++;
            }
            if(i*100/max>percentage){
                percentage+=2;
                System.out.printf("完成進度%d %%\n",percentage);
            }
        }
        System.out.println();
        System.out.printf("質數共有%d個\n", count);

    }

    private static String converDate(Date date) {
        SimpleDateFormat sd = new SimpleDateFormat("hh-mm-ss-SSS");
        return sd.format(date);
    }

    private static void countTime(String s, Date t1, Date t2) {

        long diff = t2.getTime() - t1.getTime();
        System.out.printf("%s開始時間:%s\n", s, converDate(t1));
        System.out.printf("%s結束時間:%s\n", s, converDate(t2));
        System.out.printf("%s花費時間 %dms\n", s, diff);


    }
}

