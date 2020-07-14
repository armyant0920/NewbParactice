package LeeCode;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Random;
import java.util.Scanner;

public class TwoSum {
    /*	Given an array of integers,
	return indices of the two numbers such that they add up to a specific target.
	You may assume that each input would have exactly one solution,
	and you may not use the same element twice.*/


    public static void main(String[] args) {
        int target = 0;//兩數相加
        int add = 0;

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("請輸入數組,中間用\",\"分隔");
            String inputText[] = input.nextLine().split(",");
            int nums[] = new int[inputText.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(inputText[i]);
            }

            target = nums[new Random().nextInt(nums.length)];

            do {
                add = nums[new Random().nextInt(nums.length)];
            } while (target == add);
            target += add;
            System.out.print("輸入數組為:");
            for (int n : nums) {
                System.out.print(n + " ");
            }
            System.out.println();
            System.out.print("目標值為" + target);
            System.out.println();

            int answer[] = (getAnswer(nums, target));
            System.out.print("位置是");
            for (int num : answer) {
                System.out.print(num + " ");
            }

            System.out.println();

        }
    }

    static int[] getAnswer(int[] nums, int target) {

        int answer[] = new int[2];
        for (int i = 0; i < nums.length; i++) {

            for (int j = +1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
}
