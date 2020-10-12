package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class flower {

    private static List<Integer>flowers;
    public static void main(String[] args) {
        int min, max, current, length, temp;
        flowers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("input min");
        min = input.nextInt();
        System.out.println("input max");
        max = input.nextInt();

        current = min;
        while (current <= max) {
                check(current);
//            temp = 0;
//            String numString = String.valueOf(current);
//            length = numString.length();
//            for (int i = 0; i < length; i++) {
//
//                temp += Math.pow(Character.getNumericValue(numString.charAt(i)), length);
//            }
//
//
//            if (temp == current) {
//                flowers.add(current);
//            }
//
            current++;
        }

        System.out.println("pick:" + flowers);

    }

    public static void check(int n) {
        int len=0,result=0;
        //先求長度
        int cur = n;
        while(cur>0){
            cur/=10;
            len++;
        }
        cur=n;
        //知道長度,才開始計算每個位數的次方和

        do {
            int lastDigtal=cur%10;
            result+=Math.pow(lastDigtal,len);
            cur/=10;
        } while (cur > 0);
        if(result==n)
            flowers.add(result);

    }

}
