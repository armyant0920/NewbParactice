package LeeCode.sort;

import java.util.Random;
import java.util.Scanner;

public class SingleNum {

    public static void main(String[] args) {
        System.out.println("輸入數字個數");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int nums[] = createNum(size);
        for (int i : nums) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.print("single的數字為:");
        singleCheck(nums);

    }


    static int[] createNum(int size) {

        Random rnd = new Random();
        int nums[] = new int[size];
        int index = size - 1;
        while (index >= 0) {//當數列還沒全部賦值
            int temp = 0;//初始化隨機數,儲存這一次要加入的隨機值
            boolean contain = true;

            while (contain == true) {//檢查數列中是否已經有這個數字,如果有重複,就重新取一個
                temp = rnd.nextInt(size) + 1;//產生隨機數字,至少要有size的一半才有足夠的range,而且會浪費大量時間檢查,所以直接給他size大小的範圍
                //另一個想法是,在這個方法裡面儲存已經用過的數字,來加快判斷的速度?

                System.out.println("temp為:"+temp);
                for (int i = 0; i < nums.length; i++) {
                    if (temp== nums[i]) {
                        System.out.println("temp="+temp+"數字已經存在" + temp);
                        contain = true;
                        break;

                    } else {
                        contain = false;
                    }
                }


            }

            if (index >= 1) {//當還剩下兩個以上的空間時,隨機決定要產生成對數字還是單獨的數字

                if (rnd.nextBoolean()==true) {//
                    for (int i = 1; i <= 2; i++) {
                        nums[index] = temp;//從數列的尾端開始加入
                        index--;
                    }

                } else {
                    nums[index] = temp;
                    index--;
                }

            } else {
                nums[index] = temp;
                index--;


            }
        }


        return nums;
    }


    static void singleCheck(int[] nums) {
        //先做最笨的,一個一個全跑完
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    temp++;
                }

            }
            if (temp == 1) {
                System.out.print(nums[i] + "\t");
            }

        }
    }
}
