package LeeCode;

import java.util.Random;
import java.util.Scanner;

public class Poison {


    public static void main(String[] args) {
    //實驗結果只有T/F,輸入實驗樣本數,在有限實驗次數N下,計算至少需要多少受試者
        int buckets;//樣本數
        int N;//實驗次數
        int needPig;//需要的受試者

        Scanner input=new Scanner(System.in);
        while(true){
            System.out.println("輸入實驗樣本數");
            buckets=input.nextInt();
            System.out.println("輸入實驗次數");
            N=input.nextInt();
            needPig=(int)Math.ceil(Math.log(buckets)/Math.log(N));
            System.out.println("需要"+needPig+"個受試者");




        }
    }

    public void showDetail(int x,int y,int z){//x為實驗次數,y為受試者數,z為樣本數
        int poison= new Random().nextInt(z)+1;

        System.out.println("現在大獎在:"+poison);
        int buckets[]=new int[(int) Math.pow(x,y)];

        for(int i=0;i<x;i++){



        }



    }


}
