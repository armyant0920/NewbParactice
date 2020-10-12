package LeetCode;

import java.util.Random;
import java.util.Scanner;

public class Poison {

    public static void main(String[] args) {
        
        
        int buckets;// 樣本數
        int N;// 實驗次數
        int needPig;// 需要的受試者
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("輸入實驗樣本數");
            buckets = input.nextInt();
            System.out.println("輸入實驗次數");
            N = input.nextInt();
            while (N <= 0) {
                System.out.println("實驗次數至少須為1,請重新輸入");
                N = input.nextInt();
            }
            //能驗證的數字,一個受驗者可以驗證N+1個數字
            //例如實驗1次,表示可以驗證2個數,2個受驗者可以驗證2*2=4,如果是4次機會,就是5*5
            int Base = N + 1;
            //ceil解釋: 函式會回傳大於等於所給數字的最小整數。
            needPig = (int) Math.ceil(Math.log(buckets) / Math.log(Base));
            System.out.println("需要" + needPig + "個受試者,每個受試者測試" + Base + "個號碼(含0)");
            showDetail(Base, needPig, buckets);
        }
    }

    public static void showDetail(int x, int y, int z) {// x為實驗次數,y為受試者數,z為樣本數

        int poison = new Random().nextInt(z) + 1;
        System.out.println("大獎位置:" + poison);
        StringBuilder sb = new StringBuilder();
        for (int i = y; i > 0; i--) {//有幾個受試者,就有幾個號碼

            for (int j = 0; j < x; j++) {//這邊是最高次方

                int temp = (int) (poison - Math.pow(x, i - 1));
                if (temp >= 0) {
                    poison = temp;
                } else {
                    System.out.println("第" + (y + 1 - i) + "位數字為" + j);
                    sb.append(j);
                    break;
                }
            }
        }

        System.out.println("顯示各輪狀況");
        int alive = y;
        for (int i = 0; i < x - 1; i++) {//輪數

            if (alive == 0) {
                break;
            }

            System.out.println("第" + (i + 1) + "輪數字是" + i);
            for (int j = 0; j < y; j++) {//遍歷每個受驗者

                if (Character.getNumericValue(sb.charAt(j)) == i) {
                    System.out.println(j + 1 + "號豬這一輪掛了");
                    System.out.println("剩下" + --alive + "隻");
                }
            }
        }
        System.out.println("中毒號碼為" + sb.toString() + ",倖存小豬數量為:" + alive);
    }
}
