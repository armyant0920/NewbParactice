package LeetCode;

import java.util.Scanner;

public class Nst {

    private static int Num = 0;
    private static int st;//總共字元數
    private static int n;
    private static int digital;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("請輸入數字");//這裡是指第幾個數字
            //初始化計算參數
            n = input.nextInt();
            digital = 0;//位數
            st=0;
            Num=0;
            do {
                digital++;
                st += 9 * (int) Math.pow(10, digital - 1) * digital;//總共字元長度
                Num += 9 * (int) Math.pow(10, digital - 1);

            }
            while (st < n);

            int low = st - (9 * (int) Math.pow(10, digital - 1) * digital);
            System.out.println("底是" + low);


            System.out.println("輸入的數字是" + digital + "位數");
            System.out.println(n + "<" + st);
            System.out.println("減底後" + (n -= low));
            System.out.println("在" + digital + "位數中,mod為" + n / digital + "/" + n % digital);
            System.out.println(n + "是" + (low + (n / digital)) + "的" + n % digital);
            //System.out.println(Num);
        }


    }


}
